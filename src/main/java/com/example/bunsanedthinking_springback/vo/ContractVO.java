package com.example.bunsanedthinking_springback.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractVO {
    private int id;
    private LocalDate date;
    private LocalDate expiration_date;
    private LocalDate payment_date;
    private LocalDate termination_date;
    private int contract_status;
    private int customer_id;
    private int employee_id;
    private int product_id;
}
