package net.javaguides.springboot.dto;

import lombok.Getter;
import lombok.Setter;
import net.javaguides.springboot.entity.IrrigationConfiguration;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class LandDto {
    private Long id;

    @Min(1)
    private float area;

    @NotEmpty
    private String soilType;

    @NotEmpty
    private String landPurpose;

    @NotEmpty
    private String serialNumber;

    private Date dateCreated;

    private Date dateModified;

    private List<IrrigationConfiguration> irrigationConfigurations;
}
