package it.fiani.progettoTurni.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.fiani.progettoTurni.DTO.DipendenteDTO;
import it.fiani.progettoTurni.entity.Dipendente;
import it.fiani.progettoTurni.service.DipendenteService;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

	DipendenteService dipendenteService;
	ModelMapper modelMapper;

	@Autowired
	public DipendenteController(DipendenteService dipendenteService, ModelMapper modelMapper) {
		this.dipendenteService = dipendenteService;
		this.modelMapper = modelMapper;
	}

	@GetMapping
	public List<DipendenteDTO> mostraLista() {
		return dipendenteService.mostraListaDipendenti().stream().map(dipendente -> convertiADTO(dipendente))
				.collect(Collectors.toList());

	}

	@PostMapping
	public void salvaDipendente(@RequestBody DipendenteDTO dipendenteDTO) {
		dipendenteService.salvaDipendente(convertiAEntity(dipendenteDTO));
	}

	@GetMapping("/{idDipendente}")
	public DipendenteDTO mostraDipendente(@PathVariable Long idDipendente) {
		return convertiADTO(dipendenteService.prelevaDipendente(idDipendente));
	}

	@PutMapping("/{idDipendente}")
	public void modificaDipendente(@RequestBody DipendenteDTO dipendenteDTO) {
		if (dipendenteDTO.getId() == null) {
			throw new IllegalArgumentException("l'id del dipendente non puo essere null");
		}
		dipendenteService.modificaDipendente(convertiAEntity(dipendenteDTO));
	}

	@DeleteMapping("/{idDipendente}")
	public void cancellaDipendente(@PathVariable Long idDipendente) {
		dipendenteService.cancellaDipendente(idDipendente);
	}

	public Dipendente convertiAEntity(DipendenteDTO dipendenteDTO) {
		return modelMapper.map(dipendenteDTO, Dipendente.class);

	}

	public DipendenteDTO convertiADTO(Dipendente dipendente) {
		return modelMapper.map(dipendente, DipendenteDTO.class);
	}
}
