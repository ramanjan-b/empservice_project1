package com.springproject.project1.customexception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomEx extends Exception{
    String error;
    String contact;
    public CustomEx(String msg,String error,String contact){
        super(msg);
        this.error=error;
        this.contact=contact;
    }
}
