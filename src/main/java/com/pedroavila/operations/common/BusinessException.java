package com.pedroavila.operations.common;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Arrays;

@ControllerAdvice
public class BusinessException extends RuntimeException {

    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    public BusinessException(String format, Object... args) {
        super(String.format(format, args));
        this.message = String.format(format, args);
        Object dato = Arrays.stream(args).findFirst().orElse(null);
        if (dato != null) {
            this.status = (int) dato;
        }
    }
}
