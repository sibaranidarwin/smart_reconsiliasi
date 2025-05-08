package com.hackathon.smart_reconsiliasi.dto.invoice;

import com.hackathon.smart_reconsiliasi.dto.auth.UserRequest;
import com.hackathon.smart_reconsiliasi.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class InvoiceDTO {
    private Long id;
    private String invoiceNumber;
    private LocalDate orderDate;
    private LocalDateTime uploadedAt;
    private Invoice.ApprovalStatus status;
    private UserRequest uploadedBy;
    private List<InvoiceDetail> invoiceDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public Invoice.ApprovalStatus getStatus() {
        return status;
    }

    public void setStatus(Invoice.ApprovalStatus status) {
        this.status = status;
    }

    public UserRequest getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(UserRequest uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }
}
