package com.kotz.kotz.controller;

import com.kotz.kotz.entity.feedback;
import com.kotz.kotz.mail.mailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.ValidationException;

@Controller
@RequestMapping("/feedback")
public class feedbackController {

    private mailConfig mailConfig;


    public feedbackController(mailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }

    @GetMapping
    public ModelAndView getFeedback(){
        //mailConfig newmail = new mailConfig();
        //model.addAttribute("feedback", newmail);
        return new ModelAndView("mail");
    }


    @PostMapping
    public String postFeedback(feedback feedback, BindingResult bindingResult) throws ValidationException {

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
        mailMessage.setTo("e@feedback.com");
        mailMessage.setSubject("Nuevo mensaje de: " + feedback.getName());
        mailMessage.setText(feedback.getMessage());

        //ENVIAR MAIL
        mailSender.send(mailMessage);

        return "redirect:/";
    }
}
