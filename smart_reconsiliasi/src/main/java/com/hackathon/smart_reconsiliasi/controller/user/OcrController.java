package com.hackathon.smart_reconsiliasi.controller.user;


import com.hackathon.smart_reconsiliasi.dto.ocr.OcrRequest;
import com.hackathon.smart_reconsiliasi.dto.ocr.OcrResponse;
import com.hackathon.smart_reconsiliasi.service.user.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class OcrController {

    @Autowired
    private OcrService ocrService;

    @PostMapping("/submit-ocr")
    public OcrResponse Submitocr(@RequestBody OcrRequest request) {
        return ocrService.extractTextFromBase64(request);
    }
}

