package com.springproject.project1.mapper;

import com.springproject.project1.DTO.RequestDTO;
import com.springproject.project1.entity.MyEntiity;
import com.springproject.project1.DTO.EmpResponseDTO;

public class DTOMapper {
    public static EmpResponseDTO toDTO(MyEntiity my){
        EmpResponseDTO empResponseDTO=new EmpResponseDTO();
        empResponseDTO.setId(my.getId());
        empResponseDTO.setEmail(my.getMail());
        empResponseDTO.setEname(my.getEname());
        empResponseDTO.setDob(my.getDob().toString());
        empResponseDTO.setDoj(my.getDoj().toString());
        empResponseDTO.setRole(my.getRole());
        return empResponseDTO;
    }
    public static MyEntiity toModel(RequestDTO requestDTO){
       MyEntiity myEntiity=new MyEntiity();

        myEntiity.setMail(requestDTO.getMail());
        myEntiity.setEname(requestDTO.getEname());
        myEntiity.setDob(requestDTO.getDob());
        myEntiity.setSalary(requestDTO.getSalary());
        return myEntiity;
    }
}
