package net.javaguides.springboot.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 *
 * @author AAdekeye
 */
@Entity
@Table(name = "irrigationConfiguration")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IrrigationConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceName;

    private Date timeSlot;

    private Date nextTimeSlot;

    private Integer irrigationIntervalInDays;

    private Integer durationInMinutes;

    private float litresOfWater;

    private Date dateCreated;

    private Date dateModified;

    @ManyToOne(fetch = FetchType.LAZY)
    private Land land;
}
