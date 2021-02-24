package ru.tsk.springboot.educational_rest_project.exeption_handling.errors_model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class MainExceptionData {

    @ApiModelProperty(example = "Failed to convert value of type 'java.lang.String' to required type 'long'; nested exception is java.lang.NumberFormatException: For input string: \"dgdsfagfds\"")
    private String info;
}
