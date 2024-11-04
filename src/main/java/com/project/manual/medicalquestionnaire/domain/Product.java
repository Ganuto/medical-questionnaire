package com.project.manual.medicalquestionnaire.domain;

import com.project.manual.medicalquestionnaire.domain.exception.BusinessException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Product {
  SILDENAFIL_50(1),
  TADALAFIL_10(2);

  private final Integer id;

  public static Product getById(int id) {
    for (Product operationType : values()) {
      if (operationType.id.equals(id)) {
        return operationType;
      }
    }
    throw new BusinessException(
        String.format("The informed product with ID [%s] doesn't exist.", id));
  }
}
