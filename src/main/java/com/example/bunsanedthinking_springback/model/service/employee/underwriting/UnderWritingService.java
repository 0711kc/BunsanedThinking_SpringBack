package com.example.bunsanedthinking_springback.model.service.employee.underwriting;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bunsanedthinking_springback.entity.contract.Contract;
import com.example.bunsanedthinking_springback.entity.contract.ContractStatus;
import com.example.bunsanedthinking_springback.entity.customer.Customer;
import com.example.bunsanedthinking_springback.entity.insurance.Insurance;
import com.example.bunsanedthinking_springback.global.exception.AlreadyProcessedException;
import com.example.bunsanedthinking_springback.model.entityModel.contract.ContractDModel;
import com.example.bunsanedthinking_springback.model.entityModel.customer.CustomerDModel;

@Service
public class UnderWritingService {

	@Autowired
	private ContractDModel contractDModel;
	@Autowired
	private CustomerDModel customerDModel;

	public void applyCoperation() {

	}

	public void applyReinsurance() {

	}

	public boolean reviewAcquisition(int contractId, boolean result) throws AlreadyProcessedException {
		Contract contract = contractDModel.getById(contractId);
		if (contract.getContractStatus() != ContractStatus.ContractRequesting) {
			throw new AlreadyProcessedException();
		}
		if (result) {
			if (contract.getProduct() != null) {
				contract.setExpirationDate(Date.from(LocalDate.now().plusYears(((Insurance) contract.getProduct()).getContractPeriod()).atStartOfDay(ZoneId.systemDefault()).toInstant()));
			}
			contract.setDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			contract.setContractStatus(ContractStatus.Maintaining);
		} else {
			contract.setContractStatus(ContractStatus.Terminating);
		}
		contractDModel.update(contract);
		return result;
	}

	public ArrayList<Contract> getAllRequestingInsurance(){
		return (ArrayList<Contract>)contractDModel.getAllRequestingInsurance();
	}

	public ArrayList<Contract> getAllNotRequestingInsurance(){
		return (ArrayList<Contract>)contractDModel.getAllNotRequestingInsurance();
	}

	public Customer getCustomer(int id) {
		return customerDModel.getById(id);
	}

	public Contract getContract(int id) {
		return contractDModel.getById(id);
	}

}