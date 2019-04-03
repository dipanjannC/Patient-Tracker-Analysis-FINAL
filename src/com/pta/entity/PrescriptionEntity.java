package com.pta.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1001, allocationSize = 1)
@Table(name = "prescription")
public class PrescriptionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "request_id")
	private long requestId;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "patient_id")
	private PatientEntity patientEntity;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctorEntity;

	@Column(name = "request_date")
	private String requestDate;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "medicine_id_1")
	private MedicineEntity medicineEntity1;

	@Column(name = "quantity_1")
	private int quantity1;

	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "medicine_id_2", nullable=true)
	private MedicineEntity medicineEntity2;

	@Column(name = "quantity_2")
	private int quantity2;

	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "medicine_id_3")
	private MedicineEntity medicineEntity3;

	@Column(name = "quantity_3")
	private int quantity3;

	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "medicine_id_4")
	private MedicineEntity medicineEntity4;

	@Column(name = "quantity_4")
	private int quantity4;

	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "medicine_id_5")
	private MedicineEntity medicineEntity5;

	@Column(name = "quantity_5")
	private int quantity5;

	@Column(name = "other_info")
	private String otherInfo;

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public PatientEntity getPatientEntity() {
		return patientEntity;
	}

	public void setPatientEntity(PatientEntity patientEntity) {
		this.patientEntity = patientEntity;
	}

	public DoctorEntity getDoctorEntity() {
		return doctorEntity;
	}

	public void setDoctorEntity(DoctorEntity doctorEntity) {
		this.doctorEntity = doctorEntity;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public MedicineEntity getMedicineEntity1() {
		return medicineEntity1;
	}

	public void setMedicineEntity1(MedicineEntity medicineEntity1) {
		this.medicineEntity1 = medicineEntity1;
	}

	public int getQuantity1() {
		return quantity1;
	}

	public void setQuantity1(int quantity1) {
		this.quantity1 = quantity1;
	}

	public MedicineEntity getMedicineEntity2() {
		return medicineEntity2;
	}

	public void setMedicineEntity2(MedicineEntity medicineEntity2) {
		this.medicineEntity2 = medicineEntity2;
	}

	public int getQuantity2() {
		return quantity2;
	}

	public void setQuantity2(int quantity2) {
		this.quantity2 = quantity2;
	}

	public MedicineEntity getMedicineEntity3() {
		return medicineEntity3;
	}

	public void setMedicineEntity3(MedicineEntity medicineEntity3) {
		this.medicineEntity3 = medicineEntity3;
	}

	public int getQuantity3() {
		return quantity3;
	}

	public void setQuantity3(int quantity3) {
		this.quantity3 = quantity3;
	}

	public MedicineEntity getMedicineEntity4() {
		return medicineEntity4;
	}

	public void setMedicineEntity4(MedicineEntity medicineEntity4) {
		this.medicineEntity4 = medicineEntity4;
	}

	public int getQuantity4() {
		return quantity4;
	}

	public void setQuantity4(int quantity4) {
		this.quantity4 = quantity4;
	}

	public MedicineEntity getMedicineEntity5() {
		return medicineEntity5;
	}

	public void setMedicineEntity5(MedicineEntity medicineEntity5) {
		this.medicineEntity5 = medicineEntity5;
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

	@Column(name = "status")
	private String status;

}
