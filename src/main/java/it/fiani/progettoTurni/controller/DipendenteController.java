package it.fiani.progettoTurni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.fiani.progettoTurni.entity.Dipendente;
import it.fiani.progettoTurni.service.DipendenteService;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

	DipendenteService dipendenteService;

	@Autowired
	public DipendenteController(DipendenteService dipendenteService) {

	}

	@GetMapping
	public List<Dipendente> mostraLista() {
		return dipendenteService.mostraListaDipendenti();

	}

	@PostMapping
	public Dipendente salvaDipendente() {
		return null;
	}

	@PutMapping("/{idUtente}")
	public Dipendente aggiornaDipendente() {
		return null;
	}

	@DeleteMapping("/{idUtente}")
	public Dipendente cancellaDipendente() {
		return null;
	}

}
