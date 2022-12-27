package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.IrrigationConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IrrigationConfigurationRepository extends JpaRepository<IrrigationConfiguration, Long> {
    List<IrrigationConfiguration> getByNextTimeSlot(Date timeSlot);
}
