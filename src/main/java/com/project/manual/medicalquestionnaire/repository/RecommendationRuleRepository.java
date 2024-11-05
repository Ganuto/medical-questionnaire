package com.project.manual.medicalquestionnaire.repository;

import com.project.manual.medicalquestionnaire.domain.RecommendationRule;
import com.project.manual.medicalquestionnaire.domain.RuleCondition;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RecommendationRuleRepository extends MongoRepository<RecommendationRule, String> {
  Optional<RecommendationRule> findByQuestionnaireIdAndConditionsIn(
      String questionnaireId, RuleCondition ruleCondition);
}
