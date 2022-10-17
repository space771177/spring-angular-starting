package com.survey.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
  info =@Info(
    title = "Computer Science Survey API",
    version = "${api.version}",
    description = "${api.description}"
  ),
  servers = @Server(
    url = "${api.server.url}",
    description = "Production"
  )
)
public class OpenAPISecurityConfiguration {}