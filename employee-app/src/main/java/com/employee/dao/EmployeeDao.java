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

}
