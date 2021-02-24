package ru.tsk.springboot.educational_rest_project.exeption_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeIncorrectDataAdvice {

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeExeption noSuchEmployeeExeption){
        EmployeeIncorrectData employeeIncorrectData = new EmployeeIncorrectData();
        employeeIncorrectData.setInfo(noSuchEmployeeExeption.getMessage());

        return new ResponseEntity<>(employeeIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(Exception noSuchEmployeeException){
        EmployeeIncorrectData employeeIncorrectData = new EmployeeIncorrectData();
        employeeIncorrectData.setInfo(noSuchEmployeeException.getMessage());

        return new ResponseEntity<>(employeeIncorrectData, HttpStatus.NOT_FOUND);
    }
}
