package com.hospitalmgt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hospitalmgt.exception.BadResourceException;
import com.hospitalmgt.exception.ResourceAlreadyExistsException;
import com.hospitalmgt.exception.ResourceNotFoundException;
import com.hospitalmgt.model.Doctor;
import com.hospitalmgt.repository.DoctorRepository;
import org.springframework.data.domain.Sort;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctor> findAll(int pageNumber, int rowPerPage) {
		List<Doctor> doctors = new ArrayList<>();
		Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage, Sort.by("doctorId").ascending());
		doctorRepository.findAll(sortedByIdAsc).forEach(doctors::add);
		return doctors;
	}

	public Doctor findById(Long id) throws ResourceNotFoundException {
		Doctor doctor = doctorRepository.findById(id).orElse(null);
		if (doctor == null) {
			throw new ResourceNotFoundException("Cannot find doctor with id: " + id);
		} else
			return doctor;
	}

	public Doctor save(Doctor doctor) throws BadResourceException, ResourceAlreadyExistsException {
		if (!StringUtils.isEmpty(doctor.getName())) {
			if (doctor.getDoctorId() != null && existsById(doctor.getDoctorId())) {
				throw new ResourceAlreadyExistsException("Doctor with id: " + doctor.getDoctorId() + " already exists");
			}
			return doctorRepository.save(doctor);
		} else {
			BadResourceException exc = new BadResourceException("Failed to save dontact");
			exc.addErrorMessage("Doctor is null or empty");
			throw exc;
		}
	}

	public void update(Doctor doctor) throws BadResourceException, ResourceNotFoundException {
		if (!StringUtils.isEmpty(doctor.getName())) {
			if (!existsById(doctor.getDoctorId())) {
				throw new ResourceNotFoundException("Cannot find Doctor with id: " + doctor.getDoctorId());
			}
			doctorRepository.save(doctor);
		} else {
			BadResourceException exc = new BadResourceException("Failed to save doctor");
			exc.addErrorMessage("Doctor is null or empty");
			throw exc;
		}
	}

	public void deleteById(Long id) throws ResourceNotFoundException {
		if (!existsById(id)) {
			throw new ResourceNotFoundException("Cannot find doctor with id: " + id);
		} else {
			doctorRepository.deleteById(id);
		}
	}

	public Long count() {
		return doctorRepository.count();
	}

	private boolean existsById(Long id) {
		return doctorRepository.existsById(id);
	}
}
