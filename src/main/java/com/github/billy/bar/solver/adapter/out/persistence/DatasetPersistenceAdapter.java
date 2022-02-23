package com.github.billy.bar.solver.adapter.out.persistence;

import com.github.billy.bar.common.annotation.PersistenceAdapter;
import com.github.billy.bar.solver.aplication.mapper.KataMapper;
import com.github.billy.bar.solver.aplication.port.out.GetDatasetOutputPort;
import com.github.billy.bar.solver.domain.Kata;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@PersistenceAdapter
@RequiredArgsConstructor
@Transactional
public class DatasetPersistenceAdapter implements GetDatasetOutputPort {

  private final DatasetRepository datasetRepository;
  private final KataMapper kataMapper;

  @Override
  public Kata getById(Integer id) {
    return kataMapper.toKata(datasetRepository.getById(id));
  }
}
