package co.edu.usbcali.aerolinea.service;

import co.edu.usbcali.aerolinea.dto.AeropuertoDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AeropuertoService {

    AeropuertoDTO save(AeropuertoDTO request);
    AeropuertoDTO update(AeropuertoDTO request);
    AeropuertoDTO partialUpdate(AeropuertoDTO request);
    void delete(int id);
    AeropuertoDTO getById(Integer id);
    List<AeropuertoDTO> getAll(Pageable pageable);
}