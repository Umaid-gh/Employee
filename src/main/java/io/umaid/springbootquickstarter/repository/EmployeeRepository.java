package io.umaid.springbootquickstarter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.umaid.springbootquickstarter.domain.EmployeeDAO;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDAO, Integer> {

}
