package net.javaguides.springboot.dto;

import lombok.Getter;
import lombok.Setter;
import net.javaguides.springboot.entity.Land;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
public class IrrigationConfigurationDto {

    private Long id;

    @Pattern(regexp="^[A-Za-z0-9-_]*$",message="Invalid name")
    private String deviceName;

    private Date timeSlot;

    private Date nextTimeSlot;

    private Integer irrigationIntervalInDays;

    private Integer durationInMinutes;

    private float litresOfWater;

    private Date dateCreated;

    private Date dateModified;

    private Land land;
}
