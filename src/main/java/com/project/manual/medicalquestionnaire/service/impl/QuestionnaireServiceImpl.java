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
    return getRecommendations(questionnaireAnswer);
  }

  private List<String> getRecommendations(QuestionnaireAnswer questionnaireAnswer) {
    List<String> recommendedProducts = new ArrayList<>();
    for (Answer answer : questionnaireAnswer.getAnswers()) {
      RuleCondition ruleCondition = QuestionnaireMapper.toRuleCondition(answer);
      Optional<RecommendationRule> recommendationRuleOptional =
          recommendationRuleRepository.findByQuestionnaireIdAndConditionsIn(
              questionnaireAnswer.getQuestionnaireId(), ruleCondition);
      RecommendationRule recommendationRule =
          recommendationRuleOptional.orElseThrow(
              () ->
                  new NotFoundException(
                      String.format(
                          "Recommendation rule not found for answer [%s] with questionnaire id [%s]",
                          answer, questionnaireAnswer.getQuestionnaireId())));
      if (recommendationRule.isRejection()) {
        return List.of();
      }
      if (recommendationRule.getRecommendedProductIds() != null) {
        recommendedProducts.addAll(recommendationRule.getRecommendedProductIds());
      }
    }
    return recommendedProducts;
  }
}
