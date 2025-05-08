package com.hackathon.smart_reconsiliasi.controller.approval;

import com.hackathon.smart_reconsiliasi.dto.BaseResponse;
import com.hackathon.smart_reconsiliasi.dto.approval.ApproveRequest;
import com.hackathon.smart_reconsiliasi.dto.invoice.InvoiceDTO;
import com.hackathon.smart_reconsiliasi.dto.invoice.InvoiceResponse;
import com.hackathon.smart_reconsiliasi.service.approval.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/approve")
public class ApprovalController {

    @Autowired
    private ApprovalService approvedService;

    @GetMapping("/list")
    public InvoiceResponse<List<InvoiceDTO>> getWaitingInvoices() {
        return(approvedService.getAllWaitingInvoices());
    }

    @PostMapping("/update")
    public BaseResponse approveInvoice(@RequestBody ApproveRequest request){
        return approvedService.approveInvoice(request);
    }
}
