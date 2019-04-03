package com.pta.model;

import org.springframework.stereotype.Component;

@Component("prescriptionPOJO")
public class PrescriptionPOJO {

	private String requestId;
	private String patientId;
	private String doctorId;
	private String requestDate;
	private String medicineId1;
	private int quantity1;
	private String medicineId2;
	private int quantity2;
	private String medicineId3;
	private int quantity3;
	private String medicineId4;
	private int quantity4;
	private String medicineId5;
	private int quantity5;
	private String otherInfo;
	private String status;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getMedicineId1() {
		return medicineId1;
	}

	public void setMedicineId1(String medicineId1) {
		this.medicineId1 = medicineId1;
	}

	public int getQuantity1() {
		return quantity1;
	}

	public void setQuantity1(int quantity1) {
		this.quantity1 = quantity1;
	}

	public String getMedicineId2() {
		return medicineId2;
	}

	public void setMedicineId2(String medicineId2) {
		this.medicineId2 = medicineId2;
	}

	public int getQuantity2() {
		return quantity2;
	}

	public void setQuantity2(int quantity2) {
		this.quantity2 = quantity2;
	}

	public String getMedicineId3() {
		return medicineId3;
	}

	public void setMedicineId3(String medicineId3) {
		this.medicineId3 = medicineId3;
	}

	public int getQuantity3() {
		return quantity3;
	}

	public void setQuantity3(int quantity3) {
		this.quantity3 = quantity3;
	}

	public String getMedicineId4() {
		return medicineId4;
	}

	public void setMedicineId4(String medicineId4) {
		this.medicineId4 = medicineId4;
	}

	public int getQuantity4() {
		return quantity4;
	}

	public void setQuantity4(int quantity4) {
		this.quantity4 = quantity4;
	}

	public String getMedicineId5() {
		return medicineId5;
	}

	public void setMedicineId5(String medicineId5) {
		this.medicineId5 = medicineId5;
	}

	public int getQuantity5() {
		return quantity5;
	}

	public void setQuantity5(int quantity5) {
		this.quantity5 = quantity5;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

}
