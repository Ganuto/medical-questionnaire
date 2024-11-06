package com.project.manual.medicalquestionnaire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import com.project.manual.medicalquestionnaire.controller.data.request.QuestionnaireRecommendationRequest;
import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.controller.data.response.RecommendationResponse;
import com.project.manual.medicalquestionnaire.domain.ProductRecommendationRule;
import com.project.manual.medicalquestionnaire.domain.Questionnaire;
import com.project.manual.medicalquestionnaire.domain.RuleCondition;
import com.project.manual.medicalquestionnaire.mock.ProductRecommendationMock;
import com.project.manual.medicalquestionnaire.mock.QuestionnaireMock;
import com.project.manual.medicalquestionnaire.repository.QuestionnaireRepository;
import com.project.manual.medicalquestionnaire.repository.RecommendationRuleRepository;
import com.project.manual.medicalquestionnaire.service.impl.QuestionnaireServiceImpl;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.webjars.NotFoundException;

@RunWith(SpringRunner.class)
public class QuestionnaireServiceTest {

  @SpyBean private QuestionnaireServiceImpl questionnaireService;
  @MockBean private QuestionnaireRepository questionnaireRepository;
  @MockBean private RecommendationRuleRepository recommendationRuleRepository;

  @Test
  public void findAllSuccessfully() {
    QuestionnaireResponse questionnaireResponseMock =
        QuestionnaireMock.createQuestionnaireResponseMock();

    when(questionnaireService.findAll()).thenReturn(List.of(questionnaireResponseMock));

    List<QuestionnaireResponse> questionnaireResponses = questionnaireService.findAll();
    QuestionnaireResponse questionnaireResponse = questionnaireResponses.getFirst();

    assertEquals(questionnaireResponseMock.getId(), questionnaireResponse.getId());
    assertEquals(questionnaireResponseMock.getTitle(), questionnaireResponse.getTitle());
    assertEquals(questionnaireResponseMock.getCreatedAt(), questionnaireResponse.getCreatedAt());
    assertEquals(questionnaireResponseMock.getQuestions(), questionnaireResponse.getQuestions());

    verify(questionnaireRepository).findAll();
  }

  @Test
  public void findByIdSuccessfully() {
    Questionnaire questionnaireMock = QuestionnaireMock.createQuestionnaireMock();

    when(questionnaireRepository.findById(anyString())).thenReturn(Optional.of(questionnaireMock));

    QuestionnaireResponse questionnaireResponse =
        questionnaireService.findById(questionnaireMock.getId());

    assertEquals(questionnaireMock.getId(), questionnaireResponse.getId());
    assertEquals(questionnaireMock.getTitle(), questionnaireResponse.getTitle());
    assertEquals(questionnaireMock.getCreatedAt(), questionnaireResponse.getCreatedAt());
    assertEquals(questionnaireMock.getQuestions(), questionnaireResponse.getQuestions());

    verify(questionnaireRepository).findById(questionnaireMock.getId());
  }

  @Test
  public void findByIdThenThrowsNotFoundException() {
    when(questionnaireRepository.findById(anyString())).thenReturn(Optional.empty());
    assertThrows(
        NotFoundException.class, () -> questionnaireService.findById("8029565399d62832fd94b645"));
  }

  @Test
  public void processRecommendationSuccessfully() {
    QuestionnaireRecommendationRequest questionnaireRecommendationRequestMock =
        QuestionnaireMock.createQuestionnaireRecommendationRequestMock();
    ProductRecommendationRule productRecommendationRuleMock =
        ProductRecommendationMock.createProductRecommendationRuleMock();
    RecommendationResponse recommendationResponseMock =
        ProductRecommendationMock.createRecommendationResponseMock();

    when(recommendationRuleRepository.findByQuestionnaireIdAndConditionsIn(
            anyString(), any(RuleCondition.class)))
        .thenReturn(Optional.of(productRecommendationRuleMock));

    RecommendationResponse recommendationResponse =
        questionnaireService.processRecommendation(questionnaireRecommendationRequestMock);

    assertEquals(
        recommendationResponseMock.getRecommendedProducts(),
        recommendationResponse.getRecommendedProducts());

    verify(recommendationRuleRepository)
        .findByQuestionnaireIdAndConditionsIn(anyString(), any(RuleCondition.class));
  }

  @Test
  public void processRecommendationThenThrowsNotFoundException() {
    QuestionnaireRecommendationRequest questionnaireRecommendationRequestMock =
        QuestionnaireMock.createQuestionnaireRecommendationRequestMock();

    when(recommendationRuleRepository.findByQuestionnaireIdAndConditionsIn(
            anyString(), any(RuleCondition.class)))
        .thenReturn(Optional.empty());

    assertThrows(
        NotFoundException.class,
        () -> questionnaireService.processRecommendation(questionnaireRecommendationRequestMock));
  }
}
