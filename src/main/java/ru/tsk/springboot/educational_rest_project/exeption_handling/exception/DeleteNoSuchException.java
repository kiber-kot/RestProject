package ru.tsk.springboot.educational_rest_project.exeption_handling.exception;

public class DeleteNoSuchException extends RuntimeException{
    public DeleteNoSuchException(String message) {
        super(message);
    }
}
