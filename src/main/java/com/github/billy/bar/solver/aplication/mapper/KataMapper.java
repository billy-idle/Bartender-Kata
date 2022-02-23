package com.github.billy.bar.solver.aplication.mapper;

import com.github.billy.bar.common.type.Data;
import com.github.billy.bar.common.type.Id;
import com.github.billy.bar.solver.adapter.out.persistence.DatasetJpaEntity;
import com.github.billy.bar.solver.domain.Kata;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface KataMapper {

  default Kata toKata(DatasetJpaEntity datasetJpaEntity) {

    List<Data> dataset = Stream.of(datasetJpaEntity.getArrayDataset().split(","))
                               .map(Integer::valueOf)
                               .map(Data::new)
                               .collect(Collectors.toList());

    return Kata.builder()
               .id(new Id(datasetJpaEntity.getId()))
               .dataset(dataset)
               .build();
  }
}
