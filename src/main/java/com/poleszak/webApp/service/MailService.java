package com.poleszak.webApp.service;

import com.poleszak.webApp.exceptions.SpringDiscussionwebsiteException;
import com.poleszak.webApp.model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MailService
{
    private final JavaMailSender mailSender;
    private final MailContentBuilder mailContentBuilder;
    
    void sendMail(NotificationEmail notificationEmail)
    {
        MimeMessagePreparator messagePreparator = mimeMessage ->
        {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("chat@email.com");
            messageHelper.setTo(notificationEmail.getSubject());
            messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
        };

        try
        {
            mailSender.send(messagePreparator);
            log.info("Activation email sen!");
        } catch (MailException e) {
            throw new SpringDiscussionwebsiteException("Exception occured when sending mail to "
                    + notificationEmail.getRecipient());
        }
    }
}
