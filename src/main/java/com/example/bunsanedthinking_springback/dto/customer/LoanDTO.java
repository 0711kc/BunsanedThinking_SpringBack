package com.example.bunsanedthinking_springback.dto.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoanDTO {
    private int loanId;
    private int customerId;
    private Integer employeeId;
}