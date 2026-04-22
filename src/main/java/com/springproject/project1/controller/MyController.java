package com.springproject.project1.controller;

import com.springproject.project1.DTO.RequestDTO;
import com.springproject.project1.customexception.CustomEx;
import com.springproject.project1.customexception.EmployeeNotFoundException;
import com.springproject.project1.customexception.NewException;
import com.springproject.project1.entity.MyEntiity;
import com.springproject.project1.DTO.EmpResponseDTO;
import com.springproject.project1.service.MyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@Tag(name = "Employee",description="API for Employee management")
public class MyController {
    @Autowired
    MyService myService;

    @GetMapping("/getEmp")
    @Operation(summary = "Get Employee")
    public ResponseEntity<List<EmpResponseDTO>> getEmp(MyEntiity myEntiity){
        return  new ResponseEntity(myService.showEmp(),HttpStatus.OK);
    }
    @PostMapping("/createE")
    @Operation(summary = "Create Employee")
    public ResponseEntity<MyEntiity> createEM(@RequestBody MyEntiity requestDTO) throws  NewException {
        return ResponseEntity.ok(myService.createEmp(requestDTO));
    }
    @PostMapping("/createMulti")
    public ResponseEntity<?> createMulti(@RequestBody List<MyEntiity> my) throws CustomEx {
        return ResponseEntity.ok(myService.createMulti(my));
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@RequestBody MyEntiity entiity, @PathVariable Long id) throws EmployeeNotFoundException {
return new ResponseEntity<>(myService.update(id,entiity),HttpStatus.OK);

    }
    @DeleteMapping("/delAll")
    public void deleteAll(){
        myService.delete();
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws EmployeeNotFoundException {
        myService.delById(id);
        return  ResponseEntity.noContent().build();

    }
}
