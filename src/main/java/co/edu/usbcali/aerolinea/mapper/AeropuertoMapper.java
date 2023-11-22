package co.edu.usbcali.aerolinea.mapper;

import co.edu.usbcali.aerolinea.domain.Aeropuerto;
import co.edu.usbcali.aerolinea.dto.AeropuertoDTO;
import co.edu.usbcali.aerolinea.dto.AeropuertoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {CiudadMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AeropuertoMapper extends EntityMapper<Aeropuerto, AeropuertoDTO> {

    @Mapping(target = "ciudad", source = "ciudadId")
    Aeropuerto toEntity(AeropuertoDTO dto);

    @Mapping(target = "ciudadId", source = "ciudad.id")
    @Mapping(target = "ciudadNombre", source = "ciudad.nombre")
    AeropuertoDTO toDto(Aeropuerto entity);

    default Aeropuerto fromId(Integer id) {
        if (id == null) return null;
        return Aeropuerto.builder().id(id).build();
    }

    Aeropuerto toEntity(AeropuertoDTO request);
}