package com.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employee.constants.AppQueries;
import com.employee.dto.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int saveEmployee(Employee employee) {

		return jdbcTemplate.update(AppQueries.INSERT_EMPLOYEE_QUERY, (psSetter) -> {

			psSetter.setInt(1, employee.getEmployeeId());
			psSetter.setString(2, employee.getFirstName());
			psSetter.setString(3, employee.getLastName());
			psSetter.setString(4, employee.getEmail());
			psSetter.setLong(5, employee.getPhoneNumber());
			psSetter.setDouble(6, employee.getSalary());
		});
	}

	public Employee getEmployee(int employeeId) {
		Employee employee = null;

		employee = jdbcTemplate.query(AppQueries.SELECT_EMPLOYEE_QUERY, (psSetter) -> {

			psSetter.setInt(1, employeeId);

		}, (resultSet) -> {

			Employee currentEmployee = null;

			if (resultSet.next()) {
				currentEmployee = new Employee();

				currentEmployee.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
				currentEmployee.setFirstName(resultSet.getString("FIRST_NAME"));
				currentEmployee.setLastName(resultSet.getString("LAST_NAME"));
				currentEmployee.setEmail(resultSet.getString("EMAIL"));
				currentEmployee.setPhoneNumber(resultSet.getLong("PHONE_NUMBER"));
				currentEmployee.setHireDate(resultSet.getDate("HIRE_DATE"));
				currentEmployee.setSalary(resultSet.getDouble("SALARY"));

			}

			return currentEmployee;
		});

		return employee;
	}

	public int updateEmployee(int employeeId, String email) {

		return jdbcTemplate.update(AppQueries.UPDATE_EMPLOYEE_QUERY, (psSetter) -> {

			psSetter.setString(1, email);
			psSetter.setInt(2, employeeId);
		});
	}

	public int deleteEmployee(int employeeId) {

		return jdbcTemplate.update(AppQueries.DELETE_EMPLOYEE_QUERY, (psSetter) -> {

			psSetter.setInt(1, employeeId);
		});
	}
}
