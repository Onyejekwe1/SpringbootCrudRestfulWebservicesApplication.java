package net.javaguides.springboot.service.Implementation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.dto.EmailSenderDto;
import net.javaguides.springboot.service.NotificationService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Component
public class NotificationServiceImplementation implements NotificationService {

    private JavaMailSender javaMailSender;

    @Override
    public void SendMail(EmailSenderDto mail) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail.getTo());
        msg.setSubject(mail.getSubject());
        msg.setText(mail.getBody());

        javaMailSender.send(msg);
    }
}
