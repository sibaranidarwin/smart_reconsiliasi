package com.hackathon.smart_reconsiliasi.dto.invoice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class InvoiceDetail{

    private String profession;
    private String salary;

    public InvoiceDetail() {}

    // Constructor dengan semua argumen
    public InvoiceDetail(Long id, String profession, String salary) {
        this.profession = profession;
        this.salary = salary;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}

