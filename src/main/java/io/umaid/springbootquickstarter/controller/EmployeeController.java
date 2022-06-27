package io.umaid.springbootquickstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.umaid.springbootquickstarter.domain.EmployeeDTO;
import io.umaid.springbootquickstarter.domain.responseEmployee.ResponseEmployee;
import io.umaid.springbootquickstarter.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empServiceImpl;

	@GetMapping
	public ResponseEmployee<List<EmployeeDTO>> getAllEmployees() {
		return empServiceImpl.getAllEmployees();
	}

	@GetMapping("/{eid}")
	public ResponseEmployee<EmployeeDTO> getEmployee(@PathVariable int eid) {
		return empServiceImpl.getEmployeebyId(eid);
	}

	@PostMapping
	public ResponseEmployee<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO u) {
		return empServiceImpl.addEmployee(u);
	}

	@PostMapping("/{id}")
	public ResponseEmployee<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO u, @PathVariable int id) {
		return empServiceImpl.updateEmployee(u, id);
	}

	@DeleteMapping("/{id}")
	public ResponseEmployee<EmployeeDTO> deleteEmployee(@PathVariable int id) {
		return empServiceImpl.deleteEmployeebyId(id);
	}
}
