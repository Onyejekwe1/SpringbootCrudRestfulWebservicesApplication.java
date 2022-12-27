package net.javaguides.springboot.dto;

import net.javaguides.springboot.entity.IrrigationConfiguration;
import net.javaguides.springboot.entity.enums.IrrigationOperationStatus;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

public class IrrigationScheduleLogDto {

    private Long id;

    @Enumerated(EnumType.STRING)
    private IrrigationOperationStatus status;

    private Integer durationInMinutes;

    private float litresOfWater;

    private Date dateCreated;

    private Date dateModified;

    private IrrigationConfiguration irrigationConfiguration;
}
