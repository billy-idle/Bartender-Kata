package com.github.billy.bar.solver.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasetRepository extends JpaRepository<DatasetJpaEntity, Integer> {

}
