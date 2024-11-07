package com.example.bunsanedthinking_springback.controller.customer;

import com.example.bunsanedthinking_springback.dto.customer.DepositDTO;
import com.example.bunsanedthinking_springback.entity.accident.Accident;
import com.example.bunsanedthinking_springback.entity.complaint.Complaint;
import com.example.bunsanedthinking_springback.entity.contract.Contract;
import com.example.bunsanedthinking_springback.entity.customer.Customer;
import com.example.bunsanedthinking_springback.entity.insurance.Insurance;
import com.example.bunsanedthinking_springback.entity.loan.Loan;
import com.example.bunsanedthinking_springback.global.exception.*;
import com.example.bunsanedthinking_springback.model.service.customer.CustomerSModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerSModel customerSModel;
	// 아무래도 엔티티 타입으로 받는건 값을 다시 생각해봐야할듯염
	// 일단 임의로 파라미터 타입은 바꿀게유 - 엔티티 값이 다 필요 없을듯
	//	public void applyEndorsement(ContractList contractList, EndorsementList endorsementList, int index,
	//								 Contract contract) throws NotExistContractException {
	//		customerModel.applyEndorsement(contractList, endorsementList, index, contract);
	//	}
	// 	public void applyInsuranceRevival(ContractList contractList, RevivalList revivalList, Contract contract,
	//									  Customer customer) throws NotExistContractException, NotExistTerminatedContract {
	//		customerModel.applyInsuranceRevival(contractList, revivalList, contract, customer);
	//	}//	public void applyInsuranceTermination(ContractList contractList, TerminationList terminationList, Contract contract,
	//										  Customer customer) throws NotExistContractException, NotExistMaintainedContract {
	//		customerModel.applyInsuranceTermination(contractList, terminationList, contract, customer);
	//	}
	//	public void applyRecontract(ContractList contractList, RecontractList recontractList, Contract contract,
	//								Customer customer) throws NotExistContractException, NotExistExpiredContract {
	//		customerModel.applyRecontract(contractList, recontractList, contract, customer);
	//	}
	// 	public void payInsurancefee(Customer customer, Contract contract, int money, DepositPath path,
	//								DepositDetailList depositDetailList) {
	//		customerModel.payInsurancefee(customer, contract, money, path, depositDetailList);
	//	}
	// 	public Customer getCustomerById(CustomerList customerList, int id) throws NotExistException {
	//		return customerModel.getCustomerById(customerList, id);
	//	}
	//	public ArrayList<Insurance> getAllInsurance(ProductList productList) {
	//		return customerModel.getAllInsurance(productList);
	//	}
	//	public ArrayList<Insurance> getAllDiseaseInsurance(ProductList productList) {
	//		return customerModel.getAllDiseaseInsurance(productList);
	//	}
	//	public ArrayList<Insurance> getAllInjuryInsurance(ProductList productList) {
	//		return customerModel.getAllInjuryInsurance(productList);
	//	}
	//	public ArrayList<Insurance> getAllAutomobileInsurance(ProductList productList) {
	//		return customerModel.getAllAutomobileInsurance(productList);
	//	}
	//	public Insurance getInsuranceByProductId(int id, ProductList productList) throws NotExistException {
	//		return customerModel.getInsuranceByProductId(id, productList);
	//	}
	//	public ArrayList<Loan> getAllLoan(ProductList productList) {
	//		return customerModel.getAllLoan(productList);
	//	}
	//	public ArrayList<Loan> getAllCollateralLoan(ProductList productList) {
	//		return customerModel.getAllCollateralLoan(productList);
	//	}
	//	public ArrayList<Loan> getAllFixedDepositLoan(ProductList productList) {
	//		return customerModel.getAllFixedDepositLoan(productList);
	//	}
	//	public ArrayList<Loan> getAllInsuranceContractLoan(ProductList productList) {
	//		return customerModel.getAllInsuranceContractLoan(productList);
	//	}
	//	public Loan getLoanByProductId(ProductList productList, int id) throws NotExistException {
	//		return customerModel.getLoanByProductId(productList, id);
	//	}
	//	public ArrayList<Contract> getAllApprovedByCustomer(ContractList contractList, int id) throws NotExistContractException, NotExistException {
	//		return customerModel.getAllApprovedByCustomer();
	//	}
	//	public ArrayList<Contract> getAllContractByCustomerId(ContractList contractList, int id) throws NotExistContractException, NotExistException {
	//		return customerModel.getAllContractByCustomerId(contractList, id);
	//	}
	//	public ArrayList<Contract> getAllAutomobileInsuranceContract(ContractList contractList) throws NotExistContractException, NotExistException {
	//		return customerModel.getAllAutomobileInsuranceContract(contractList);
	//	}
	//	public ArrayList<Contract> getAllInjuryInsuranceContract(ContractList contractList) throws NotExistContractException {
	//		return customerModel.getAllInjuryInsuranceContract(contractList);
	//	}
	//	public ArrayList<Contract> getAllDiseaseInsuranceContract(ContractList contractList) throws NotExistContractException {
	//		return customerModel.getAllDiseaseInsuranceContract(contractList);
	//	}
	//	public ArrayList<Contract> getContractByProductId(ContractList contractList, int id) throws NotExistContractException, NotExistException {
	//		return customerModel.getContractByProductId(contractList, id);
	//	}
	//	public Contract getContractById(ContractList contractList, int id) throws NotExistContractException, NotExistException {
	//		return customerModel.getContractById(contractList, id);
	//	}
	//	public Contract getContractByOneAutomobileId(ContractList contractList, int id) throws NotExistContractException, NotExistException {
	//		return customerModel.getContractByOneAutomobileId(contractList, id);
	//	}
	//	public ArrayList<Accident> getAllAccidentByCustomerId(AccidentList accidentList, int id) {
	//		ArrayList<Accident> accidents = null;
	//		try {
	//			accidents = customerModel.getAllAccidentByCustomerId(new AccidentListImpl(), id);
	//		} catch (NotExistException e) {
	//
	//		}
	//		return accidents;
	////		return customerModel.getAllByCustomer(accidentList, id);
	//	}
	//	public Accident get(AccidentList accidentList, int id) throws NotExistException {
	//		return customerModel.getAccidentById(accidentList, id);
	//	}
	//	public ArrayList<Complaint> getAllComplaintsByCustomerId(ComplaintList complaintList, int id) {
	//        try {
	//            return customerModel.getAllComplaintsByCustomerId(complaintList, id);
	//        } catch (NotExistException e) {
	//            throw new RuntimeException(e);
	//        }
	//    }
	//	public Complaint getComplaintById(ComplaintList complaintList, int id) throws NotExistException {
	//		return customerModel.getComplaintById(complaintList, id);
	//	}
	@PatchMapping("/applyEndorsement")
	public void applyEndorsement(@RequestParam int index, @RequestParam int contractId)
				throws NotExistContractException, NotExistException {
		customerSModel.applyEndorsement(index, contractId);
	}

	@PatchMapping("/applyInsuranceRevival")
	public void applyInsuranceRevival(@RequestParam int contractId, @RequestParam Date expirationDate)
            	throws NotExistContractException, NotExistTerminatedContract, NotExistException {
		customerSModel.applyInsuranceRevival(contractId, expirationDate);
	}

	@PatchMapping("/applyInsuranceTermination")
	public void applyInsuranceTermination(@RequestParam int contractId)
				throws NotExistContractException, NotExistMaintainedContract, NotExistException {
		customerSModel.applyInsuranceTermination(contractId);
	}

	@PatchMapping("/applyInsuranceRecontract")
	public void applyInsuranceRecontract(@RequestParam int contractId)
				throws NotExistContractException, NotExistExpiredContract, NotExistException {
		customerSModel.applyRecontract(contractId);
	}

	@PostMapping("/payInsurancefee")
	public void payInsurancefee(@RequestBody DepositDTO depositDTO)
			throws NotExistContractException, NotExistException {
		customerSModel.payInsurancefee(depositDTO);
	}

	@GetMapping("/getCustomerById")
	// http://localhost:8080/customer/getCustomerById?id=2002 - Get Post Patch delete
	public Customer getCustomerById(@RequestParam int id) throws NotExistException, NotExistContractException {
		return customerSModel.getCustomerById(id);
	}

	@GetMapping("/getAllInsurance")
	public ArrayList<Insurance> getAllInsurance() {
		return customerSModel.getAllInsurance();
	}

	@GetMapping("/getAllDiseaseInsurance")
	public ArrayList<Insurance> getAllDiseaseInsurance() {
		return customerSModel.getAllDiseaseInsurance();
	}

	@GetMapping("/getAllInjuryInsurance")
	public ArrayList<Insurance> getAllInjuryInsurance() {
		return customerSModel.getAllInjuryInsurance();
	}

	@GetMapping("/getAllAutomobileInsurance")
	public ArrayList<Insurance> getAllAutomobileInsurance() {
		return customerSModel.getAllAutomobileInsurance();
	}

	@GetMapping("/getInsuranceByProductId")
	public Insurance getInsuranceByProductId(@RequestParam int id) throws NotExistException {
		return customerSModel.getInsuranceByProductId(id);
	}

	@GetMapping("/getAllLoan")
	public ArrayList<Loan> getAllLoan() {
		return customerSModel.getAllLoan();
	}

	@GetMapping("/getAllCollateralLoan")
	public ArrayList<Loan> getAllCollateralLoan() {
		return customerSModel.getAllCollateralLoan();
	}

	@GetMapping("/getAllFixedDepositLoan")
	public ArrayList<Loan> getAllFixedDepositLoan() {
		return customerSModel.getAllFixedDepositLoan();
	}

	@GetMapping("/getAllInsuranceContractLoan")
	public ArrayList<Loan> getAllInsuranceContractLoan() {
		return customerSModel.getAllInsuranceContractLoan(null);
	}

	@GetMapping("/getLoanByProductId")
	public Loan getLoanByProductId(@RequestParam int id) throws NotExistException {
		return customerSModel.getLoanByProductId(id);
	}

	@GetMapping("/getAllApprovedByCustomer")
	public ArrayList<Contract> getAllApprovedByCustomer() throws NotExistContractException, NotExistException {
		return customerSModel.getAllApprovedByCustomer();
	}

	@GetMapping("/getAllContractByCustomerId")
	public ArrayList<Contract> getAllContractByCustomerId(@RequestParam int id) throws NotExistContractException, NotExistException {
		return customerSModel.getAllContractByCustomerId(id);
	}

	@GetMapping("/getAllAutomobileInsuranceContract")
	public ArrayList<Contract> getAllAutomobileInsuranceContract() throws NotExistContractException, NotExistException {
		return customerSModel.getAllAutomobileInsuranceContract();
	}

	@GetMapping("/getAllInjuryInsuranceContract")
	public ArrayList<Contract> getAllInjuryInsuranceContract() throws NotExistContractException, NotExistException {
		return customerSModel.getAllInjuryInsuranceContract();
	}

	@GetMapping("/getAllDiseaseInsuranceContract")
	public ArrayList<Contract> getAllDiseaseInsuranceContract() throws NotExistContractException, NotExistException {
		return customerSModel.getAllDiseaseInsuranceContract();
	}

	@GetMapping("/getAllContractByProductId")
	public ArrayList<Contract> getAllContractByProductId(@RequestParam int id) throws NotExistContractException, NotExistException {
		return customerSModel.getAllContractByProductId(id);
	}

	@GetMapping("/getContractById")
	public Contract getContractById(@RequestParam int id) throws NotExistContractException, NotExistException {
		return customerSModel.getContractById(id);
	}

	@GetMapping("/getContractByOneAutomobileId")
	public Contract getContractByOneAutomobileId(@RequestParam int id) throws NotExistContractException, NotExistException {
		return customerSModel.getContractByOneAutomobileId(id);
	}

	@GetMapping("/getAllAccidentByCustomerId")
	public ArrayList<Accident> getAllAccidentByCustomerId(@RequestParam int id) throws NotExistException {
		return customerSModel.getAllAccidentByCustomerId(id);
    }
	@GetMapping("/getAccidentById")
	public Accident getAccidentById(@RequestParam int id) throws NotExistException {
		return customerSModel.getAccidentById(id);
	}

	@GetMapping("/getAllComplaintsByCustomerId")
	public ArrayList<Complaint> getAllComplaintsByCustomerId(@RequestParam int id) throws NotExistException {
		return customerSModel.getAllComplaintsByCustomerId(id);
	}

	@GetMapping("/getComplaintById")
	public Complaint getComplaintById(@RequestParam int id) throws NotExistException {
		return customerSModel.getComplaintById(id);
	}
}