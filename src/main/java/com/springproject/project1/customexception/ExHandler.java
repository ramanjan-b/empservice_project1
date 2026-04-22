package com.springproject.project1.customexception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExHandler {
    @ExceptionHandler(CustomEx.class)
    public ResponseEntity<ExDTO> handle(CustomEx c){
        ExDTO dto=ExDTO.builder().msg(c.getMessage()).errorCode(c.getError()).contact(c.getContact()).localDateTime( LocalDateTime.now()).build();
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NewException.class)
    public ResponseEntity<Map<String,String>> handle(NewException n){
        Map<String,String> map=new HashMap<>();
        map.put("Message",n.getMessage());
        return  ResponseEntity.badRequest().body(map);
//        return  ResponseEntity.badRequest().body(ExDTO.builder().msg(n.getMessage()).build());
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String,String>> handle(EmployeeNotFoundException e){
        Map<String,String> map=new HashMap<>();
        map.put("Message",e.getMessage());
        return  ResponseEntity.badRequest().body(map);
    }
}
