package com.github.billy.bar.common.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseJpaEntity extends AuditableEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Transient
  private boolean isNew = true;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  public boolean isNew() {
    return Optional.ofNullable(getId()).orElse(0).equals(0);
  }

  @PrePersist
  @PostLoad
  void markNotNew() {
    this.isNew = false;
  }
}