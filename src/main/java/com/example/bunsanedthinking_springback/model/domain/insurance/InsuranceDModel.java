package com.example.bunsanedthinking_springback.model.domain.insurance;

import com.example.bunsanedthinking_springback.entity.insurance.Automobile;
import com.example.bunsanedthinking_springback.entity.insurance.Disease;
import com.example.bunsanedthinking_springback.entity.insurance.Injury;
import com.example.bunsanedthinking_springback.entity.insurance.Insurance;
import com.example.bunsanedthinking_springback.model.domain.automobile.AutomobileDModel;
import com.example.bunsanedthinking_springback.model.domain.disease.DiseaseDModel;
import com.example.bunsanedthinking_springback.model.domain.injury.InjuryDModel;
import com.example.bunsanedthinking_springback.repository.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceDModel {
	@Autowired
	private InsuranceMapper insuranceMapper;
	@Autowired
	private DiseaseDModel diseaseDModel;
	@Autowired
	private InjuryDModel injuryDModel;
	@Autowired
	private AutomobileDModel automobileDModel;

	public Insurance getById(int id) {
		Insurance insurance = diseaseDModel.getById(id);
		if (insurance != null)
			return insurance;
		insurance = injuryDModel.getById(id);
		if (insurance != null)
			return insurance;
		insurance = automobileDModel.getById(id);
		return insurance;
	}

	public List<Insurance> getAll() {
		List<Insurance> insurances = new ArrayList<Insurance>();
		insuranceMapper.getAll_Customer()
			.forEach(e -> insurances.add(getById(e.getProduct_id())));
		return insurances;
	}

	public Integer getMaxId() {
		return insuranceMapper.getMaxId_ProductManagementModel();
	}

	public void add(Insurance insurance) {
		if (insurance == null) return;
		else if (insurance instanceof Injury) injuryDModel.add((Injury) insurance);
		else if (insurance instanceof Disease) diseaseDModel.add((Disease) insurance);
		else if (insurance instanceof Automobile) automobileDModel.add((Automobile) insurance);
	}

	public void update(Insurance insurance) {
		if (insurance == null) return;
		else if (insurance instanceof Injury) injuryDModel.update((Injury) insurance);
		else if (insurance instanceof Disease) diseaseDModel.update((Disease) insurance);
		else if (insurance instanceof Automobile) automobileDModel.update((Automobile) insurance);
	}

	public void delete(int id) {
		Insurance insurance = getById(id);
		if (insurance == null) return;
		else if (insurance instanceof Injury) injuryDModel.delete(id);
		else if (insurance instanceof Disease) diseaseDModel.delete(id);
		else if (insurance instanceof Automobile) automobileDModel.delete(id);
	}
}
