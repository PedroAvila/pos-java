package com.pedroavila.pos.rest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomResponse<T> {
    private int status;
    private T data;
    private List<String> errors;

    public CustomResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public CustomResponse(int status, String mensaje) {
        this.status = status;
        this.errors = Arrays.stream(mensaje.split("\r\n"))
                .filter(line -> !line.isEmpty())
                .collect(Collectors.toList());
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
