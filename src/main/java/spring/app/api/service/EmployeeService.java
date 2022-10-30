package spring.app.application.service;


import spring.app.application.model.Employee;

import java.util.List;


public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee findById(Integer id);

    Employee updateEmployee( Employee employee);

    Boolean deleteById(Integer id);



}


