package com.github.billy.bar.common.mapper;

import com.github.billy.bar.common.type.Data;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper {

  default Integer map(Data data) {
    return data.getValue();
  }

  default Data map(Integer value) {
    return new Data(value);
  }
}