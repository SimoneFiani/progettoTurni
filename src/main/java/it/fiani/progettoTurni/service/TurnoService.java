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
		if (veicoloNonImpegnatoInAltroTurno(turno) || personaleNonImpegnatoInAltroTurno(turno)) {
			return turnoRepository.save(turno);
		} else {
			throw new IllegalArgumentException("il veicolo o il personale, è impegnato in un'altro turno");
		}

	}

	public Turno dettaglioTurno(Long idTurno) {
		return turnoRepository.findById(idTurno).orElseThrow(() -> new NullPointerException("il turno non esiste"));
	}

	public Turno modificaTurno(Turno turno) {
		return turnoRepository.save(turno);
	}

	public void cancellaTurno(Long idTurno) {
		turnoRepository.deleteById(idTurno);
	}

	public boolean veicoloNonImpegnatoInAltroTurno(Turno turno) {
		// TODO: ottimizzare il findAll (query sul repository)
//
//		List<Turno> listaTurniDelDB = (List<Turno>) turnoRepository.findAll();
//		for (Turno t : listaTurniDelDB) {
//			if (t.getVeicolo().getId().equals(turno.getVeicolo().getId())
//					&& t.getIstanteInizio().equals(turno.getIstanteInizio())) {
//				return false;
//			}
//		}
		return false;
	}

	public boolean personaleNonImpegnatoInAltroTurno(Turno turno) {
//
//		List<Dipendente> dipendentiDelTurnoCheMiStannoPassando = turno.getDipendenti();
//		List<Turno> listaTurniNelDB = (List<Turno>) turnoRepository.findAll();
//
//		for (Turno t : listaTurniNelDB) {
//			for (Dipendente d : t.getDipendenti()) {
//				for (Dipendente D : dipendentiDelTurnoCheMiStannoPassando) {
//					if (d.equals(D)) {
//						return false;
//					}
//					;
//
//				}
//			}
//		}
//
		return false;
	}

}
