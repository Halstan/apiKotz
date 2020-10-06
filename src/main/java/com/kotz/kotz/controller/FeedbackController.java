package com.kotz.kotz.controller;

import com.kotz.kotz.entity.Feedback;
import com.kotz.kotz.mail.MailConfig;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.ValidationException;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    private MailConfig mailConfig;


    public FeedbackController(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }

    @GetMapping
    public ModelAndView getFeedback(){
        //MailConfig newmail = new MailConfig();
        //model.addAttribute("Feedback", newmail);
        return new ModelAndView("mail");
    }


    @PostMapping
    public String postFeedback(Feedback feedback, BindingResult bindingResult) throws ValidationException {

        if(bindingResult.hasErrors()){
            throw new ValidationException("Mail no valido");
        }

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(this.mailConfig.getHost());
        mailSender.setPort(this.mailConfig.getPort());
        mailSender.setUsername(this.mailConfig.getUsername());
        mailSender.setPassword(this.mailConfig.getPassword());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(feedback.getEmail());
        mailMessage.setTo("e@Feedback.com");
        mailMessage.setSubject("Nuevo mensaje de: " + feedback.getName());
        mailMessage.setText(feedback.getMessage());

        //ENVIAR MAIL
        mailSender.send(mailMessage);

        return "redirect:/";
    }
}
