package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.IrrigationScheduleLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IrrigationScheduleLogRepository  extends JpaRepository<IrrigationScheduleLog, Long> {
}
