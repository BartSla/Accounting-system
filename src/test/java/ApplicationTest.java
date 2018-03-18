import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderstrust.Application;
import pl.coderstrust.config.ObjectMapperProvider;
import pl.coderstrust.controller.InvoiceController;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.processing.InvoiceBook;

import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    //FIXME: no - in here there should not be mocks - this is integration test - it should run on production application configuration. The only change may/should be on database level
    //if you have File database configuraiton, you should have separate one for this test to not write on production DB - just on test one
    @MockBean
    private InvoiceBook invoiceBook;

    @Before
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(new InvoiceController(invoiceBook))
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void shouldGetAllInvoicesWorks() throws Exception {
        when(invoiceBook.getAllInvoices()).thenReturn(Arrays.asList());

        this.mockMvc
                .perform(get("/invoices"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
    }

    @Test
    public void shouldGetInvoiceWorks() throws Exception {
        when(invoiceBook.getInvoiceById(0)).thenReturn(new Invoice());

        this.mockMvc
                .perform(get("/invoice/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }

    @Test
    public void shouldRemoveInvoiceWorks() throws Exception {

        this.mockMvc
                .perform(delete("/invoice/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }

    @Test
    public void shouldUpdateInvoiceWorks() throws Exception {

        this.mockMvc
                .perform(put("/invoice").contentType(MediaType.APPLICATION_JSON).content(asJsonString(new Invoice())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }

    @Test
    public void shouldAddInvoiceWorks() throws Exception {

        this.mockMvc
                .perform(post("/invoice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new Invoice())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }

    @Test
    public void shouldGetAllInvoicesInDateRangeWorks() throws Exception {
        LocalDate from = LocalDate.of(2018, 2, 3);
        LocalDate to = LocalDate.of(2018, 2, 9);
        when(invoiceBook.getAllInvoicesInDateRange(from, to)).thenReturn(Arrays.asList());

        this.mockMvc
                .perform(get("/invoicesByDate?from=2018-02-03&to=2018-02-09"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapperProvider().objectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}