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

import it.fiani.progettoTurni.DTO.DipendenteDTO;
import it.fiani.progettoTurni.entity.Dipendente;
import it.fiani.progettoTurni.service.DipendenteService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/dipendenti")
@AllArgsConstructor
public class DipendenteController {

	private final DipendenteService dipendenteService;
	private final ModelMapper modelMapper;

	@GetMapping
	public List<DipendenteDTO> mostraLista() {
		return dipendenteService.mostraListaDipendenti().stream().map(dipendente -> toDTO(dipendente))
				.collect(Collectors.toList());

	}

	@PostMapping
	public DipendenteDTO salvaDipendente(@RequestBody DipendenteDTO dipendenteDTO) {
		Dipendente dipendente = dipendenteService.salvaDipendente(toEntity(dipendenteDTO));
		return toDTO(dipendente);
	}

	@GetMapping("/{idDipendente}")
	public DipendenteDTO mostraDipendente(@PathVariable Long idDipendente) {
		return toDTO(dipendenteService.mostraDipendente(idDipendente));
	}

	@PutMapping("/{idDipendente}")
	public DipendenteDTO modificaDipendente(@RequestBody DipendenteDTO dipendenteDTO) {
		if (dipendenteNonEsiste(dipendenteDTO)) {
			throw new IllegalArgumentException("Il dipendente non esiste");
		}
		Dipendente dipendente = dipendenteService.modificaDipendente(toEntity(dipendenteDTO));
		return toDTO(dipendente);
	}

	@DeleteMapping("/{idDipendente}")
	public void cancellaDipendente(@PathVariable Long idDipendente) {
		dipendenteService.cancellaDipendente(idDipendente);
	}

	public Dipendente toEntity(DipendenteDTO dipendenteDTO) {
		return modelMapper.map(dipendenteDTO, Dipendente.class);

	}

	public DipendenteDTO toDTO(Dipendente dipendente) {
		return modelMapper.map(dipendente, DipendenteDTO.class);
	}

	private boolean dipendenteNonEsiste(DipendenteDTO dipendenteDTO) {
		return dipendenteDTO.getId() == null;
	}
}
