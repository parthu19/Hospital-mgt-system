package com.hospitalmgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmgt.model.Staff;

public interface StaffRepository extends JpaRepository<Staff,Long>{

}
