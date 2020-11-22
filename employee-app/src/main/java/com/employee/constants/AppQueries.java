package com.employee.constants;

public class AppQueries {

	public static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO EMPLOYEE(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, SALARY) VALUES (?, ?, ?, ?, ?, CURDATE(), ?)";
	public static final String SELECT_EMPLOYEE_QUERY = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, SALARY FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
	public static final String UPDATE_EMPLOYEE_QUERY = "UPDATE EMPLOYEE SET EMAIL = ? WHERE EMPLOYEE_ID = ?";
	public static final String DELETE_EMPLOYEE_QUERY = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
}
