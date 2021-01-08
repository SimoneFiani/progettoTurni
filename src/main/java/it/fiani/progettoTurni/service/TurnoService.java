package it.fiani.progettoTurni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.fiani.progettoTurni.entity.Turno;
import it.fiani.progettoTurni.repository.TurnoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TurnoService {

	private final TurnoRepository turnoRepository;

	public List<Turno> mostraListaTurni() {
		return (List<Turno>) turnoRepository.findAll();
	}

	public Turno aggiungiTurno(Turno turno) {
		return turnoRepository.save(turno);
	}

	public Turno modificaTurno(Long idTurno) {
		return turnoRepository.findById(idTurno).orElseThrow(() -> new NullPointerException("il turno non esiste"));
	}

	public void cancellaTurno(Long idTurno) {
		turnoRepository.deleteById(idTurno);

	}

}
