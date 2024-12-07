package com.example.bunsanedthinking_springback.model.entityModel.report;

import com.example.bunsanedthinking_springback.entity.accident.Accident;
import com.example.bunsanedthinking_springback.entity.report.Report;
import com.example.bunsanedthinking_springback.model.entityModel.accident.AccidentEntityModel;
import com.example.bunsanedthinking_springback.repository.ReportMapper;
import com.example.bunsanedthinking_springback.vo.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportEntityModel {
	@Autowired
	private ReportMapper reportMapper;
	@Autowired
	private AccidentEntityModel accidentEntityModel;

	public Report getById(int id) {
		// 이거 로직은 걍 제가 집가서 짜볼게유 - 여기서 roadside, damage를 나눠야함
		Accident accident = accidentEntityModel.getById(id);
		if (accident == null)
			return null;
		return reportMapper.getById(id)
			.map(reportVO -> reportVO.getEntity(accident))
			.orElse(null);
	}

	public List<Report> getAll() {
		List<Report> reports = new ArrayList<Report>();
		for (ReportVO reportVO : reportMapper.getAll()) {
			Accident accident = accidentEntityModel.getById(reportVO.getAccident_id());
			reports.add(reportVO.getEntity(accident));
		}
		return reports;
	}

	public Integer getMaxId() {
		return reportMapper.getMaxId();
	}

	public void add(Report report) {
		if (report == null) return;
		if (reportMapper.getById(report.getId()).isPresent()) return;
//		accidentEntityModel.add(report.getAccident());
		reportMapper.insert(report.findVO());
	}

	public void update(Report report) {
		if (report == null) return;
		if (reportMapper.getById(report.getId()).isEmpty()) return;
		accidentEntityModel.update(report.getAccident());
		reportMapper.update(report.findVO());
		// 이건 사고 정보가 수정될 수도 있고 없을 수도 있어서 그대로 반영되도록 함
	}

	public void delete(int id) {
		if (reportMapper.getById(id).isEmpty()) return;
		Report report = getById(id);
		reportMapper.deleteById(id);
		Accident accident = report.getAccident();
		if (accident == null) return;
		accidentEntityModel.delete(accident.getId());
	}
}
