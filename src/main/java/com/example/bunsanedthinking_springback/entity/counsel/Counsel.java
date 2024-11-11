package com.example.bunsanedthinking_springback.entity.counsel;

import com.example.bunsanedthinking_springback.entity.customer.Gender;
import com.example.bunsanedthinking_springback.vo.CounselVO;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author ����ȯ
 * @version 1.0
 * @created 27-5-2024 ���� 4:40:41
 */
@NoArgsConstructor
public class Counsel implements Cloneable {

	public static int COUNSEL_SERIAL_NUMBER = 520;
	
	private Date counselDate;
	private int customerID;
	private int id;
	private CounselProcessStatus processStatus;
	private int productID;
	// Customer쪽 정보인듯
	private String name;
	private String phoneNumber;
	private String job;
	private int age;
	private Gender gender;

	public Counsel(int customerId, int productId, String name, String phoneNumber, Date counselDate, String job, int age, Gender gender){
		this.processStatus = CounselProcessStatus.Unprocessed;
		this.customerID = customerId;
		this.productID = productId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.counselDate = counselDate;
		this.job = job;
		this.age = age;
		this.gender = gender;
	}
	public Counsel(CounselVO counselVO, String name, String phoneNumber, String job, int age, Gender gender) {
		LocalDate localDate = counselVO.getCounsel_date();
		counselDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		customerID = counselVO.getCustomer_id();
		id = counselVO.getId();
		processStatus = CounselProcessStatus.values()[counselVO.getProcess_status()];
		productID = counselVO.getProduct_id();

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.job = job;
		this.age = age;
		this.gender = gender;
	}

	public CounselVO findVO() {
		LocalDate lCounselDate = new java.util.Date(counselDate.getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return new CounselVO(id, lCounselDate,
				processStatus.ordinal(), customerID,
				productID);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCounselDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(this.counselDate);
	}

	public void setCounselDate(Date counselDate) {
		this.counselDate = counselDate;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public CounselProcessStatus getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(CounselProcessStatus processStatus) {
		this.processStatus = processStatus;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}
	
	public Counsel clone() {
		Counsel counsel = new Counsel(getCustomerID(), getProductID(), getName(), getPhoneNumber(), this.counselDate,getJob(),getAge(),getGender());
		counsel.setProcessStatus(getProcessStatus());
		counsel.setId(getId());
		return counsel;
	}
	
}