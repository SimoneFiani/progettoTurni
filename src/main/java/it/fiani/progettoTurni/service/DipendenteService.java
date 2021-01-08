package it.fiani.progettoTurni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.fiani.progettoTurni.entity.Dipendente;
import it.fiani.progettoTurni.repository.DipendenteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DipendenteService {

	private final DipendenteRepository dipendenteRepository;

	public List<Dipendente> mostraListaDipendenti() {
		return (List<Dipendente>) dipendenteRepository.findAll();
	}

	public Dipendente salvaDipendente(Dipendente dipendente) {
		return dipendenteRepository.save(dipendente);
	}

	public Dipendente mostraDipendente(Long idDipendente) {
		return dipendenteRepository.findById(idDipendente).get();
	}

	public void cancellaDipendente(Long idDipendente) {
		dipendenteRepository.deleteById(idDipendente);
	}

	public Dipendente modificaDipendente(Dipendente dipendente) {
		return dipendenteRepository.save(dipendente);
	}

}
