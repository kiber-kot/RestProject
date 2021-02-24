package ru.tsk.springboot.educational_rest_project.service;


import ru.tsk.springboot.educational_rest_project.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(long id);

    void deleteEmployee(long id);
}
