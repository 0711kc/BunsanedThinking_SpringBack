package com.example.bunsanedthinking_springback.dto.employee.productManagement.response;

import com.example.bunsanedthinking_springback.entity.insurance.Insurance;
import com.example.bunsanedthinking_springback.entity.insurance.InsuranceType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManageInsuranceProductResponse {
	private String name;
	private String insuranceType;
	private Integer id;
	private Integer ageRange;
	private Integer monthlyPremium;
	private Integer maximumMoney;

	public static ManageInsuranceProductResponse from(Insurance insurance){
		return ManageInsuranceProductResponse.builder().name(insurance.getName()).insuranceType(insurance.getInsuranceType().getName()).id(insurance.getId()).ageRange(insurance.getAgeRange()).monthlyPremium(insurance.getMonthlyPremium())
			.maximumMoney(insurance.getMaximumMoney()).build();
	}
}
