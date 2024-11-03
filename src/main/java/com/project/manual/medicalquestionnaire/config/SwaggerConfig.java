package com.project.manual.medicalquestionnaire.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi openApi() {
    return GroupedOpenApi.builder().group("medical-questionnaire-api").pathsToMatch("/**").build();
  }

  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI().info(new Info().title("Manual - Medical Questionnaire").version("1.0.0"));
  }

  @Bean
  public ModelResolver modelResolver(ObjectMapper objectMapper) {
    return new ModelResolver(objectMapper);
  }
}
