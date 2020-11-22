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

			e.printStackTrace();
		}

		return message;
	}

	public Employee getEmployee(int employeeId) {

		Employee employee = null;
		try {
			employee = employeeDao.getEmployee(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;
	}

	public String updateEmployee(int employeeId, String email) {

		String message = null;

		try {

			int rowCount = employeeDao.updateEmployee(employeeId, email);

			if (rowCount > 0) {
				message = String.format("Employee updated successfully with ID: %s for Email: %s", employeeId, email);
			} else {
				message = String.format("Employee not updated with ID: %s for Email: %s", employeeId, email);
			}

		} catch (Exception e) {
			message = String.format("Exception occured while updating Employee with ID: for Email: %s", employeeId,
					email);

			e.printStackTrace();
		}

		return message;

	}

	public String deleteEmployee(int employeeId) {

		String message = null;

		try {

			int rowCount = employeeDao.deleteEmployee(employeeId);

			if (rowCount > 0) {
				message = String.format("Employee deleted successfully with ID: %s ", employeeId);
			} else {
				message = String.format("Employee not deleted with ID: %s ", employeeId);
			}

		} catch (Exception e) {
			message = String.format("Exception occured while deleting Employee with ID: for Email: %s", employeeId);

			e.printStackTrace();
		}

		return message;
	}
}
