package com.example.bunsanedthinking_springback.model.service.employee.productManagement;

import com.example.bunsanedthinking_springback.dto.employee.productManagement.AddAutomobileInsuranceDTO;
import com.example.bunsanedthinking_springback.dto.employee.productManagement.AddDiseaseInsuranceDTO;
import com.example.bunsanedthinking_springback.dto.employee.productManagement.AddInjuryInsuranceDTO;
import com.example.bunsanedthinking_springback.entity.insurance.*;
import com.example.bunsanedthinking_springback.entity.product.Product;
import com.example.bunsanedthinking_springback.global.exception.DuplicateInsuranceException;
import com.example.bunsanedthinking_springback.global.exception.NotExistException;
import com.example.bunsanedthinking_springback.global.util.NextIdGetter;
import com.example.bunsanedthinking_springback.model.entityModel.automobile.AutomobileEntityModel;
import com.example.bunsanedthinking_springback.model.entityModel.disease.DiseaseEntityModel;
import com.example.bunsanedthinking_springback.model.entityModel.injury.InjuryEntityModel;
import com.example.bunsanedthinking_springback.model.entityModel.insurance.InsuranceEntityModel;
import com.example.bunsanedthinking_springback.model.entityModel.product.ProductEntityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @version 1.0
 * @created 20-5-2024 占쏙옙占쏙옙 7:52:27
 */

@Service
public class ProductManagementService {

	@Autowired
	private ProductEntityModel productEntityModel;
	@Autowired
	private InsuranceEntityModel insuranceEntityModel;
	@Autowired
	private DiseaseEntityModel diseaseEntityModel;
	@Autowired
	private InjuryEntityModel injuryEntityModel;
	@Autowired
	private AutomobileEntityModel automobileEntityModel;

	@Value("${serials.product}")
	private Integer PRODUCT_SERIAL_NUMBER;

	@Value("${serials.insurance}")
	private Integer INSURANCE_SERIAL_NUMBER;

	public void addDiseaseInsurance(AddDiseaseInsuranceDTO addDiseaseInsuranceDTO) throws DuplicateInsuranceException {

		for (Product product : productEntityModel.getAll()) {
			if (product.getName().equals(addDiseaseInsuranceDTO.getName())) {
				throw new DuplicateInsuranceException();
			}
		}

		int insuranceId = NextIdGetter.getNextId(insuranceEntityModel.getMaxId(), Integer.parseInt("" + PRODUCT_SERIAL_NUMBER + INSURANCE_SERIAL_NUMBER));

		Disease disease = new Disease();
		disease.setId(insuranceId);
		disease.setName(addDiseaseInsuranceDTO.getName());
		disease.setMaximumMoney(addDiseaseInsuranceDTO.getMaximumMoney());
		disease.setInsuranceType(InsuranceType.fromInt(addDiseaseInsuranceDTO.getInsuranceType()));
		disease.setMonthlyPremium(addDiseaseInsuranceDTO.getMonthlyPremium());
		disease.setContractPeriod(addDiseaseInsuranceDTO.getContractPeriod());
		disease.setCoverage(addDiseaseInsuranceDTO.getCoverage());

		disease.setDiseaseName(disease.getDiseaseName());
		disease.setDiseaseLimit(addDiseaseInsuranceDTO.getDiseaseLimit());
		disease.setSurgeriesLimit(addDiseaseInsuranceDTO.getSurgeriesLimit());

		diseaseEntityModel.add(disease);
	}

