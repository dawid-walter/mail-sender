package com.dwalt.mailsender.aspect;

import com.dwalt.mailsender.config.AdminConfig;
import com.dwalt.mailsender.domain.Mail;
import com.dwalt.mailsender.model.Movie;
import com.dwalt.mailsender.service.MailService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MailSendAspect {
    private MailService mailService;
    private AdminConfig adminConfig;
    private static final String SUBJECT = "Message from MailSendAPI - New movie is added";

    @Autowired
    public MailSendAspect(MailService mailService, AdminConfig adminConfig) {
        this.mailService = mailService;
        this.adminConfig = adminConfig;
    }

    @After("@annotation(MailAnnotation) && args(movie)")
    private void sendMailAfterMovieIsPost(Movie movie) {
        String message = "In movie api was added new movie with title: " + movie.getTitle() + " and production year: " + movie.getProductionYear();
        mailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT, message));
    }
}
