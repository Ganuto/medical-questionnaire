package com.project.manual.medicalquestionnaire;

import io.restassured.RestAssured;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ActiveProfiles("test")
@ContextConfiguration(classes = {Application.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@ComponentScan(basePackageClasses = {ApplicationIT.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationIT {

  @LocalServerPort Integer port;

  @Before
  public void setUp() {
    RestAssured.baseURI = "http://localhost";
    RestAssured.port = port;
  }
}
