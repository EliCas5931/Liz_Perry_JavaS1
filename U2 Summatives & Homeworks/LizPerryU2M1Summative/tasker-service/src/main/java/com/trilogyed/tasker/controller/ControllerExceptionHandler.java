package com.trilogyed.tasker.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.trilogyed.tasker.exception.NotFoundException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors> validationError(MethodArgumentNotValidException e, WebRequest request) {
        BindingResult result = e.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();

        List<VndErrors.VndError> vndErrorList = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {

            VndErrors.VndError vndError = new VndErrors.VndError(request.toString(), fieldError.getDefaultMessage());

            vndErrorList.add(vndError);
        }

        VndErrors vndErrors = new VndErrors(vndErrorList);

        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(vndErrors, HttpStatus.BAD_REQUEST);

        return responseEntity;
    }
    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<VndErrors> notFoundException(NotFoundException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), "Not found : " + e.getMessage());

        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

        return responseEntity;
    }

    @ExceptionHandler(value = {InvalidFormatException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors>numberFormat(InvalidFormatException e, WebRequest request){
        VndErrors error = new VndErrors(request.toString(), "Invalid Format input "+e.getMessage());

        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);

        return responseEntity;
    }

    @ExceptionHandler(value = {NumberFormatException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> numberFormatException(NumberFormatException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), "Parameter must be a number. " + e.getMessage());

        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);

        return responseEntity;
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors> outOfRangeException(IllegalArgumentException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), "BAD_REQUEST, FIX IT PLEASE" + e.getMessage());

        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

        return responseEntity;
    }
}