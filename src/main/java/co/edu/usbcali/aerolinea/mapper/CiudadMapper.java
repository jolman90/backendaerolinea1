package co.edu.usbcali.aerolinea.mapper;

import co.edu.usbcali.aerolinea.domain.Ciudad;
import co.edu.usbcali.aerolinea.dto.CiudadDTO;
import org.mapstruct.Mapper;

import java.util.List;

public class CiudadMapper {
    @Mapper
    public interface CiudadMapper extends EntityMapper<Ciudad, CiudadDTO> {

        public static CiudadDTO domainToDto(Ciudad ciudad) {
            return CiudadDTO
                    .builder()
                    .id(ciudad.getId())
                    .nombre(ciudad.getNombre())
                    .descripcion(ciudad.getDescripcion())
                    .latitud(ciudad.getLatitud())
                    .longitud(ciudad.getLongitud())
                    .idPais((ciudad.getPais() != null) ? ciudad.getPais().getId()
                            : null)
                    .build();
            default Ciudad fromId(Integer id) {
                if (id == null) return null;
                return Ciudad.builder().id(id).build();
            }

            public static Ciudad dtoToDomain(CiudadDTO ciudadDTO) {
                return Ciudad
                        .builder()
                        .id(ciudadDTO.getId())
                        .nombre(ciudadDTO.getNombre())
                        .descripcion(ciudadDTO.getDescripcion())
                        .latitud(ciudadDTO.getLatitud())
                        .longitud(ciudadDTO.getLongitud())
                        .build();
            }

            public static List<CiudadDTO> domainToDtoList(List<Ciudad> ciudades) {
                return ciudades.stream().map(CiudadMapper::domainToDto).toList();
            }

            public static List<Ciudad> dtoToDomainList(List<CiudadDTO> ciudadesDto) {
                return ciudadesDto.stream().map(CiudadMapper::dtoToDomain).toList();
            }

        }