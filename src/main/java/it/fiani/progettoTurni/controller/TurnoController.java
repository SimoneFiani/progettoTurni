package it.fiani.progettoTurni.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.fiani.progettoTurni.DTO.TurnoDTO;
import it.fiani.progettoTurni.entity.Turno;
import it.fiani.progettoTurni.service.DipendenteService;
import it.fiani.progettoTurni.service.TurnoService;
import it.fiani.progettoTurni.service.VeicoloService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/turni")
@AllArgsConstructor
public class TurnoController {

	private final ModelMapper modelMapper;
	private final TurnoService turnoService;
	private final VeicoloService veicoloService;
	private final DipendenteService dipendenteService;

//============================================================================================================	

	@GetMapping
	public List<TurnoDTO> listaTurni() {
		return turnoService.mostraListaTurni().stream().map(t -> toDTO(t)).collect(Collectors.toList());
	}

	@PostMapping
	public TurnoDTO aggiungiTurno(@RequestBody TurnoDTO turnoDTO) {
		return toDTO(turnoService.aggiungiTurno(toEntity(turnoDTO)));
	}

	@GetMapping("/{idTurno}")
	public TurnoDTO dettaglioTurno(@PathVariable Long idTurno) {
		return toDTO(turnoService.dettaglioTurno(idTurno));
	}

	@PutMapping("/{idTurno}")
	public TurnoDTO modificaTurno(@RequestBody TurnoDTO turnoDTO) {
		return toDTO(turnoService.modificaTurno(toEntity(turnoDTO)));
	}

	@DeleteMapping("/{idTurno}")
	public void cancellaTurno(@PathVariable Long idTurno) {
		turnoService.cancellaTurno(idTurno);
	}

//============================================================================================================	

	private TurnoDTO toDTO(Turno turno) {
		return modelMapper.map(turno, TurnoDTO.class);
	}

	private Turno toEntity(TurnoDTO turnoDTO) {
		Turno turno = modelMapper.map(turnoDTO, Turno.class);

		turno.setVeicolo(veicoloService.mostraVeicolo(turnoDTO.getIdVeicolo()));
		for (Long idDipendente : turnoDTO.getIdDipendenti()) {
			turno.aggiungiDipendente(dipendenteService.mostraDipendente(idDipendente));
		}
//		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//		turno.setIstanteInizio(OffsetDateTime.parse(turnoDTO.getIstanteInizio(), formatoData));
//		turno.setIstanteFine(OffsetDateTime.parse(turnoDTO.getIstanteFine(), formatoData));
//		turno.setIstanteFineEffettivo(OffsetDateTime.parse(turnoDTO.getIstanteFineEffettivo(), formatoData));

		return turno;
	}
}
