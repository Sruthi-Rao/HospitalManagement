package com.assignment.validators;

import com.assignment.models.Registration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegistrationValidator implements Validator {


    public boolean supports(Class<?> aClass) {
        System.out.println(aClass + ": "+Registration.class.equals(aClass));
        return Registration.class.equals(aClass) ;
    }

    public void validate(Object o, Errors errors) {
        Registration registration =(Registration)o;
        System.out.println("inside Validate");
        if(registration.getFirstName() == null || registration.getFirstName().equals("")){
            System.out.println("firstName is empty");
            errors.rejectValue("firstName","registration.firstName","FirstName is null or empty");
        }
        if(registration.getLastName() == null || registration.getLastName().equals("")){
            System.out.println("lastname is Empty");
            errors.rejectValue("lastName","reistration.lastName","LastName is null or empty");
        }

    }

}
