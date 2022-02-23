package com.github.billy.bar.solver.adapter.out.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DatasetPersistenceAdapterTest {

  @Autowired
  private DatasetPersistenceAdapter datasetPersistenceAdapter;

  @Test
  void canGetDataset() {
    assertNotNull(datasetPersistenceAdapter.getById(1));
  }
}