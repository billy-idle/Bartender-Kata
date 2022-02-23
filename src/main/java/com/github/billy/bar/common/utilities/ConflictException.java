package com.github.billy.bar.common.utilities;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
  @Getter
  private String logDetail;

  public ConflictException(String message) {
    super(message);
  }

  public ConflictException(String message, String logDetail) {
    super(message);
    this.logDetail = logDetail;
  }
}