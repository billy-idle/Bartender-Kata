package com.github.billy.bar.solver.aplication.port.out;

import com.github.billy.bar.solver.domain.Kata;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
public interface GetDatasetOutputPort {

  @Valid Kata getById(@Positive Integer id);
}
