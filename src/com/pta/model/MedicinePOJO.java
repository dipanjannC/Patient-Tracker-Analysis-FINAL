package com.pta.model;

import org.springframework.stereotype.Component;

@Component("medicinePOJO")
public class MedicinePOJO {
	private String medicineId;
	private String medicineDescription;
	private String cureFor;
	private String manufacturingCompany;
	private int dosage;
	private String prescribedFor;
	private int amount;

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineDescription() {
		return medicineDescription;
	}

	public void setMedicineDescription(String medicineDescription) {
		this.medicineDescription = medicineDescription;
	}

	public String getCureFor() {
		return cureFor;
	}

	public void setCureFor(String cureFor) {
		this.cureFor = cureFor;
	}

	public String getManufacturingCompany() {
		return manufacturingCompany;
	}

	public void setManufacturingCompany(String manufacturingCompany) {
		this.manufacturingCompany = manufacturingCompany;
	}

	public int getDosage() {
		return dosage;
	}

	public void setDosage(int dosage) {
		this.dosage = dosage;
	}

	public String getPrescribedFor() {
		return prescribedFor;
	}

	public void setPrescribedFor(String prescribedFor) {
		this.prescribedFor = prescribedFor;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
