package com.hackathon.smart_reconsiliasi.repository;

import com.hackathon.smart_reconsiliasi.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByStatus(Invoice.ApprovalStatus status);

    List<Invoice> findByStatusIn(List<Invoice.ApprovalStatus> statuses);

    Optional<Invoice> findByInvoiceNumber (String invoiceNumber);

}