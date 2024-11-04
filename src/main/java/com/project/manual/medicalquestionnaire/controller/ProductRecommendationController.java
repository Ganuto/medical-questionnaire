package com.project.manual.medicalquestionnaire.controller;

import com.project.manual.medicalquestionnaire.controller.data.request.ProductRecommendationRequest;
import com.project.manual.medicalquestionnaire.domain.Product;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-recommendations")
public class ProductRecommendationController {

  @PostMapping
  public ResponseEntity<List<Product>> getProductRecommendation(
      @RequestBody @Valid ProductRecommendationRequest productRecommendationRequest) {
    return null;
  }
}
