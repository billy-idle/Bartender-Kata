package com.github.billy.bar.solver.adapter.in.web;

import com.github.billy.bar.common.annotation.WebAdapter;
import com.github.billy.bar.solver.aplication.port.in.OutputResponseModel;
import com.github.billy.bar.solver.aplication.port.in.SetupRequestModel;
import com.github.billy.bar.solver.aplication.port.in.SolveKataInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@WebAdapter
@RequiredArgsConstructor
@RequestMapping("/kata")
public class KataController {

  private final SolveKataInputPort solveKataInputPort;

  @PostMapping("/solve")
  public OutputResponseModel solve(@RequestBody SetupRequestModel setupRequestModel) {
    return solveKataInputPort.solve(setupRequestModel);
  }
}
