package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public String saveEmployee(Employee employee) {

		String message = null;

		try {

			int rowCount = employeeDao.saveEmployee(employee);

			if (rowCount > 0) {
				message = "Employee added successfully with ID: " + employee.getEmployeeId();
			} else {
				message = "Employee not added with ID: " + employee.getEmployeeId();
			}

		} catch (Exception e) {
			message = "Exception occured while adding Employee with ID: " + employee.getEmployeeId();
		}

		return message;
	}

}
