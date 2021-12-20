package com.hospitalmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorId;
	private String name;
	private String contanctNo;
	private String email;
	private String speciality;
	private String photo;
	private String idProof;
	private String userName;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long  doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContanctNo() {
		return contanctNo;
	}

	public void setContanctNo(String contanctNo) {
		this.contanctNo = contanctNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", contanctNo=" + contanctNo + ", email=" + email
				+ ", speciality=" + speciality + ", photo=" + photo + ", idProof=" + idProof + ", userName=" + userName
				+ "]";
	}

}
