package com.github.billy.bar.common.utilities.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class CustomError {

  public final String name;
  public final String message;
}