package com.hospitalmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long staffId;
	private String name;
	private String contact;
	private String email;
	private String designation;
	private String userName;
	private String bloodGroup;
	private String photo;
	private String idProof;
	private String address;
	private String addressProof;
	private String emergencyContName;
	private String emergencyContNo;

	public long getStaffId() {
		return staffId;
	}

	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}

	public String getEmergencyContName() {
		return emergencyContName;
	}

	public void setEmergencyContName(String emergencyContName) {
		this.emergencyContName = emergencyContName;
	}

	public String getEmergencyContNo() {
		return emergencyContNo;
	}

	public void setEmergencyContNo(String emergencyContNo) {
		this.emergencyContNo = emergencyContNo;
	}

	@Override
	public String toString() {
		return "StaffModel [staffId=" + staffId + ", name=" + name + ", contact=" + contact + ", email=" + email
				+ ", designation=" + designation + ", userName=" + userName + ", bloodGroup=" + bloodGroup + ", photo="
				+ photo + ", idProof=" + idProof + ", address=" + address + ", addressProof=" + addressProof
				+ ", emergencyContName=" + emergencyContName + ", emergencyContNo=" + emergencyContNo + "]";
	}

}
