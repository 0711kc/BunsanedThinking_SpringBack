package com.example.bunsanedthinking_springback.controller.employee;

import com.example.bunsanedthinking_springback.dto.employee.customerInformationManagement.AddCustomerInformationRequest;
import com.example.bunsanedthinking_springback.dto.employee.customerInformationManagement.UpdateCustomerInformationRequest;
import com.example.bunsanedthinking_springback.entity.customer.Customer;
import com.example.bunsanedthinking_springback.global.exception.DuplicateResidentRegistrationNumberException;
import com.example.bunsanedthinking_springback.global.exception.NotExistException;
import com.example.bunsanedthinking_springback.model.service.employee.customerInformationManagement.CustomerInformationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/customerInformationManagement")
public class CustomerInformationManagementController {

	@Autowired
	private CustomerInformationManagementService customerInformationManagementSModel;

	@PostMapping("/addCustomerInformation")
	public void addCustomerInformation(@RequestBody AddCustomerInformationRequest addCustomerInformationRequest) throws DuplicateResidentRegistrationNumberException {
		customerInformationManagementSModel.addCustomerInformation(addCustomerInformationRequest);
	}

	@DeleteMapping("/deleteCustomerInformation")
	public void deleteCustomerInformation(@RequestParam int id) throws NotExistException {
		customerInformationManagementSModel.deleteCustomerInformation(id);
	}

	@GetMapping("/getCustomerInformation")
	public Customer getCustomerInformation(@RequestParam int id) throws NotExistException{
		return customerInformationManagementSModel.getCustomerInformation(id);
	}

	@PatchMapping("/updateCustomerInformation")
	public void updateCustomerInformation(@RequestBody UpdateCustomerInformationRequest updateCustomerInformationRequest) throws DuplicateResidentRegistrationNumberException, NotExistException{
		customerInformationManagementSModel.updateCustomerInformation(updateCustomerInformationRequest);
	}

	@GetMapping("/getAll")
	public List<Customer> getAll() {
		return customerInformationManagementSModel.getAll();
	}
}
