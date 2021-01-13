package it.fiani.progettoTurni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.fiani.progettoTurni.entity.Dipendente;
import it.fiani.progettoTurni.entity.Turno;
import it.fiani.progettoTurni.repository.TurnoRepository;
import it.fiani.progettoTurni.utility.DataUtility;
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
		if (veicoloNonImpegnatoInAltroTurno(turno) || personaleNonImpegnatoInAltroTurno(turno)) {
			return turnoRepository.save(turno);
		} else {
			throw new IllegalArgumentException("il veicolo o il personale modificato, è impegnato in un'altro turno");
		}

	}

	public void cancellaTurno(Long idTurno) {
		turnoRepository.deleteById(idTurno);

	}

	public boolean veicoloNonImpegnatoInAltroTurno(Turno turnoA) {

		List<Turno> listaTurniDelDB = (List<Turno>) turnoRepository.findAll();
		for (Turno turnoB : listaTurniDelDB) {
			if (turnoB.getVeicolo().getId().equals(turnoA.getVeicolo().getId())
					&& DataUtility.iPeriodiSiSovrappongono(turnoA.getIstanteInizio(), turnoA.getIstanteFine(),
							turnoB.getIstanteInizio(), turnoB.getIstanteFine())) {
				return false;
			}
		}

		return true;
	}

	public boolean personaleNonImpegnatoInAltroTurno(Turno turnoA) {

		List<Dipendente> dipendentiDelTurnoCheMiStannoPassando = turnoA.getDipendenti();
		List<Turno> listaTurniNelDB = (List<Turno>) turnoRepository.findAll();

		for (Turno turnoB : listaTurniNelDB) {

			if (DataUtility.iPeriodiSiSovrappongono(turnoA.getIstanteInizio(), turnoA.getIstanteFine(),
					turnoB.getIstanteInizio(), turnoB.getIstanteFine())) {

				for (Dipendente dipendenteB : turnoB.getDipendenti()) {
					for (Dipendente dipendenteA : dipendentiDelTurnoCheMiStannoPassando) {
						if (dipendenteB.getId().equals(dipendenteA.getId())) {
							return false;
						}
					}
				}
			} else {
				return false;
			}
		}
		return false;

	}

}
