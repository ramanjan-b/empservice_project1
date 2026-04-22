package com.springproject.project1.service;

import com.springproject.project1.Repository.EmpRepository;
import com.springproject.project1.customexception.CustomEx;
import com.springproject.project1.customexception.EmployeeNotFoundException;
import com.springproject.project1.customexception.NewException;
import com.springproject.project1.entity.MyEntiity;
import com.springproject.project1.grpc.BonusServiceGrpcClient;
import com.springproject.project1.mapper.DTOMapper;
import com.springproject.project1.DTO.EmpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MyService {

    BonusServiceGrpcClient client;

   
 EmpRepository eRepo;
         public MyService(BonusServiceGrpcClient client, EmpRepository erepo){
             this.client = client;
            
             this.eRepo=erepo;
         }

//private List<MyEntiity> list=new ArrayList<>();
public List<MyEntiity> createMulti(List<MyEntiity> employees) throws CustomEx{
    for (MyEntiity emp : employees) {

        if (emp.getEname() == null || emp.getEname().isBlank()) {
            throw new CustomEx("Invalid name", "505", "...");
        }

        emp.setCreationDate(LocalDate.now());
        emp.setCreationTime(LocalTime.now());
        emp.setDoj(LocalDate.now().minusDays(180));
    }

    return eRepo.saveAll(employees);
}
    @Transactional
    public MyEntiity createEmp(MyEntiity my) throws  NewException {
if(my.getEname()==null ||my.getEname().isEmpty()|| my.getEname().isBlank()){
    throw new NewException("arey ja na bhai");
//    throw new CustomEx("Bhaago bhai","505","9932045825");
}

     my.setEname(my.getEname());
        my.setMail(my.getMail());
        my.setSalary(my.getSalary());
my.setCreationDate(LocalDate.now());
my.setCreationTime(LocalTime.now());
my.setRole(my.getRole());
my.setDob(my.getDob());
my.setDoj(LocalDate.now().minusDays(180));


        MyEntiity saved=eRepo.save(my);
        return saved;
    }
    public List<EmpResponseDTO> showEmp(){
        List<MyEntiity> emps= eRepo.findAll();
        List<EmpResponseDTO> empResponseDTOS=emps.stream().map(DTOMapper::toDTO).toList();
        return empResponseDTOS;
    }
    public void delete(){
        eRepo.deleteAll();
    }
    public void delById(Long id) throws EmployeeNotFoundException {
             MyEntiity myEntiity=new MyEntiity();
             eRepo.delete(eRepo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found "+id)));
    }
    public MyEntiity update(Long id, MyEntiity my) throws EmployeeNotFoundException {
        MyEntiity existing = eRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found "+id));

        if (my.getEname() != null) {
            existing.setEname(my.getEname());
        }
        if (my.getMail() != null) {
            existing.setMail(my.getMail());
        }
        if (my.getSalary() != null) {
            existing.setSalary(my.getSalary());
        }
        if (my.getRole() != null) {
            existing.setRole(my.getRole());
        }

        existing.setUpdatedAt("Date: "+LocalDate.now() + "-|-" + "Time: "+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        return eRepo.save(existing);
    }
}
