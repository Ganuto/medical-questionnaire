package com.project.manual.medicalquestionnaire.repository;

import com.project.manual.medicalquestionnaire.domain.ProductRecommendationRule;
import com.project.manual.medicalquestionnaire.domain.RuleCondition;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RecommendationRuleRepository extends MongoRepository<ProductRecommendationRule, String> {
  Optional<ProductRecommendationRule> findByQuestionnaireIdAndConditionsIn(
      String questionnaireId, RuleCondition ruleCondition);
}
