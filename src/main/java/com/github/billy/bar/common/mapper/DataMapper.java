package com.github.billy.bar.common.mapper;

import com.github.billy.bar.common.type.Data;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Data.class})
public interface DataMapper {

  default Data map(Integer value) {
    return new Data(value);
  }

  default List<Integer> toInteger(List<Data> dataList) {
    return dataList.stream().map(this::map).collect(Collectors.toList());
  }

  default Integer map(Data data) {
    return data.getValue();
  }
}