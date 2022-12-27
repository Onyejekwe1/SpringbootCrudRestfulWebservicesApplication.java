package net.javaguides.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lands")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Land {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float area;

    private String soilType;

    private String landPurpose;

    private String serialNumber;

    private Date dateCreated;

    private Date dateModified;

    @OneToMany(mappedBy="land")
    private List<IrrigationConfiguration> irrigationConfigurations;
}
