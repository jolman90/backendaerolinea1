package co.edu.usbcali.aerolinea.mapper;

import co.edu.usbcali.aerolinea.domain.Asiento;
import co.edu.usbcali.aerolinea.dto.AsientoDTO;
import org.mapstruct.Mapper;

@Mapper
public interface AsientoMapperE extends EntityMapper<Asiento, AsientoDTO> {

    //@Mapping(source = "totalAsientos", target = "countAsientos")
    //Asiento toEntity(AsientoDTO dto);
}
