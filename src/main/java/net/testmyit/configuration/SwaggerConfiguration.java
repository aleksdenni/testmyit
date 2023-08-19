package net.testmyit.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI TestMyItOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("testMyIT API")
                        .description("API for a quiz application")
                        .version("v0.0.1")
                        .contact(new Contact().name("Aleks")
                        .url("https://www.linkedin.com/in/oleksii-chekaliuk-805519154")
                        .email("aleksdenni@gmail.com")));
    }
}