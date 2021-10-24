package com.boge.pibackend.service;

public interface MailService {
    void send(String to, String subject, String text);

}
