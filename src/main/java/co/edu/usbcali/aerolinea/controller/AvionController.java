package co.edu.usbcali.aerolinea.controller;
import co.edu.usbcali.aerolinea.dto.AvionDTO;
import co.edu.usbcali.aerolinea.mapper.AvionMapper;
import co.edu.usbcali.aerolinea.repository.AvionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/avion")
public class AvionController {

    private final AvionService avionService;
    private final AvionRepository avionRepository;
    private final AvionMapper mapper;

    public AvionController(AvionService avionService, AvionRepository avionRepository) {
    public AvionController(AvionService avionService, AvionRepository avionRepository, AvionMapper mapper) {
            this.avionService = avionService;
            this.avionRepository = avionRepository;
            this.mapper = mapper;
        }

        @GetMapping(value = "/validarController")
        @@ -29,7 +31,7 @@ public String validarController()

            @GetMapping("/obtenerAviones")
            public List<AvionDTO> obtenerAviones() {
                return AvionMapper.domainToDTOList(avionRepository.findAll());
                return mapper.toDTO(avionRepository.findAll());
            }

            @PostMapping("/guardarNuevoAvion")