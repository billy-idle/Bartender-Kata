package com.github.billy.bar.common.domain;

import com.github.billy.bar.common.type.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.Valid;
import java.io.Serializable;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseDomain implements Serializable {

  private static final long serialVersionUID = 1;

  @Valid
  protected final Id id;
}