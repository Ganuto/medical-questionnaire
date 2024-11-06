package com.project.manual.medicalquestionnaire.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.project.manual.medicalquestionnaire.controller.data.request.QuestionnaireRecommendationRequest;
import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.controller.data.response.RecommendationResponse;
import com.project.manual.medicalquestionnaire.domain.Choice;
import com.project.manual.medicalquestionnaire.domain.Question;
import com.project.manual.medicalquestionnaire.mock.QuestionnaireMock;
import com.project.manual.medicalquestionnaire.service.QuestionnaireService;
import com.project.manual.medicalquestionnaire.util.TestUtils;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = QuestionnaireController.class)
public class QuestionnaireControllerTest {
  @Autowired private MockMvc mockMvc;

  @MockBean private QuestionnaireService questionnaireService;

  @Test
  public void getAllSuccessfully() throws Exception {
    QuestionnaireResponse questionnaireResponseMock =
        QuestionnaireMock.createQuestionnaireResponseMock();
    Question questionsMock = questionnaireResponseMock.getQuestions().getFirst();
    Choice choice = questionsMock.getChoices().getFirst();

    when(questionnaireService.findAll()).thenReturn(List.of(questionnaireResponseMock));

    mockMvc
        .perform(get("/api/questionnaires").contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$.[0].id").value(questionnaireResponseMock.getId()))
        .andExpect(jsonPath("$.[0].title").value(questionnaireResponseMock.getTitle()))
        .andExpect(jsonPath("$.[0].enabled").value(questionnaireResponseMock.isEnabled()))
        .andExpect(jsonPath("$.[0].questions.[0].id").value(questionsMock.getId()))
        .andExpect(jsonPath("$.[0].questions.[0].title").value(questionsMock.getTitle()))
        .andExpect(jsonPath("$.[0].questions.[0].order").value(questionsMock.getOrder()))
        .andExpect(jsonPath("$.[0].questions.[0].choices.[0].id").value(choice.getId()))
        .andExpect(jsonPath("$.[0].questions.[0].choices.[0].value").value(choice.getValue()))
        .andExpect(
            jsonPath("$.[0].questions.[0].choices.[0].next_question_id")
                .value(choice.getNextQuestionId()))
        .andExpect(jsonPath("$.[0].questions.[0].choices.[0].sub_questions").doesNotExist())
        .andExpect(jsonPath("$.[0].created_at").exists());
  }

  @Test
  public void getByIdSuccessfully() throws Exception {
    QuestionnaireResponse questionnaireResponseMock =
        QuestionnaireMock.createQuestionnaireResponseMock();
    Question questionsMock = questionnaireResponseMock.getQuestions().getFirst();
    Choice choice = questionsMock.getChoices().getFirst();

    when(questionnaireService.findById(anyString())).thenReturn(questionnaireResponseMock);

    mockMvc
        .perform(
            get("/api/questionnaires/questionnaire/{id}", questionnaireResponseMock.getId())
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(questionnaireResponseMock.getId()))
        .andExpect(jsonPath("$.title").value(questionnaireResponseMock.getTitle()))
        .andExpect(jsonPath("$.enabled").value(questionnaireResponseMock.isEnabled()))
        .andExpect(jsonPath("$.questions.[0].id").value(questionsMock.getId()))
        .andExpect(jsonPath("$.questions.[0].title").value(questionsMock.getTitle()))
        .andExpect(jsonPath("$.questions.[0].order").value(questionsMock.getOrder()))
        .andExpect(jsonPath("$.questions.[0].choices.[0].id").value(choice.getId()))
        .andExpect(jsonPath("$.questions.[0].choices.[0].value").value(choice.getValue()))
        .andExpect(
            jsonPath("$.questions.[0].choices.[0].next_question_id")
                .value(choice.getNextQuestionId()))
        .andExpect(jsonPath("$.questions.[0].choices.[0].sub_questions").doesNotExist())
        .andExpect(jsonPath("$.created_at").exists());
  }

  @Test
  public void getByIdAndReturnBadRequest() throws Exception {
    mockMvc
        .perform(
            get("/api/questionnaires/questionnaire/{id}", "WRONG_ID")
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("timestamp").exists())
        .andExpect(jsonPath("http_status").value(HttpStatus.BAD_REQUEST.getReasonPhrase()))
        .andExpect(jsonPath("error_message").value("Id must match ^[a-f\\d]{24}$"));
  }

  @Test
  public void getRecommendationSuccessfully() throws Exception {
    RecommendationResponse recommendationResponseMock = new RecommendationResponse();
    recommendationResponseMock.setRecommendedProducts(List.of("TADALAFIL_20"));
    QuestionnaireRecommendationRequest questionnaireRecommendationRequest =
        QuestionnaireMock.createQuestionnaireRecommendationRequestMock();

    when(questionnaireService.processRecommendation(any(QuestionnaireRecommendationRequest.class)))
        .thenReturn(recommendationResponseMock);

    mockMvc
        .perform(
            post("/api/questionnaires/questionnaire/submit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.convertObjectToJsonString(questionnaireRecommendationRequest)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.recommended_products").isArray())
        .andExpect(jsonPath("$.recommended_products.[0]").value("TADALAFIL_20"));
  }
}
