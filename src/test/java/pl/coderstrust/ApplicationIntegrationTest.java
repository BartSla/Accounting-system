package pl.coderstrust;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.coderstrust.config.ObjectMapperProvider;
import pl.coderstrust.persistence.InvoiceProvider;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ApplicationIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapperProvider objectMapper;

    @Test
    public void shouldIntegrationAddAndGetByIdTestWorks() throws Exception {

        //post new invoice
        this.mockMvc
                .perform(post("/invoice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new InvoiceProvider().invoice)))
                .andDo(print())
                .andExpect(status().isOk());

        //get invoice by id
        Object obj = this.mockMvc
                .perform(get("/invoice/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(asJsonString(new InvoiceProvider().invoice), obj);
    }

        @Test
    public void shouldIntegrationUpdateTestWorks() throws Exception {

        //post new invoice
        this.mockMvc
                .perform(post("/invoice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new InvoiceProvider().invoice)))
                .andDo(print())
                .andExpect(status().isOk());

        //update invoice
        this.mockMvc
                .perform(put("/invoice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new InvoiceProvider().invoiceToUpdate)))
                .andDo(print())
                .andExpect(status().isOk());

        //get updated invoice
        Object obj = this.mockMvc
                .perform(get("/invoice/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(asJsonString(new InvoiceProvider().invoiceToUpdate), obj);
    }

    @Test
    public void shouldIntegrationRemoveAndGetAllTestWorks() throws Exception {

        //post new invoice
        this.mockMvc
                .perform(post("/invoice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new InvoiceProvider().invoice)))
                .andDo(print())
                .andExpect(status().isOk());

        //remove invoice
        this.mockMvc
                .perform(delete("/invoice/0"))
                .andDo(print())
                .andExpect(status().isOk());

        //get all invoices
        Object obj = this.mockMvc
                .perform(get("/invoices"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Object expected = "[ ]";

        assertEquals(expected, obj);
    }

    @Test
    public void shouldIntegrationDateRangeTestWorks() throws Exception {

        //post a few new invoice
        this.mockMvc
                .perform(post("/invoice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new InvoiceProvider().invoice)))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc
                .perform(post("/invoice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new InvoiceProvider().invoice1)))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc
                .perform(post("/invoice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new InvoiceProvider().invoice2)))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc
                .perform(post("/invoice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new InvoiceProvider().invoice3)))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc
                .perform(post("/invoice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new InvoiceProvider().invoice4)))
                .andDo(print())
                .andExpect(status().isOk());

        //get all invoices in date range
        Object obj = this.mockMvc
                .perform(get("/invoicesByDate?from=2018-01-30&to=2018-02-03"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(asJsonString(new InvoiceProvider().getListOf3Invoices()), obj);
    }

    public String asJsonString(final Object obj) {
        try {
            return objectMapper.objectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
