package com.hospitalmgt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hospitalmgt.exception.ResourceNotFoundException;
import com.hospitalmgt.model.Doctor;
import com.hospitalmgt.service.DoctorService;

@Controller()
public class DoctorController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DoctorService doctorService;

	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {
		model.addAttribute("title", "Hospital Management System");
		return "index";
	}

	@GetMapping(value = "/doctors")
	public String getDoctors(Model model, @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
		List<Doctor> doctors = doctorService.findAll(pageNumber, 5);

		System.out.println("doctors " + doctors);

		long count = doctorService.count();
		boolean hasPrev = pageNumber > 1;
		boolean hasNext = (pageNumber * 5) < count;
		model.addAttribute("doctors", doctors);
		model.addAttribute("hasPrev", hasPrev);
		model.addAttribute("prev", pageNumber - 1);
		model.addAttribute("hasNext", hasNext);
		model.addAttribute("next", pageNumber + 1);
		return "doctor-list";
	}

	@GetMapping(value = "/doctors/{doctorId}")
	public String getContactById(Model model, @PathVariable long doctorId) {
		Doctor doctor = null;
		try {
			doctor = doctorService.findById(doctorId);
		} catch (ResourceNotFoundException ex) {
			model.addAttribute("errorMessage", "Doctor not found");
		}
		model.addAttribute("doctor", doctor);
		return "doctor";
	}

	@GetMapping(value = "/doctors/add")
	public String showAddDoctor(Model model) {
		Doctor doctor = new Doctor();
		model.addAttribute("add", true);
		model.addAttribute("doctor", doctor);

		return "doctor-edit";
	}

	@PostMapping(value = "/doctors/add")
	public String addDoctor(Model model, @ModelAttribute("doctor") Doctor doctor) {
		try {
			Doctor newdoctor = doctorService.save(doctor);
			return "redirect:/doctors/" + String.valueOf(newdoctor.getDoctorId());
		} catch (Exception ex) {
			// log exception first,
			// then show error
			String errorMessage = ex.getMessage();
			logger.error(errorMessage);
			model.addAttribute("errorMessage", errorMessage);

			// model.addAttribute("contact", contact);
			model.addAttribute("add", true);
			return "doctor-edit";
		}

	}

	@GetMapping(value = { "/doctors/{doctorId}/edit" })
	public String showEditDoctor(Model model, @PathVariable long doctorId) {
		Doctor doctor = null;
		try {
			doctor = doctorService.findById(doctorId);
		} catch (ResourceNotFoundException ex) {
			model.addAttribute("errorMessage", "Doctor not found");
		}
		model.addAttribute("add", false);
		model.addAttribute("doctor", doctor);
		return "doctor-edit";
	}

	@PostMapping(value = { "/doctors/{doctorId}/edit" })
	public String updateDoctor(Model model, @PathVariable long doctorId, @ModelAttribute("doctor") Doctor doctor) {
		try {
			doctor.setDoctorId(doctorId);
			doctorService.update(doctor);
			return "redirect:/doctors/" + String.valueOf(doctor.getDoctorId());
		} catch (Exception ex) {
			// log exception first,
			// then show error
			String errorMessage = ex.getMessage();
			logger.error(errorMessage);
			model.addAttribute("errorMessage", errorMessage);

			model.addAttribute("add", false);
			return "doctor-edit";
		}
	}

    @GetMapping(value = {"/doctors/{doctorId}/delete"})
	public String deleteContactById(Model model, @PathVariable long doctorId) {
		try {
			doctorService.deleteById(doctorId);
			return "redirect:/doctors";
		} catch (ResourceNotFoundException ex) {
			String errorMessage = ex.getMessage();
			logger.error(errorMessage);
			model.addAttribute("errorMessage", errorMessage);
			return "doctor";
		}
	}

}
