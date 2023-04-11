package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.BranchDto;
import com.bank.publicinfo.service.BranchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {

    private final BranchService branchService;


    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping
    public ResponseEntity<List<BranchDto>> getAllBranches() {
        List<BranchDto> branchDtoList = branchService.getAllBranches();
        return ResponseEntity.ok(branchDtoList);
    }

    @GetMapping("/{id}")
    public BranchDto getAtms(@PathVariable Long id) {
        return branchService.getBranchById(id);
    }

    @PostMapping()
    public ResponseEntity<BranchDto> createAtm (@RequestBody BranchDto branchDto) {
        BranchDto createdDto = branchService.createBranch(branchDto);
        return ResponseEntity
                .created(URI.create("/atms" + createdDto.id()))
                .body(createdDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchDto> update(@PathVariable Long id, @RequestBody BranchDto branchDto) {
        BranchDto updatedDto = branchService.updateBranch(id, branchDto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        branchService.deleteBranchById(id);
        return ResponseEntity.noContent().build();
    }

}
