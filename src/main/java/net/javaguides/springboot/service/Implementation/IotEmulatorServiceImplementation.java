package net.javaguides.springboot.service.Implementation;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.dto.IrrigationScheduleLogDto;
import net.javaguides.springboot.entity.IrrigationScheduleLog;
import net.javaguides.springboot.entity.enums.IrrigationOperationStatus;
import net.javaguides.springboot.service.IotEmulatorService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IotEmulatorServiceImplementation implements IotEmulatorService {
    @Override
    public IrrigationOperationStatus sendIrrigationSchedule(IrrigationScheduleLog scheduleLogDto) {
        IrrigationOperationStatus[] expectedStatus = new IrrigationOperationStatus[]{IrrigationOperationStatus.SUCCESSFUL,IrrigationOperationStatus.FAILED, IrrigationOperationStatus.UNAVAILABLE};

        int rand = (int)(Math.random() * 2) + 0;
        IrrigationOperationStatus status = expectedStatus[rand];
        return status;
    }
}
