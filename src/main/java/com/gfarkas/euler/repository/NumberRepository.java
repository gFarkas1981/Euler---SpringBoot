package com.gfarkas.euler.repository;

import com.gfarkas.euler.domain.Number;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NumberRepository extends CrudRepository<Number, Long> {

    List<Number> findAll();

}
