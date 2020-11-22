package com.employee.constants;

public class AppQueries {

	public static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO EMPLOYEE(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, SALARY) VALUES (?, ?, ?, ?, ?, CURDATE(), ?)";

}
