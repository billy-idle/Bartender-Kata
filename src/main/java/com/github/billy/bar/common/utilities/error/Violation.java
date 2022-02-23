package com.github.billy.bar.common.utilities.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Violation {

  private final String field;
  private final String message;
}
