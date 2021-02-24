package ru.tsk.springboot.educational_rest_project.exeption_handling.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.tsk.springboot.educational_rest_project.exeption_handling.errors_model.EmployeeIncorrectData;
import ru.tsk.springboot.educational_rest_project.exeption_handling.errors_model.MainExceptionData;
import ru.tsk.springboot.educational_rest_project.exeption_handling.exception.NoSuchEmployeeExeption;
import ru.tsk.springboot.educational_rest_project.exeption_handling.exception.DeleteNoSuchException;
import ru.tsk.springboot.educational_rest_project.exeption_handling.errors_model.DeleteErrorData;

@ControllerAdvice
public class EmployeeIncorrectDataAdvice {

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeExeption noSuchEmployeeExeption){
        EmployeeIncorrectData employeeIncorrectData = new EmployeeIncorrectData();
        employeeIncorrectData.setInfo(noSuchEmployeeExeption.getMessage());

        return new ResponseEntity<>(employeeIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<MainExceptionData> handleException(Exception noSuchEmployeeException){
        MainExceptionData employeeIncorrectData = new MainExceptionData();
        employeeIncorrectData.setInfo(noSuchEmployeeException.getMessage());

        return new ResponseEntity<>(employeeIncorrectData, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<DeleteErrorData> deleteErrorResponseEntity(DeleteNoSuchException deleteNoSuchException){
        DeleteErrorData deleteErrorData = new DeleteErrorData();
        deleteErrorData.setInfo(deleteNoSuchException.getMessage());

        return new ResponseEntity<>(deleteErrorData, HttpStatus.NOT_FOUND);
    }
}
