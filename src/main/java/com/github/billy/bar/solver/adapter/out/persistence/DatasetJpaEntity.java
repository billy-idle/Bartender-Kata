package com.github.billy.bar.solver.adapter.out.persistence;

import com.github.billy.bar.common.persistence.BaseJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "dataset")
public class DatasetJpaEntity extends BaseJpaEntity {

  @Column(nullable = false, unique = true)
  String arrayDataset;

  @Override
  public int hashCode() {
    return Objects.hash(arrayDataset);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DatasetJpaEntity)) {
      return false;
    }
    DatasetJpaEntity that = (DatasetJpaEntity) o;
    return arrayDataset.equals(that.arrayDataset);
  }
}
