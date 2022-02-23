package com.github.billy.bar.solver.aplication.port.in;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Value
@Builder(toBuilder = true)
public class SetupRequestModel {

  @Positive
  @NotNull
  Integer datasetId;
  @Positive
  @NotNull
  Integer iterations;
}
