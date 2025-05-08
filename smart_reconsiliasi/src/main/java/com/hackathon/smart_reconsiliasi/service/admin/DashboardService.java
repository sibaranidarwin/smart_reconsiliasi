package com.hackathon.smart_reconsiliasi.service.admin;


import com.hackathon.smart_reconsiliasi.dto.auth.UserRequest;
import com.hackathon.smart_reconsiliasi.dto.invoice.InvoiceDTO;
import com.hackathon.smart_reconsiliasi.dto.invoice.InvoiceDetail;
import com.hackathon.smart_reconsiliasi.dto.invoice.InvoiceResponse;
import com.hackathon.smart_reconsiliasi.model.Invoice;
import com.hackathon.smart_reconsiliasi.model.User;
import com.hackathon.smart_reconsiliasi.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public InvoiceResponse<List<InvoiceDTO>> getAllInvoice() {
        List<InvoiceDTO> data = new ArrayList<>();

        List<Invoice.ApprovalStatus> statuses = Arrays.asList(
                Invoice.ApprovalStatus.APPROVED,
                Invoice.ApprovalStatus.REJECTED
        );

        data = invoiceRepository.findByStatusIn(statuses)
                .stream()
                .map(invoice -> {
                    InvoiceDTO dto = new InvoiceDTO();
                    dto.setId(invoice.getId());
                    dto.setInvoiceNumber(invoice.getInvoiceNumber());
                    dto.setOrderDate(invoice.getOrderDate());
                    dto.setUploadedAt(invoice.getUploadedAt());
                    dto.setStatus(invoice.getStatus());

                    // map user
                    User user = invoice.getUploadedBy();
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