	public void addInjuryInsurance(AddInjuryInsuranceDTO addInjuryInsuranceDTO) throws DuplicateInsuranceException {
		for (Product product : productEntityModel.getAll()) {
			if (product.getName().equals(addInjuryInsuranceDTO.getName())) {
				throw new DuplicateInsuranceException();
			}
		}

		int insuranceId = NextIdGetter.getNextId(insuranceEntityModel.getMaxId(), Integer.parseInt("" + PRODUCT_SERIAL_NUMBER + INSURANCE_SERIAL_NUMBER));

		Injury injury = new Injury();
		injury.setId(insuranceId);
		injury.setName(addInjuryInsuranceDTO.getName());
		injury.setMaximumMoney(addInjuryInsuranceDTO.getMaximumMoney());
		injury.setInsuranceType(InsuranceType.fromInt(addInjuryInsuranceDTO.getInsuranceType()));
		injury.setMonthlyPremium(addInjuryInsuranceDTO.getMonthlyPremium());
		injury.setContractPeriod(addInjuryInsuranceDTO.getContractPeriod());
		injury.setCoverage(addInjuryInsuranceDTO.getCoverage());

		injury.setInjuryType(InjuryType.fromInt(addInjuryInsuranceDTO.getInjuryType()));
		injury.setSurgeriesLimit(addInjuryInsuranceDTO.getSurgeriesLimit());

		injuryEntityModel.add(injury);
	}

	public void addAutomobileInsurance(AddAutomobileInsuranceDTO addAutomobileInsuranceDTO) throws DuplicateInsuranceException {
		for (Product product : productEntityModel.getAll()) {
			if (product.getName().equals(addAutomobileInsuranceDTO.getName())) {
				throw new DuplicateInsuranceException();
			}
		}

		int insuranceId = NextIdGetter.getNextId(insuranceEntityModel.getMaxId(), Integer.parseInt("" + PRODUCT_SERIAL_NUMBER + INSURANCE_SERIAL_NUMBER));

		Automobile automobile = new Automobile();
		automobile.setId(insuranceId);
		automobile.setName(addAutomobileInsuranceDTO.getName());
		automobile.setMaximumMoney(addAutomobileInsuranceDTO.getMaximumMoney());
		automobile.setInsuranceType(InsuranceType.fromInt(addAutomobileInsuranceDTO.getInsuranceType()));
		automobile.setMonthlyPremium(addAutomobileInsuranceDTO.getMonthlyPremium());
		automobile.setContractPeriod(addAutomobileInsuranceDTO.getContractPeriod());
		automobile.setCoverage(addAutomobileInsuranceDTO.getCoverage());

		automobile.setVehicleType(VehicleType.fromInt(addAutomobileInsuranceDTO.getVehicleType()));
		automobile.setAccidentLimit(addAutomobileInsuranceDTO.getAccidentLimit());
		automobile.setServiceList((ArrayList<ServiceType>) addAutomobileInsuranceDTO.getServiceList());

		automobileEntityModel.add(automobile);
	}

	public void deleteInsuranceProduct(int id) {
		productEntityModel.delete(id);
	}

	public Insurance getInsuranceProduct(int id) throws NotExistException {
		try {
			Insurance insurance = insuranceEntityModel.getById(id);
			if (insurance == null) {
				throw new NotExistException("해당하는 보험 상품 정보가 존재하지 않습니다.");
			}
			return insurance;
		} catch (NotExistException e) {
			throw new NotExistException("해당하는 보험 상품 정보가 존재하지 않습니다.");
		}
	}

	public void updateDiseaseInsurance(int index, String input, int id) throws DuplicateInsuranceException {

		Disease disease = diseaseEntityModel.getById(id);

		switch (index) {
			case 1:
				for (Product product : productEntityModel.getAll()) {
					if (product.getName().equals(input)) {
						throw new DuplicateInsuranceException();
					}
				}
				disease.setName(input);
				diseaseEntityModel.update(disease);
				break;
			case 2:
				disease.setAgeRange(Integer.parseInt(input));
				diseaseEntityModel.update(disease);
				break;
			case 3:
				disease.setCoverage(input);
				diseaseEntityModel.update(disease);
				break;
			case 4:
				disease.setMonthlyPremium(Integer.parseInt(input));
				diseaseEntityModel.update(disease);
				break;
			case 5:
				disease.setContractPeriod(Integer.parseInt(input));
				diseaseEntityModel.update(disease);
				break;
			case 6:
				disease.setDiseaseLimit(Integer.parseInt(input));
				diseaseEntityModel.update(disease);
				break;
			case 7:
				disease.setDiseaseName(input);
				diseaseEntityModel.update(disease);
				break;
			case 8:
				disease.setSurgeriesLimit(Integer.parseInt(input));
				diseaseEntityModel.update(disease);
				break;
			default:
				break;
		}
	}

