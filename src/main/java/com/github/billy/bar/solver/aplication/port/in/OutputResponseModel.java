package com.github.billy.bar.solver.aplication.port.in;

import com.github.billy.bar.common.type.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Value
@Builder(toBuilder = true)
@AllArgsConstructor
public class OutputResponseModel {

  @Positive(message = Id.POSITIVE)
  @NotNull
  Integer id;
  List<@Positive @NotNull Integer> dataset;
  List<@Positive @NotNull Integer> primes;
  @Positive @NotNull Integer iterations;
  List<@Positive @NotNull Integer> answer;
}
