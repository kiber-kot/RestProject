package ru.tsk.springboot.educational_rest_project.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Модель статуса удаления работника")
public class DeleteMessage {
    @ApiModelProperty(example = "Работник с id = 5 удален")
    private String info;
}
