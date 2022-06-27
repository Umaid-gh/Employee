package io.umaid.springbootquickstarter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.umaid.springbootquickstarter.domain.EmployeeDAO;
import io.umaid.springbootquickstarter.domain.EmployeeDTO;
import io.umaid.springbootquickstarter.domain.responseEmployee.ResponseEmployee;
import io.umaid.springbootquickstarter.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IService {

	@Autowired
	private EmployeeRepository empRepo;

	public ResponseEmployee<List<EmployeeDTO>> getAllEmployees() {
		List<EmployeeDAO> listDao = (List<EmployeeDAO>) empRepo.findAll();
		ResponseEmployee<List<EmployeeDTO>> response = new ResponseEmployee<>();
		List<EmployeeDTO> listDto = new ArrayList<>();

		if (listDao.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database is Empty!!!");
			// response.setData(null);
			// response.setMessage("Database is Empty!!!");
			// response.setStatus(404);
		} else {
			for (int i = 0; i < listDao.size(); i++) {
				EmployeeDAO emp = listDao.get(i);
				EmployeeDTO dto = new EmployeeDTO(emp);
				listDto.add(dto);
			}
			response.setData(listDto);
			response.setMessage("Database is retrived!!!");
			response.setStatus(200);
		}
		// JAVA7 syntax
		// List<Employee> empDbList = (List<Employee>) repo.findAll();
		// for (Employee e : empDbList) {
		// employees.add(e);
		// }

		// JAVA 8 initial syntax
		// empDbList.forEach(e -> employees.add(e));

		// JAVA 8 Good syntax
		// empDbList.forEach(employees::add);

		// JAVA 8 Best syntax
		// empRepo.findAll().forEach(empDbList::add);
		return response;

	}

	public ResponseEmployee<EmployeeDTO> getEmployeebyId(int eid) {
		ResponseEmployee<EmployeeDTO> response = new ResponseEmployee<>();
		Optional<EmployeeDAO> optionalDao = empRepo.findById(eid);
		if (optionalDao.isPresent()) {
			EmployeeDTO dto = new EmployeeDTO(optionalDao.get());
			response.setData(dto);
			response.setMessage("Found Employee ID: " + eid);
			response.setStatus(200);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee ID not Found");
			// response.setData(null);
			// response.setMessage("Employee ID not Found");
			// response.setStatus(404);
		}
		return response;
	}

	public ResponseEmployee<EmployeeDTO> addEmployee(EmployeeDTO dto) {
		ResponseEmployee<EmployeeDTO> response = new ResponseEmployee<>();

		// searching DB to check in Eid already present
		Optional<EmployeeDAO> optionalDao = empRepo.findById(dto.getEid());

		if (optionalDao.isPresent()) {
			throw new ResponseStatusException(HttpStatus.FOUND, "Employee Already Present");
		} else {
			// converting DTO to DAO
			EmployeeDAO dao = new EmployeeDAO(dto.getEid(), dto.getEname(), dto.getEsalary());
			// saving new DAO
			empRepo.save(dao);
			response.setData(dto);
			response.setMessage("New Employee Added!!!");
			response.setStatus(200);
		}
		return response;

	}

	public ResponseEmployee<EmployeeDTO> updateEmployee(EmployeeDTO dto, int id) {
		ResponseEmployee<EmployeeDTO> response = new ResponseEmployee<>();

		Optional<EmployeeDAO> optionalDao = empRepo.findById(id);
		if (optionalDao.isPresent()) {
			EmployeeDAO emp = new EmployeeDAO(dto);
			response.setData(dto);
			response.setMessage("Employee ID Updated!!!");
			response.setStatus(200);
			empRepo.save(emp);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee ID Not Found!!");
			// response.setData(null);
			// response.setMessage("Employee ID Not Found!!");
			// response.setStatus(404);
		}
		return response;

	}

	public ResponseEmployee<EmployeeDTO> deleteEmployeebyId(int eid) {
		Optional<EmployeeDAO> optionalDao = empRepo.findById(eid);

		ResponseEmployee<EmployeeDTO> response = new ResponseEmployee<>();

		if (optionalDao.isPresent()) {
			EmployeeDTO dto = new EmployeeDTO(optionalDao.get());
			response.setData(dto);
			response.setMessage("Employee Details deleted for Employee Eid: " + eid);
			response.setStatus(200);
			empRepo.deleteById(eid);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee ID Not Found!!");
			// response.setData(null);
			// response.setMessage("Employee ID: " + eid + " Not Found to
			// Deleted!!!");
			// response.setStatus(404);
		}
		return response;
	}

}
