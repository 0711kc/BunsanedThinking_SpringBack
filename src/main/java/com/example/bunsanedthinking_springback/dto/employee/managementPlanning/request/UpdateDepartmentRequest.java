package com.example.bunsanedthinking_springback.dto.employee.managementPlanning.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateDepartmentRequest {
    private int index;
    private String input;
    private int id;
}
