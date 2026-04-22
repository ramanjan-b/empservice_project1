package com.springproject.project1.Repository;

import com.springproject.project1.entity.MyEntiity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpRepository extends JpaRepository<MyEntiity, Long> {
}
