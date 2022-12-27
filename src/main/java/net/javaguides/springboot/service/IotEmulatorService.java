package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.IrrigationScheduleLogDto;
import net.javaguides.springboot.entity.IrrigationScheduleLog;
import net.javaguides.springboot.entity.enums.IrrigationOperationStatus;

public interface IotEmulatorService {
    IrrigationOperationStatus sendIrrigationSchedule(IrrigationScheduleLog scheduleLogDto);
}
