package com.project.manual.medicalquestionnaire.service.impl;

import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.mapper.QuestionnaireMapper;
import com.project.manual.medicalquestionnaire.repository.QuestionnaireRepository;
import com.project.manual.medicalquestionnaire.service.QuestionnaireService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {
  private final QuestionnaireRepository questionnaireRepository;

  @Override
  public List<QuestionnaireResponse> findAll() {
    return QuestionnaireMapper.toResponseList(questionnaireRepository.findAll());
  }


}
