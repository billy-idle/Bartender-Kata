package com.github.billy.bar.solver.aplication.service;

import com.github.billy.bar.common.annotation.UseCase;
import com.github.billy.bar.common.mapper.DataMapper;
import com.github.billy.bar.solver.aplication.port.in.OutputResponseModel;
import com.github.billy.bar.solver.aplication.port.in.SetupRequestModel;
import com.github.billy.bar.solver.aplication.port.in.SolveKataInputPort;
import com.github.billy.bar.solver.aplication.port.out.GetDatasetOutputPort;
import com.github.billy.bar.solver.domain.Kata;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UseCase
@RequiredArgsConstructor
public class SolveKataUseCase implements SolveKataInputPort {

  private final GetDatasetOutputPort getDatasetOutputPort;
  private final DataMapper dataMapper;

  @Override
  public OutputResponseModel solve(SetupRequestModel setupRequestModel) {

    Kata kata = getDatasetOutputPort.getById(setupRequestModel.getDatasetId());

    return OutputResponseModel.builder()
                              .id(1)
                              .dataset(dataMapper.toInteger(kata.getDataset()))
                              .primes(getPrimes(
                                  kata.getDataset().size() * kata.getDataset().size()))
                              .iterations(setupRequestModel.getIterations())
                              .answer(List.of(1, 2, 3, 4, 5)).build();
  }

  private List<Integer> getPrimes(int until) {
    return IntStream.rangeClosed(2, until)
                    .filter(this::isPrime).boxed()
                    .collect(Collectors.toList());
  }

  private boolean isPrime(int number) {
    return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                    .allMatch(n -> number % n != 0);
  }
}
