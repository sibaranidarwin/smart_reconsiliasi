package com.hackathon.smart_reconsiliasi.service.approval;


import com.hackathon.smart_reconsiliasi.dto.BaseResponse;
import com.hackathon.smart_reconsiliasi.dto.approval.ApproveRequest;
import com.hackathon.smart_reconsiliasi.dto.auth.UserRequest;
import com.hackathon.smart_reconsiliasi.dto.invoice.InvoiceDTO;
import com.hackathon.smart_reconsiliasi.dto.invoice.InvoiceDetail;
import com.hackathon.smart_reconsiliasi.dto.invoice.InvoiceResponse;
import com.hackathon.smart_reconsiliasi.model.Invoice;
import com.hackathon.smart_reconsiliasi.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApprovalService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public BaseResponse approveInvoice(ApproveRequest request) {

        Invoice invoice = invoiceRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + request.getId()));

        if (!invoice.getStatus().equals(Invoice.ApprovalStatus.WAITING)) {
            throw new RuntimeException("Invoice is not in WAITING status");
        }

        if ("APPROVED".equalsIgnoreCase(request.getStatus())) {
            invoice.setStatus(Invoice.ApprovalStatus.APPROVED);
        } else if ("REJECTED".equalsIgnoreCase(request.getStatus())) {
            invoice.setStatus(Invoice.ApprovalStatus.REJECTED);
        } else {
            throw new IllegalArgumentException("Invalid status: " + request.getStatus());
        }

        invoiceRepository.save(invoice);
        return new BaseResponse("Update Data Success", "00");
    }

    public InvoiceResponse<List<InvoiceDTO>> getAllWaitingInvoices() {
        List<InvoiceDTO> data = new ArrayList<>();

        data = invoiceRepository.findByStatus(Invoice.ApprovalStatus.WAITING)
                .stream()
                .map(invoice -> {
                    InvoiceDTO dto = new InvoiceDTO();
                    dto.setId(invoice.getId());
                    dto.setInvoiceNumber(invoice.getInvoiceNumber());
                    dto.setOrderDate(invoice.getOrderDate());
                    dto.setUploadedAt(invoice.getUploadedAt());
                    dto.setStatus(invoice.getStatus());

                    // map user
                    com.hackathon.smart_reconsiliasi.model.User user = invoice.getUploadedBy();
                    if (user != null) {
                        dto.setUploadedBy(new UserRequest(user.getId(), user.getUsername()));
                    }

                    // map detail list
                    List<InvoiceDetail> details = invoice.getInvoiceDetails().stream()
                            .map(detail -> new InvoiceDetail(detail.getId(), detail.getProfession(), detail.getSalary()))
                            .collect(Collectors.toList());

                    dto.setInvoiceDetails(details);

                    return dto;
                })
                .collect(Collectors.toList());

        return new InvoiceResponse<>("00", "Success", data);
    }
}

