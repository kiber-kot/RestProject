package ru.tsk.springboot.educational_rest_project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tsk.springboot.educational_rest_project.entity.DeleteMessage;
import ru.tsk.springboot.educational_rest_project.entity.Employee;
import ru.tsk.springboot.educational_rest_project.exeption_handling.errors_model.EmployeeIncorrectData;
import ru.tsk.springboot.educational_rest_project.exeption_handling.errors_model.MainExceptionData;
import ru.tsk.springboot.educational_rest_project.exeption_handling.exception.NoSuchEmployeeExeption;
import ru.tsk.springboot.educational_rest_project.exeption_handling.exception.DeleteNoSuchException;
import ru.tsk.springboot.educational_rest_project.exeption_handling.errors_model.DeleteErrorData;
import ru.tsk.springboot.educational_rest_project.service.EmployeeService;



import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@Api(value = "Employees")
@ApiOperation(value = "/api")
public class RestController {

    private final EmployeeService employeeService;

    @Autowired
    public RestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = Employee.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = MainExceptionData.class),
            @ApiResponse(code = 404, message = "Not Found", response = EmployeeIncorrectData.class),
    })
    @ApiOperation(value = "Показать всех работников", response = Iterable.class)
    public List<Employee> showAllEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployees();
        return employeeList;
    }

    @GetMapping("/employees/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = Employee.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = MainExceptionData.class),
            @ApiResponse(code = 404, message = "Not Found", response = EmployeeIncorrectData.class),
    })
    @ApiOperation(value = "Показать конкретного работника по id", response = Employee.class)
    public Employee getEmployee(@PathVariable long id){
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
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = Employee.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = MainExceptionData.class),
            @ApiResponse(code = 404, message = "Not Found", response = EmployeeIncorrectData.class),
    })
    @ApiOperation(value = "Создание нового работника, без присвоения id", response = Employee.class)
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
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = Employee.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = MainExceptionData.class),
            @ApiResponse(code = 404, message = "Not Found", response = EmployeeIncorrectData.class),
    })
    @ApiOperation(value = "Изменение существуещего работника с использованием id", response = Employee.class)
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = DeleteMessage.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = MainExceptionData.class),
            @ApiResponse(code = 404, message = "Not Found", response = DeleteErrorData.class)
    })
    @ApiOperation(value = "Удаление работника по id", response = DeleteMessage.class)
    public DeleteMessage deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
            throw new DeleteNoSuchException("Не найдет работник с id = " + id);
        }
        employeeService.deleteEmployee(id);
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setInfo("Работник с id = " + id + " удален");
        return deleteMessage;
    }
}
