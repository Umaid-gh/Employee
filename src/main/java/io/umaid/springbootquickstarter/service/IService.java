package io.umaid.springbootquickstarter.service;

import java.util.List;

import io.umaid.springbootquickstarter.domain.EmployeeDTO;
import io.umaid.springbootquickstarter.domain.responseEmployee.ResponseEmployee;

public interface IService {

	public ResponseEmployee<List<EmployeeDTO>> getAllEmployees();

	public ResponseEmployee<EmployeeDTO> getEmployeebyId(int eid);

	public ResponseEmployee<EmployeeDTO> addEmployee(EmployeeDTO u);

	public ResponseEmployee<EmployeeDTO> updateEmployee(EmployeeDTO u, int id);

	public ResponseEmployee<EmployeeDTO> deleteEmployeebyId(int eid);

}
