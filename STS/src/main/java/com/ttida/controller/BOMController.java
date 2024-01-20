package com.ttida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ttida.model.BOM;
import com.ttida.repository.BOMRepository;

import java.util.List;

@RestController
@RequestMapping("/api/bom")
public class BOMController {

    @Autowired
    private BOMRepository bomRepository;

    @GetMapping
    public List<BOM> getAllBOMs() {
        return bomRepository.findAll();
    }

    @GetMapping("/{bomCode}")
    public ResponseEntity<BOM> getBOMByCode(@PathVariable String bomCode) {
        return bomRepository.findById(bomCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BOM> createBOM(@RequestBody BOM bom) {
        BOM savedBOM = bomRepository.save(bom);
        return ResponseEntity.ok(savedBOM);
    }

}
