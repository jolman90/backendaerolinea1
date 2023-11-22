package co.edu.usbcali.aerolinea.controller;

import co.edu.usbcali.aerolinea.dto.EscalaDTO;
import co.edu.usbcali.aerolinea.service.EscalaService;
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
@RequestMapping("/escala")
@RequiredArgsConstructor
public class EscalaController {

    private final EscalaService service;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid EscalaDTO request) {
        EscalaDTO dto = service.save(request);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        EscalaDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/all")
    public ResponseEntity<List<EscalaDTO>> getAll(Pageable page) {
        List<EscalaDTO> dto = service.getAll(page);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody @Valid EscalaDTO request) {
        EscalaDTO dto = service.update(request);
        return ResponseEntity.ok(dto);

    @PatchMapping
    public ResponseEntity<Object> partialUpdate(@RequestBody @Valid EscalaDTO request) {
        EscalaDTO Dto = service.partialUpdate(request);
        return ResponseEntity.ok(Dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}