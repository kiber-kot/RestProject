package ru.tsk.springboot.educational_rest_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tsk.springboot.educational_rest_project.entity.Employee;
import ru.tsk.springboot.educational_rest_project.exeption_handling.NoSuchEmployeeExeption;
import ru.tsk.springboot.educational_rest_project.service.EmployeeService;


import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final EmployeeService employeeService;

    @Autowired
    public RestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployees();
        return employeeList;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
            throw new NoSuchEmployeeExeption("Данный id = " + id + " не дал результатов в базе данных");
        }
        return employee;
    }

    /**
     * Создание нового работника без id
     * @param employee Объект класса employee
     * @return
     */
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    /**
     * Изменение клиента с id
     * @param employee Объект класса employee
     * @return
     */
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
            throw new NoSuchEmployeeExeption("Не найдет работник с id = " + id);
        }
        employeeService.deleteEmployee(id);
        return "Работник с id = " + id + " удален";
    }
}
