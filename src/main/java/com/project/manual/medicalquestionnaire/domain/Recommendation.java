package com.project.manual.medicalquestionnaire.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recommendation {
  private List<String> recommendedProducts;
}
