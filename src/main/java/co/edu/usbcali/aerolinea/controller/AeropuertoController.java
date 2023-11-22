package co.edu.usbcali.aerolinea.controller;

import co.edu.usbcali.aerolinea.dto.AeropuertoDTO;
import co.edu.usbcali.aerolinea.service.AeropuertoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aeropuerto")
@RequiredArgsConstructor
public class AeropuertoController {

    private final AeropuertoService service;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AeropuertoDTO request) {
        AeropuertoDTO dto = service.save(request);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AeropuertoDTO> getById(@PathVariable Integer id) {
        AeropuertoDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/all")
    public ResponseEntity<List<AeropuertoDTO>> getAll(Pageable page) {
        List<AeropuertoDTO> dto = service.getAll(page);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<AeropuertoDTO> update(@RequestBody @Valid AeropuertoDTO request) {
        AeropuertoDTO dto = service.update(request);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping
    public ResponseEntity<AeropuertoDTO> partialUpdate(@RequestBody @Valid AeropuertoDTO request) {
        AeropuertoDTO dto = service.partialUpdate(request);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}