package com.empmanage;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String all_errors()
    {
        System.out.println("error found");
        return "edit";

    }
}
