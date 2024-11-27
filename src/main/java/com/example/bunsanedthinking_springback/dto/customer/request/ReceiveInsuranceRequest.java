package com.example.bunsanedthinking_springback.dto.customer.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;

@Data
@NoArgsConstructor
public class ReceiveInsuranceRequest {
    private int contractId;
    private BufferedImage medicalCertificateImage;
    private BufferedImage receiptImage;
    private BufferedImage residentRegistrationCardImage;
}