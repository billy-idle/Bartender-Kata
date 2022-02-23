package com.github.billy.bar.solver.aplication.service;

import com.github.billy.bar.common.annotation.UseCase;
import com.github.billy.bar.common.mapper.DataMapper;
import com.github.billy.bar.solver.aplication.port.in.OutputResponseModel;
import com.github.billy.bar.solver.aplication.port.in.SetupRequestModel;
import com.github.billy.bar.solver.aplication.port.in.SolveKataInputPort;
import com.github.billy.bar.solver.aplication.port.out.GetDatasetOutputPort;
import com.github.billy.bar.solver.domain.Kata;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
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

    List<Integer> aList = dataMapper.toInteger(kata.getDataset());
    List<Integer> primes = getPrimes((aList.size() * 2) + 1);
    List<Integer> bList = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    List<Integer> copyOfPrimes = List.copyOf(primes);

    int iterations = setupRequestModel.getIterations();

    for (int i = 1; i <= iterations; i++) {
      for (int j = aList.size() - 1; j >= 0; j--) {
        Integer a = aList.get(j);
        if (a % primes.get(0) == 0) {
          bList.add(a);
        } else {
          tempList.add(a);
        }
      }

      aList = List.copyOf(tempList);

      if (i == iterations || primes.isEmpty()) {
        bList.addAll(tempList);
        break;
      }

      primes.remove(0);
      tempList.clear();
    }

    return OutputResponseModel.builder()
                              .id(kata.getId().getValue())
                              .dataset(dataMapper.toInteger(kata.getDataset()))
                              .primes(copyOfPrimes)
                              .iterations(iterations)
                              .answer(bList).build();
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
