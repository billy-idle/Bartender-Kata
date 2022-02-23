package com.github.billy.bar.common.utilities.error;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class ErrorResponse {

  private final List<CustomError> errors = new ArrayList<>();
}
