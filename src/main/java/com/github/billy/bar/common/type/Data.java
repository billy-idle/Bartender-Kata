package com.github.billy.bar.common.type;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.PositiveOrZero;

@Value
@EqualsAndHashCode(callSuper = true)
public class Data extends BaseType {

  public static final String LESS_THAN_ZERO = "Data.lessThanZero";

  @PositiveOrZero(message = LESS_THAN_ZERO)
  Integer value;
}
