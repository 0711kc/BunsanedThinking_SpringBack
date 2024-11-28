package com.example.bunsanedthinking_springback.dto.employee.customerInformationManagement;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AddCustomerInformationRequest {
    private String name;
    private String phoneNumber;
    private String job;
    private int age;
    private int gender;
    private String residentRegistrationNumber;
    private String address;
    private long property;
    private List<AddAccidentHistoryReuqest> accidentHistoryList;
    private List<AddSurgeryHistoryRequest> surgeryHistoryList;
    private List<AddDiseaseHistoryRequest> diseaseHistoryList;
    private String bankName;
    private String bankAccount;
}
