package com.github.billy.bar.solver.aplication.service;

import com.github.billy.bar.common.annotation.UseCase;
import com.github.billy.bar.solver.aplication.port.in.OutputResponseModel;
import com.github.billy.bar.solver.aplication.port.in.SetupRequestModel;
import com.github.billy.bar.solver.aplication.port.in.SolveKataInputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class SolveKataUseCase implements SolveKataInputPort {

  @Override
  public OutputResponseModel solve(SetupRequestModel setupRequestModel) {
    return OutputResponseModel.builder()
                              .id(1)
                              .dataset(List.of(1, 2, 3, 4, 5))
                              .primes(List.of(2, 3, 5, 7, 11))
                              .iterations(1)
                              .answer(List.of(1, 2, 3, 4, 5)).build();
  }
}
