package com.project.manual.medicalquestionnaire.service.impl;

import com.project.manual.medicalquestionnaire.controller.data.request.QuestionnaireAnswerRequest;
import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.domain.*;
import com.project.manual.medicalquestionnaire.mapper.QuestionnaireMapper;
import com.project.manual.medicalquestionnaire.repository.QuestionnaireRepository;
import com.project.manual.medicalquestionnaire.repository.RecommendationRuleRepository;
import com.project.manual.medicalquestionnaire.service.QuestionnaireService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {
  private final QuestionnaireRepository questionnaireRepository;
  private final RecommendationRuleRepository recommendationRuleRepository;

  @Override
  public List<QuestionnaireResponse> findAll() {
    return QuestionnaireMapper.toResponseList(questionnaireRepository.findAll());
  }

  public QuestionnaireResponse findById(String id) {
    Questionnaire questionnaire =
        questionnaireRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new NotFoundException(
                        String.format("Questionnaire with id: [%s] not found.", id)));
    return QuestionnaireMapper.toResponse(questionnaire);
  }

  @Override
  public List<String> processRecommendation(QuestionnaireAnswerRequest questionnaireAnswerRequest) {
    QuestionnaireAnswer questionnaireAnswer =
        QuestionnaireMapper.toQuestionnaireAnswer(questionnaireAnswerRequest);
    return extractRecommendedProductIds(questionnaireAnswer);
  }

  private List<String> extractRecommendedProductIds(QuestionnaireAnswer questionnaireAnswer) {
    List<String> recommendedProducts = new ArrayList<>();
    for (Answer answer : questionnaireAnswer.getAnswers()) {
      RuleCondition ruleCondition = QuestionnaireMapper.toRuleCondition(answer);
      ProductRecommendationRule productRecommendationRule =
          findRecommendationRule(questionnaireAnswer.getQuestionnaireId(), ruleCondition);
      if (productRecommendationRule.isRejection()) {
        return List.of();
      }
      if (productRecommendationRule.getRecommendedProductIds() != null) {
        recommendedProducts.addAll(productRecommendationRule.getRecommendedProductIds());
      }
    }
    return recommendedProducts;
  }

  private ProductRecommendationRule findRecommendationRule(
      String questionnaireId, RuleCondition ruleCondition) {
    Optional<ProductRecommendationRule> recommendationRuleOptional =
        recommendationRuleRepository.findByQuestionnaireIdAndConditionsIn(
            questionnaireId, ruleCondition);
    return recommendationRuleOptional.orElseThrow(
        () ->
            new NotFoundException(
                String.format(
                    "Recommendation rule not found for answer [%s] with questionnaire id [%s]",
                    ruleCondition, questionnaireId)));
  }
}
