package com.github.billy.bar.solver.domain;

import com.github.billy.bar.common.domain.BaseDomain;
import com.github.billy.bar.common.type.Data;
import com.github.billy.bar.common.type.Id;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.Valid;
import java.util.List;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Kata extends BaseDomain {

  @EqualsAndHashCode.Include
  List<@Valid Data> dataset;

  @Builder
  public Kata(@Valid Id id, List<Data> dataset) {
    super(id);
    this.dataset = dataset;
  }
}
