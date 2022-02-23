package com.github.billy.bar.solver.aplication.port.in;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface SolveKataInputPort {

  @Valid OutputResponseModel solve(@Valid SetupRequestModel setupRequestModel);
}
