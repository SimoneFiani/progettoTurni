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
import it.fiani.progettoTurni.service.TurnoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/turni")
@AllArgsConstructor
public class TurnoController {

	private final ModelMapper modelMapper;
	private final TurnoService turnoService;

	@GetMapping
	public List<TurnoDTO> listaTurni() {
		return turnoService.mostraListaTurni().stream().map(t -> toDTO(t)).collect(Collectors.toList());
	}

	@PostMapping
	public TurnoDTO aggiungiTurno(@RequestBody TurnoDTO turnoDTO) {
		Turno turno = turnoService.aggiungiTurno(toEntity(turnoDTO));
		return toDTO(turno);
	}

	@PutMapping("/{idTurno")
	public TurnoDTO modificaTurno(@PathVariable Long idTurno) {
		Turno turno = turnoService.modificaTurno(idTurno);
		return toDTO(turno);
	}

	@DeleteMapping("/{idTurno}")
	public void cancellaTurno(@PathVariable Long idTurno) {
		turnoService.cancellaTurno(idTurno);
	}

	private TurnoDTO toDTO(Turno turno) {
		return modelMapper.map(turno, TurnoDTO.class);
	}

	private Turno toEntity(TurnoDTO turnoDTO) {
		return modelMapper.map(turnoDTO, Turno.class);
	}
}
