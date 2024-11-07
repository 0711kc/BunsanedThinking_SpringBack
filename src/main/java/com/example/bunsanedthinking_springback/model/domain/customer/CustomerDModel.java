package com.example.bunsanedthinking_springback.model.domain.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bunsanedthinking_springback.entity.accident.Accident;
import com.example.bunsanedthinking_springback.entity.accidentHistory.AccidentHistory;
import com.example.bunsanedthinking_springback.entity.complaint.Complaint;
import com.example.bunsanedthinking_springback.entity.contract.Contract;
import com.example.bunsanedthinking_springback.entity.counsel.Counsel;
import com.example.bunsanedthinking_springback.entity.customer.Customer;
import com.example.bunsanedthinking_springback.entity.diseaseHistory.DiseaseHistory;
import com.example.bunsanedthinking_springback.entity.surgeryHistory.SurgeryHistory;
import com.example.bunsanedthinking_springback.model.domain.accident.AccidentDModel;
import com.example.bunsanedthinking_springback.model.domain.accidentHistory.AccidentHistoryDModel;
import com.example.bunsanedthinking_springback.model.domain.complaint.ComplaintDModel;
import com.example.bunsanedthinking_springback.model.domain.contract.ContractDModel;
import com.example.bunsanedthinking_springback.model.domain.counsel.CounselDModel;
import com.example.bunsanedthinking_springback.model.domain.diseaseHistory.DiseaseHistoryDModel;
import com.example.bunsanedthinking_springback.model.domain.surgeryHistory.SurgeryHistoryDModel;
import com.example.bunsanedthinking_springback.repository.CustomerMapper;
import com.example.bunsanedthinking_springback.vo.CustomerVO;

@Service
public class CustomerDModel {
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private AccidentHistoryDModel accidentHistoryDModel;
	@Autowired
	private AccidentDModel accidentDModel;
	@Autowired
	private CounselDModel counselDModel;
	@Autowired
	private SurgeryHistoryDModel surgeryHistoryDModel;
	@Autowired
	private ComplaintDModel complaintDModel;
	@Autowired
	private DiseaseHistoryDModel diseaseHistoryDModel;
	@Autowired
	private ContractDModel contractDModel;

	public Customer getById(int id) {
		CustomerVO customerVO = customerMapper.getById_Customer(id).orElse(null);
		if (customerVO == null)
			return null;
		ArrayList<AccidentHistory> accidentHistories = new ArrayList<AccidentHistory>();
		ArrayList<Accident> accidents = new ArrayList<Accident>();
		ArrayList<Counsel> counsels = new ArrayList<Counsel>();
		ArrayList<SurgeryHistory> surgeryHistories = new ArrayList<SurgeryHistory>();
		ArrayList<Complaint> complaints = new ArrayList<Complaint>();
		ArrayList<DiseaseHistory> diseaseHistories = new ArrayList<DiseaseHistory>();
		ArrayList<Contract> contracts = new ArrayList<Contract>();
		accidentHistoryDModel.getAll().stream()
			.filter(e -> e.getCustomerID() == id)
			.forEach(accidentHistories::add);
		accidentDModel.getAll().stream()
			.filter(e -> e.getCustomerID() == id)
			.forEach(accidents::add);
		counselDModel.getAll().stream()
			.filter(e -> e.getCustomerID() == id)
			.forEach(counsels::add);
		surgeryHistoryDModel.getAll().stream()
			.filter(e -> e.getCustomerID() == id)
			.forEach(surgeryHistories::add);
		complaintDModel.getAll().stream()
			.filter(e -> e.getCustomerID() == id)
			.forEach(complaints::add);
		diseaseHistoryDModel.getAll().stream()
			.filter(e -> e.getCustomer_id() == id)
			.forEach(diseaseHistories::add);
		contractDModel.getAll().stream()
			.filter(e -> e.getCustomerID() == id)
			.forEach(contracts::add);
		return new Customer(customerVO, accidentHistories, accidents, counsels, surgeryHistories, complaints,
			diseaseHistories, contracts);
	}

	public List<Customer> getAll() {
		List<Customer> customers = new ArrayList<Customer>();
		customerMapper.getAll_Customer()
			.forEach(e -> customers.add(getById(e.getId())));
		return customers;
	}

	public int getMaxId() {
		return customerMapper.getMaxId_SalesModel();
	}

	public void add(CustomerVO customerVO) {
		customerMapper.insert(customerVO);
	}

	public void update(CustomerVO customerVO) {
		customerMapper.update(customerVO);
	}

	public void delete(int id) {
		customerMapper.delete_CustomerInformationManagement(id);
	}
}
