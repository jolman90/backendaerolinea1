package co.edu.usbcali.aerolinea.service.implementation;
import co.edu.usbcali.aerolinea.domain.Avion;
import co.edu.usbcali.aerolinea.dto.AvionDTO;
import co.edu.usbcali.aerolinea.mapper.AvionMapper;
import co.edu.usbcali.aerolinea.repository.AvionRepository;
import org.springframework.stereotype.Service;
@Service
public class AvionServiceImpl implements AvionService {

    private final AvionRepository avionRepository;
    private final AvionMapper mapper;

    public AvionServiceImpl(AvionRepository avionRepository) {
    public AvionServiceImpl(AvionRepository avionRepository, AvionMapper mapper) {
            this.avionRepository = avionRepository;
            this.mapper = mapper;
        }

        @Override
        @@ -38,8 +40,8 @@ public AvionDTO guardarNuevoAvion(AvionDTO avionDTO) throws Exception {
            throw new Exception("La capacidad del avión es incorrecta, debe ser mayor a cero");
        }

        Avion avion = AvionMapper.dtoToDomain(avionDTO);
        return AvionMapper.domainToDto(avionRepository.save(avion));
        Avion avion = mapper.toEntity(avionDTO);
        return mapper.toDto(avionRepository.save(avion));
    }

    @Override

