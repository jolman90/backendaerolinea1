package co.edu.usbcali.aerolinea.service.implementation;

import co.edu.usbcali.aerolinea.domain.Escala;
import co.edu.usbcali.aerolinea.dto.EscalaDTO;
import co.edu.usbcali.aerolinea.dto.EscalaDTO;
import co.edu.usbcali.aerolinea.mapper.EscalaMapper;
import co.edu.usbcali.aerolinea.repository.EscalaRepository;
import co.edu.usbcali.aerolinea.service.EscalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EscalaServiceImpl implements EscalaService {

    private final EscalaRepository repository;
    private final EscalaMapper mapper;

    @Override
    public EscalaDTO save(EscalaDTO request) {
        Escala entity = mapper.toEntity(request);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public EscalaDto update(EscalaDto request) {
        findById(request.getId());
        Escala entity = mapper.toEntity(request);
        entity.setId(request.getId());
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public EscalaDTO partialUpdate(EscalaDTO request) {
        Escala entity = findById(request.getId());
        entity = mapper.partialUpdate(entity, request);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public EscalaDTO save(EscalaDTO request) {
        return null;
    }

    @Override
    public EscalaDTO update(EscalaDTO request) {
        return null;
    }

    @Override
    public EscalaDTO partialUpdate(EscalaDTO request) {
        return null;
    }

    @Override
    public void delete(int id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public EscalaDto getById(Integer id) {
        return mapper.toDto(findById(id));
    }

    @Override
    public List<EscalaDto> getAll(Pageable pageable) {
        Page<Escala> pages = repository.findAll(pageable);
        return mapper.toDto(pages.getContent());
    }

    private Escala findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro ningún registro"));
    }
}