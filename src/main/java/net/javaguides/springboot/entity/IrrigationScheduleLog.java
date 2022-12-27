package net.javaguides.springboot.entity;

import lombok.*;
import net.javaguides.springboot.entity.enums.IrrigationOperationStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "irrigationScheduleLog")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IrrigationScheduleLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private IrrigationOperationStatus status;

    private Integer durationInMinutes;

    private float litresOfWater;

    private Date dateCreated;

    private Date dateModified;

    @ManyToOne(fetch = FetchType.LAZY)
    private IrrigationConfiguration irrigationConfiguration;
}
