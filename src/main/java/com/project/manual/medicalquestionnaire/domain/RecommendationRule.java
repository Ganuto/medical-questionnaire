package com.project.manual.medicalquestionnaire.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Document(collection = "recommendation_rule")
public class RecommendationRule {
  @MongoId(FieldType.OBJECT_ID)
  private String id;
  private boolean isRejection;
  private String questionnaireId;
  private List<RuleCondition> conditions;
  private List<String> recommendedProductIds;
}
