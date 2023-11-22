package co.edu.usbcali.aerolinea.service.implementation;


import co.edu.usbcali.aerolinea.domain.Aeropuerto;
import co.edu.usbcali.aerolinea.domain.Escala;
import co.edu.usbcali.aerolinea.dto.AeropuertoDTO;
import co.edu.usbcali.aerolinea.mapper.AeropuertoMapper;
import co.edu.usbcali.aerolinea.repository.AeropuertoRepository;
import co.edu.usbcali.aerolinea.service.AeropuertoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AeropuertoServiceImpl implements AeropuertoService {

    private final AeropuertoRepository repository;
    private final AeropuertoMapper mapper;


    @Override
    public AeropuertoDTO save(AeropuertoDTO request) {
        Aeropuerto entity = mapper.toEntity(request);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public AeropuertoDTO update(AeropuertoDTO request) {
        return null;
    }

    @Override
    public AeropuertoDTO update(AeropuertoDtDTO request) {
        findById(request.getId());
        Aeropuerto entity = mapper.toEntity(request);
        entity.setId(request.getId());
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public AeropuertoDTO partialUpdate(AeropuertoDTO request) {
        Aeropuerto entity = findById(request.getId());
        entity = mapper.partialUpdate(entity, request);
        repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public void delete(int id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public AeropuertoDTO getById(Integer id) {
        return mapper.toDTO(findById(id));
    }

    @Override
    public List<AeropuertoDTO> getAll(Pageable pageable) {
        Page<Aeropuerto> pages = repository.findAll(pageable);
        return mapper.toDTO(pages.getContent());
    }

    private Aeropuerto findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro ningún aeropuerto"));
    }
}