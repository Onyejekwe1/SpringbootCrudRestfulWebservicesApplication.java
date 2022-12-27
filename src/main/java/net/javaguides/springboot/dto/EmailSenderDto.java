package net.javaguides.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailSenderDto {
    private String to;
    private String from;
    private String subject;
    private String body;
    private boolean isHtmlBody;
}