	public void updateInjuryInsurance(int index, String input, int id) throws DuplicateInsuranceException {
		Injury injury = injuryEntityModel.getById(id);

		switch (index) {
			case 1:
				for (Product product : productEntityModel.getAll()) {
					if (product.getName().equals(input)) {
						throw new DuplicateInsuranceException();
					}
				}
				injury.setName(input);
				injuryEntityModel.update(injury);
				break;
			case 2:
				injury.setAgeRange(Integer.parseInt(input));
				injuryEntityModel.update(injury);
				break;
			case 3:
				injury.setCoverage(input);
				injuryEntityModel.update(injury);
				break;
			case 4:
				injury.setMonthlyPremium(Integer.parseInt(input));
				injuryEntityModel.update(injury);
				break;
			case 5:
				injury.setContractPeriod(Integer.parseInt(input));
				injuryEntityModel.update(injury);
				break;
			case 6:
				if (InjuryType.Minor.ordinal() == (Integer.parseInt(input) - 1)) {
					injury.setInjuryType(InjuryType.Minor);
				} else if (InjuryType.Serious.ordinal() == (Integer.parseInt(input) - 1)) {
					injury.setInjuryType(InjuryType.Serious);
				}
				injuryEntityModel.update(injury);
				break;
			case 7:
				injury.setSurgeriesLimit(Integer.parseInt(input));
				injuryEntityModel.update(injury);
				break;
			default:
				break;
		}
	}

	public void updateAutomobileInsurance(int index, String input, int id,
		ArrayList<ServiceType> serviceTypeList) throws DuplicateInsuranceException {

		Automobile automobile = automobileEntityModel.getById(id);

		switch (index) {
			case 1:
				for (Product product : productEntityModel.getAll()) {
					if (product.getName().equals(input)) {
						throw new DuplicateInsuranceException();
					}
				}
				automobile.setName(input);
				automobileEntityModel.update(automobile);
				break;
			case 2:
				automobile.setAgeRange(Integer.parseInt(input));
				automobileEntityModel.update(automobile);
				break;
			case 3:
				automobile.setCoverage(input);
				automobileEntityModel.update(automobile);
				break;
			case 4:
				automobile.setMonthlyPremium(Integer.parseInt(input));
				automobileEntityModel.update(automobile);
				break;
			case 5:
				automobile.setContractPeriod(Integer.parseInt(input));
				automobileEntityModel.update(automobile);
				break;
			case 6:
				automobile.setAccidentLimit(Integer.parseInt(input));
				automobileEntityModel.update(automobile);
				break;
			case 7:
				if (VehicleType.Small.ordinal() == (Integer.parseInt(input) - 1)) {
					automobile.setVehicleType(VehicleType.Small);
				} else if (VehicleType.Medium.ordinal() == (Integer.parseInt(input) - 1)) {
					automobile.setVehicleType(VehicleType.Medium);
				} else if (VehicleType.Large.ordinal() == (Integer.parseInt(input) - 1)) {
					automobile.setVehicleType(VehicleType.Large);
				}
				automobileEntityModel.update(automobile);
				break;
			case 8:
				ArrayList<ServiceType> distinctServiceList = (ArrayList<ServiceType>)serviceTypeList.stream()
					.distinct()
					.collect(Collectors.toList());
				automobile.setServiceList(distinctServiceList);
				automobileEntityModel.update(automobile);
				break;
			default:
				break;
		}

	}

	public List<Insurance> getAll() {
		return insuranceEntityModel.getAll();
	}
}
