package net.javaguides.springboot.service.background_service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import net.javaguides.springboot.service.IrrigationConfigurationService;
import net.javaguides.springboot.service.IrrigationScheduleLogService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class IrrigationBackgroundServiceScheduler {
    private final IrrigationConfigurationService irrigationConfigurationService;
    private final IrrigationScheduleLogService irrigationScheduleLogService;

    @Scheduled(fixedRateString = "${schedule.in.milliseconds}")
    public void scheduleLandConfig(){
        log.info("Running ");
        var landConfigs = irrigationConfigurationService.getConfigurationSchedules();
        log.info("Schedules are "+ landConfigs.size());

        for(var landConfig: landConfigs ){
            log.info("Creating schedule for device "+ landConfig.getDeviceName());
            irrigationConfigurationService.updateNextTimeSlot(landConfig);

            var schedule = irrigationScheduleLogService.schedule(landConfig);
            irrigationScheduleLogService.activate(schedule);
        }
    }
}
