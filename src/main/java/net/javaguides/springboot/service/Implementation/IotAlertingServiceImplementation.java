package net.javaguides.springboot.service.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import net.javaguides.springboot.dto.EmailSenderDto;
import net.javaguides.springboot.service.IotAlertingService;
import net.javaguides.springboot.service.NotificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Component
@Slf4j
public class IotAlertingServiceImplementation implements IotAlertingService {

    private final NotificationService emailService;

    @Value("${admin.email}")
    private String adminEmail;

    @Override
    public void sendIotDeviceNotAvailableAlert(String deviceName) {
        log.info("sending iot device not available alert");
        var mail = new EmailSenderDto();
        mail.setTo(adminEmail);
        mail.setSubject("Iot Device Unavailable!");
        String message = "IotDevice with name %s is Unavailable!";
        mail.setBody(String.format(message, deviceName));

        emailService.SendMail(mail);
    }
}
