package com.assignment.controllers;

//import com.assignment.models.Registration;
//import com.assignment.services.RegistrationService;
//import com.assignment.validators.UsernameValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class RegistrationController {
//    @Autowired
//    RegistrationService registrationService;
//
//
//    @RequestMapping(value = "/registartion")
//    public ModelAndView viewRegistration() {
//
//        return new ModelAndView("registration");
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ModelAndView register( @Validated @ModelAttribute ("registration")Registration registration,BindingResult error) {
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        registrationService.registerUser(registration);
//        if(error.hasErrors())
//        {
//            System.out.println("errors");
//            modelAndView.setViewName("registration");
//            return modelAndView;
//        }
////        registrationService.registerUser(firstname);
//
//
//        return new ModelAndView("home");
//
//
//
//    }
//    @InitBinder
//    public  void initBinder (WebDataBinder binder){
//        binder.addValidators(new UsernameValidator());
//    }
//    @ExceptionHandler(value =  NullPointerException.class)
//    public String exception(){
//        return  "error";
//    }
//}
import com.assignment.models.Registration;
import com.assignment.services.RegistrationService;
import com.assignment.validators.RegistrationValidator;
import com.assignment.validators.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;


    @RequestMapping(value = "/registartion")
    public ModelAndView viewRegistration() {

        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("registration", new Registration());

        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@Validated @ModelAttribute("registration") Registration registration, BindingResult error) {
        if (error.hasErrors()) {
            return new ModelAndView("registration");
        }

        registrationService.registerUser(registration);
        return new ModelAndView("home");

    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(new RegistrationValidator());
    }
}