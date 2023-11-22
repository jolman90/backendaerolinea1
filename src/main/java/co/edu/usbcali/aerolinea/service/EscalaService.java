package co.edu.usbcali.aerolinea.service;

import co.edu.usbcali.aerolinea.dto.EscalaDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EscalaService {
    EscalaDTO save(EscalaDTO request);
    EscalaDTO update(EscalaDTO request);
    EscalaDTO partialUpdate(EscalaDTO request);
    void delete(int id);
    EscalaDTO getById(Integer id);

    List<EscalaDTO> getAll(Pageable pageable);
}