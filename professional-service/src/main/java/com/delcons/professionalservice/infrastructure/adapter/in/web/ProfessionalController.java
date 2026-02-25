package com.delcons.professionalservice.infrastructure.adapter.in.web;

import com.delcons.professionalservice.application.service.ProfessionalApplicationService;
import com.delcons.professionalservice.domain.model.Professional;
import com.delcons.professionalservice.domain.port.in.ProfessionalService;
import com.delcons.professionalservice.infrastructure.adapter.in.web.dto.request.ProfessionalRequest;
import com.delcons.professionalservice.infrastructure.adapter.in.web.dto.response.ProfessionalResponse;
import com.delcons.professionalservice.infrastructure.adapter.in.web.mapper.ProfessionalRestMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/professionals")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class ProfessionalController {

    private final ProfessionalApplicationService service;
    private final ProfessionalRestMapper professionalMapper;

    @PostMapping
    public ResponseEntity<ProfessionalResponse> createProfessional(@RequestBody ProfessionalRequest request) {
        Professional professional = professionalMapper.toDomain(request);
        Professional created = service.createProfessional(professional);
        return new ResponseEntity<>(professionalMapper.toResponse(created), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalResponse> getProfessionalById(@PathVariable Long id) {
        return service.getProfessionalById(id)
                .map(professionalMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalResponse>> getAllProfessionals() {
        List<ProfessionalResponse> responses = service.getAllProfessionals().stream()
                .map(professionalMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalResponse> updateProfessional(@PathVariable Long id, @RequestBody ProfessionalRequest request) {
        Professional professional = professionalMapper.toDomain(request);
        professional.setId(id);
        try {
            Professional updated = service.updateProfessional(professional);
            return ResponseEntity.ok(professionalMapper.toResponse(updated));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessional(@PathVariable Long id) {
        boolean flag = service.deleteProfessional(id);
        return ResponseEntity.noContent().build();
    }
}
