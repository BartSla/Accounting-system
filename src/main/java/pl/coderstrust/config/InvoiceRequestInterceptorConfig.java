package pl.coderstrust.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.coderstrust.interceptor.InvoiceRequestInterceptor;

@EnableWebMvc
@Configuration
public class InvoiceRequestInterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InvoiceRequestInterceptor invoiceRequestInterceptor() {
        return new InvoiceRequestInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(invoiceRequestInterceptor())
                .addPathPatterns("/**");
    }
}
