package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.AuditDto;
import com.bank.publicinfo.service.AuditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audits")
public class AuditController {
    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping
    public ResponseEntity<List<AuditDto>> getAllAudits() {
        List<AuditDto> auditDtoList = auditService.getAudits();
        return ResponseEntity.ok(auditDtoList);
    }

}
