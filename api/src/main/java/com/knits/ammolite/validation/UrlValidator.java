package com.knits.ammolite.validation;

import com.knits.ammolite.annotations.ValidEmail;
import com.knits.ammolite.annotations.ValidURL;
import com.knits.ammolite.config.Constants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValidator implements ConstraintValidator<ValidURL,String> {


    @Override
    public void initialize(ValidURL constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return validateUrl(s);
    }
    private boolean validateUrl(String email){
        Pattern pattern = Pattern.compile(Constants.URL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



}
