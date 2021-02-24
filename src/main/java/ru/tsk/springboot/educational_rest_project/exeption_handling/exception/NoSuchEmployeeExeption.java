package ru.tsk.springboot.educational_rest_project.exeption_handling.exception;

public class NoSuchEmployeeExeption extends RuntimeException{

    public NoSuchEmployeeExeption(String message) {
        super(message);
    }
}
