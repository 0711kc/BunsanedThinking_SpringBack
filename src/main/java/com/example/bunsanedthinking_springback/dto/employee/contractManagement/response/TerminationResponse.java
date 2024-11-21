package com.example.bunsanedthinking_springback.dto.employee.contractManagement.response;

import com.example.bunsanedthinking_springback.entity.termination.Termination;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TerminationResponse extends AbstractContractResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date applyDate; // 해지 날짜
    private int terminationFee; // 제지급 금액
    private String terminationStatus; // 심사 상태

    public TerminationResponse(int id, CustomerInfoResponse customerInfoResponse,
                               int productId, Date applyDate, int terminationFee, String terminationStatus) {
        super(id, customerInfoResponse, productId);
        this.applyDate = applyDate;
        this.terminationFee = terminationFee;
        this.terminationStatus = terminationStatus;
    }

    public static TerminationResponse of(CustomerInfoResponse customerInfoResponse, Termination termination) {
        int id = termination.getId();
        int productId = termination.getProductId();
        Date applyDate = termination.getApplyDate();
        String terminationStatus = termination.getTerminationStatus().getText();
        int terminationFee = termination.getTerminationFee();
        return new TerminationResponse(id, customerInfoResponse, productId, applyDate, terminationFee, terminationStatus);
    }
}