package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.Employee;
import com.employee.dto.ResponseDto;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto<String>> saveEmployee(@RequestBody Employee employee) {

		ResponseDto<String> responseDto = null;
		try {
			responseDto = new ResponseDto<>();
			String message = employeeService.saveEmployee(employee);

			responseDto.setStatus("SUCCESS");
			responseDto.setResponse(message);

		} catch (Exception e) {
			responseDto.setStatus("ERROR");

			e.printStackTrace();
		}

		ResponseEntity<ResponseDto<String>> responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping(value = "/getEmployee/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto<Employee>> getEmployee(@PathVariable Integer employeeId) {

		ResponseDto<Employee> responseDto = null;
		try {
			responseDto = new ResponseDto<>();
			Employee employee = employeeService.getEmployee(employeeId);

			responseDto.setStatus("SUCCESS");
			responseDto.setResponse(employee);

		} catch (Exception e) {
			responseDto.setStatus("ERROR");

			e.printStackTrace();
		}

		ResponseEntity<ResponseDto<Employee>> responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping(value = "/updateEmployee/{employeeId}/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto<String>> updateEmployee(@PathVariable Integer employeeId,
			@PathVariable String email) {

		ResponseDto<String> responseDto = null;
		try {
			responseDto = new ResponseDto<>();
			String message = employeeService.updateEmployee(employeeId, email);

			responseDto.setStatus("SUCCESS");
			responseDto.setResponse(message);

		} catch (Exception e) {
			responseDto.setStatus("ERROR");

			e.printStackTrace();
		}

		ResponseEntity<ResponseDto<String>> responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping(value = "/deleteEmployee/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto<String>> deleteEmployee(@PathVariable Integer employeeId) {

		ResponseDto<String> responseDto = null;
		try {
			responseDto = new ResponseDto<>();
			String message = employeeService.deleteEmployee(employeeId);

			responseDto.setStatus("SUCCESS");
			responseDto.setResponse(message);

		} catch (Exception e) {
			responseDto.setStatus("ERROR");

			e.printStackTrace();
		}

		ResponseEntity<ResponseDto<String>> responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);

		return responseEntity;
	}

}
