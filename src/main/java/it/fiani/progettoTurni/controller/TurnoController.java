package it.fiani.progettoTurni.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
		return turnoService.mostraListaTurni();
	}

	@PostMapping
	public TurnoDTO salvaTurno(@RequestBody TurnoDTO turnoDTO) {
		return null;
	}

	@PutMapping("/{idTurno")
	public Turno modificaTurno() {
		return null;
	}

	@DeleteMapping("/{idTurno}")
	public void cancellaTurno() {

	}

}
