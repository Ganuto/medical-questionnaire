package com.project.manual.medicalquestionnaire;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.domain.Questionnaire;
import com.project.manual.medicalquestionnaire.repository.QuestionnaireRepository;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class QuestionnaireIT extends ApplicationIT {

  @Autowired private ObjectMapper objectMapper;
  @Autowired private QuestionnaireRepository questionnaireRepository;

  @Test
  public void findAllSuccessfully() throws JsonProcessingException {
    String response =
        IntegrationRequests.get("api/questionnaires")
            .then()
            .assertThat()
            .statusCode(HttpStatus.OK.value())
            .extract()
            .response()
            .asString();

    List<QuestionnaireResponse> questionnaireResponseList =
        objectMapper.readValue(response, new TypeReference<>() {});

    List<Questionnaire> questionnaires = questionnaireRepository.findAll();

    assertEquals(questionnaires.size(), questionnaireResponseList.size());
    assertEquals(questionnaires.getFirst().getId(), questionnaireResponseList.getFirst().getId());
    assertEquals(
        questionnaires.getFirst().getTitle(), questionnaireResponseList.getFirst().getTitle());
    assertEquals(
        questionnaires.getFirst().getCreatedAt(),
        questionnaireResponseList.getFirst().getCreatedAt());
    assertEquals(
        questionnaires.getFirst().getQuestions().getFirst().getId(),
        questionnaireResponseList.getFirst().getQuestions().getFirst().getId());
    assertEquals(
        questionnaires.getFirst().getQuestions().getFirst().getTitle(),
        questionnaireResponseList.getFirst().getQuestions().getFirst().getTitle());
    assertEquals(
        questionnaires.getFirst().getQuestions().getFirst().getOrder(),
        questionnaireResponseList.getFirst().getQuestions().getFirst().getOrder());
    assertEquals(
        questionnaires.getFirst().getQuestions().getFirst().getChoices().getFirst().getId(),
        questionnaireResponseList
            .getFirst()
            .getQuestions()
            .getFirst()
            .getChoices()
            .getFirst()
            .getId());
    assertEquals(
        questionnaires.getFirst().getQuestions().getFirst().getChoices().getFirst().getValue(),
        questionnaireResponseList
            .getFirst()
            .getQuestions()
            .getFirst()
            .getChoices()
            .getFirst()
            .getValue());
    assertEquals(
        questionnaires
            .getFirst()
            .getQuestions()
            .getFirst()
            .getChoices()
            .getFirst()
            .getNextQuestionId(),
        questionnaireResponseList
            .getFirst()
            .getQuestions()
            .getFirst()
            .getChoices()
            .getFirst()
            .getNextQuestionId());
    assertEquals(
        questionnaires
            .getFirst()
            .getQuestions()
            .getFirst()
            .getChoices()
            .getFirst()
            .getSubQuestionId(),
        questionnaireResponseList
            .getFirst()
            .getQuestions()
            .getFirst()
            .getChoices()
            .getFirst()
            .getSubQuestionId());
  }
}
