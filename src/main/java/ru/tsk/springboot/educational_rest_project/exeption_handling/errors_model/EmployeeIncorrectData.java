package ru.tsk.springboot.educational_rest_project.exeption_handling.errors_model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class EmployeeIncorrectData{

    @ApiModelProperty(example = "Данный id = 123 не дал результатов в базе данных")
    private String info;
}
