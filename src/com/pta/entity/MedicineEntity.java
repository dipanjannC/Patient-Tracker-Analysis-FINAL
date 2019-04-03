package com.pta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1001, allocationSize = 1)
@Table(name = "medicine")
public class MedicineEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "medicine_id")
	private long medicineId;

	@Column(name = "medicine_description")
	private String medicineDescription;

	@Column(name = "cure_for")
	private String cureFor;

	@Column(name = "manufacturing_company")
	private String manufacturingCompany;

	@Column(name = "dosage")
	private int dosage;

	@Column(name = "prescribed_for")
	private String prescribedFor;

	@Column(name = "amount")
	private int amount;

	public long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(long medicineId) {
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
