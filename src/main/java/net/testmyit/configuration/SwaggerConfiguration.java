package net.testmyit.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI TestMyItOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("testMyIT API")
                        .description("API for a quiz")
                        .version("v0.0.1")
                        .contact(new Contact()
                                .name("aleksdenni")
                                .url("https://www.linkedin.com/in/%D0%BE%D0%BB%D0%B5%D0%BA%D1%81%D1%96%D0%B9-%D1%87%D0%B5%D0%BA%D0%B0%D0%BB%D1%8E%D0%BA-805519154?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_view_base_contact_details%3B4ySYswnPSqeRTW3I87vvZw%3D%3D"))

                )
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")));
    }
}