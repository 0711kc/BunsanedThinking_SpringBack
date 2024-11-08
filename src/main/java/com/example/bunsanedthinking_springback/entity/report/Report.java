package com.example.bunsanedthinking_springback.entity.report;

import com.example.bunsanedthinking_springback.entity.accident.Accident;
import com.example.bunsanedthinking_springback.entity.partnerCompany.PartnerCompany;
import com.example.bunsanedthinking_springback.vo.ReportVO;
import lombok.NoArgsConstructor;

/**
 * @author ����ȯ
 * @version 1.0
 * @created 27-5-2024 ���� 4:40:44
 */
@NoArgsConstructor
public class Report {

	public static final int REPORT_SERIAL_NUMBER = 500;
	private Accident accident;
	private int damageAssessmentMoney;
	private int id;
	private int roadsideAssistanceCompanyID;
	private int damageAssessmentCompanyID;
	private ReportProcessStatus processStatus;

	public void setProcessStatus(ReportProcessStatus processStatus) {
		this.processStatus = processStatus;
	}

	public Report(Accident accident, PartnerCompany damageAssessmentCompany, PartnerCompany roadsideAssistanceCompany){
		this.accident = accident;
		this.damageAssessmentMoney = -1;
		this.damageAssessmentCompanyID = damageAssessmentCompany.getId();
		this.roadsideAssistanceCompanyID = roadsideAssistanceCompany.getId();
		this.processStatus = ReportProcessStatus.Unprocessed;
	}

	public ReportVO getVO() {
		return new ReportVO(id, damageAssessmentMoney,
				processStatus.ordinal(),
				roadsideAssistanceCompanyID,
				damageAssessmentCompanyID);
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setDamageAssessmentMoney(int damageAssessmentMoney) {
		this.damageAssessmentMoney = damageAssessmentMoney;
	}

	public void handle(){
		this.processStatus = ReportProcessStatus.Completed;
		this.accident.complete();
	}

	public Accident getAccident() {
		return accident;
	}

	public int getDamageAssessmentMoney() {
		return damageAssessmentMoney;
	}

	public int getId() {
		return id;
	}

	public ReportProcessStatus getProcessStatus() {
		return processStatus;
	}

	public int getRoadsideAssistanceCompanyID() {
		return roadsideAssistanceCompanyID;
	}

	public int getDamageAssessmentCompanyID() {
		return damageAssessmentCompanyID;
	}

	public void setAccident(Accident accident) {
		this.accident = accident;
	}

	public void setRoadsideAssistanceCompanyID(int roadsideAssistanceCompanyID) {
		this.roadsideAssistanceCompanyID = roadsideAssistanceCompanyID;
	}

	public void setDamageAssessmentCompanyID(int damageAssessmentCompanyID) {
		this.damageAssessmentCompanyID = damageAssessmentCompanyID;
	}
}