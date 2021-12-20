package com.hospitalmgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmgt.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
