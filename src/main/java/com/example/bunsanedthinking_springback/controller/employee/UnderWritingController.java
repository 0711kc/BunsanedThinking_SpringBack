package com.example.bunsanedthinking_springback.controller.employee;

import com.example.bunsanedthinking_springback.entity.contract.Contract;
import com.example.bunsanedthinking_springback.entity.customer.Customer;
import com.example.bunsanedthinking_springback.model.service.employee.underwriting.UnderWritingService;
import com.example.bunsanedthinking_springback.global.exception.AlreadyProcessedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/employee/underWriting")
public class UnderWritingController {
	@Autowired
	private UnderWritingService underWritingSModel;

	@PostMapping("/applyCoperation")
	public void applyCoperation() {
		underWritingSModel.applyCoperation();
	}

	@PostMapping("/applyReinsurance")
	public void applyReinsurance() {
		underWritingSModel.applyReinsurance();
	}

	@PatchMapping("/reviewAcquisition")
	public boolean reviewAcquisition(int contractId, boolean result)
		throws AlreadyProcessedException {
		return underWritingSModel.reviewAcquisition(contractId, result);
	}

	@GetMapping("/getAllRequestingInsurance")
	public ArrayList<Contract> getAllRequestingInsurance(){
		return underWritingSModel.getAllRequestingInsurance();
	}

	@GetMapping("/getCustomer")
	public Customer getCustomer(int id)  {
		return underWritingSModel.getCustomer(id);
	}

	@GetMapping("/getContract")
	public Contract getContract(int id){
		return underWritingSModel.getContract(id);
	}

	@GetMapping("/getAllNotRequestingInsurance")
	public ArrayList<Contract> getAllNotRequestingInsurance(){
		return underWritingSModel.getAllNotRequestingInsurance();
	}

}
