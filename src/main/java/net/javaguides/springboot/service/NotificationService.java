package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.EmailSenderDto;

public interface NotificationService {
    void SendMail(EmailSenderDto mail);
}
