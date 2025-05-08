package com.hackathon.smart_reconsiliasi.controller.admin;

import com.hackathon.smart_reconsiliasi.dto.invoice.InvoiceDTO;
import com.hackathon.smart_reconsiliasi.dto.invoice.InvoiceResponse;
import com.hackathon.smart_reconsiliasi.service.admin.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @PostMapping("/list")
    public InvoiceResponse<List<InvoiceDTO>> getallinvoice() {
        return dashboardService.getAllInvoice();
    }

}
