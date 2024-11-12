package com.example.bunsanedthinking_springback.model.service.partnerCompany;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bunsanedthinking_springback.global.exception.NotExistException;
import com.example.bunsanedthinking_springback.repository.PartnerCompanyMapper;
import com.example.bunsanedthinking_springback.repository.ReportMapper;
import com.example.bunsanedthinking_springback.vo.PartnerCompanyVO;
import com.example.bunsanedthinking_springback.vo.ReportVO;

@Service
public class PartnerCompanyService {
	@Autowired
	private PartnerCompanyMapper partnerCompanyMapper;
	@Autowired
	private ReportMapper reportMapper;

	public PartnerCompanyVO getPartnerCompany(int id) throws NotExistException {
		PartnerCompanyVO partnerCompanyVO = partnerCompanyMapper.getById(id).orElse(null);
		if (partnerCompanyVO == null) {
			throw new NotExistException();
		}
		return partnerCompanyVO;
	}

	// public ArrayList<ReportVO> getAllReportByDamageAssessmentCompanyID(int id) {
	// 	List<ReportVO> reports = reportMapper.findAllByDamageAssessmentCompanyID_PartnerCompany(id);
	// 	return new ArrayList<>(reports);
	// }

	// public ReportVO getReport(int id) throws NotExistException {
	// 	ReportVO reportVO = reportMapper.findById_PartnerCompany(id);
	// 	if (reportVO == null) {
	// 		throw new NotExistException();
	// 	}
	// 	return reportVO;
	// }

	public void update(ReportVO reportVO) throws NotExistException {
		Optional<ReportVO> existingReportVO = reportMapper.getById(reportVO.getAccident_id());
		if (existingReportVO.isEmpty()) {
			throw new NotExistException();
		}
		reportMapper.updateReport(reportVO);
	}

	public void setDamageAssessmentMoney(int reportId, int damageAssessmentMoney) throws NotExistException {
		ReportVO reportVO = reportMapper.getById(reportId)
			.orElseThrow(() -> new NotExistException("해당하는 신고 정보가 존재하지 않습니다."));
		reportVO.setDamage_assessment_money(damageAssessmentMoney);
		reportMapper.update(reportVO);
	}
}
