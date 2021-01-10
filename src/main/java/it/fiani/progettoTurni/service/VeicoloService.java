package it.fiani.progettoTurni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.fiani.progettoTurni.entity.Veicolo;
import it.fiani.progettoTurni.repository.VeicoloRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VeicoloService {

	VeicoloRepository veicoloRepository;

	public List<Veicolo> mostraListaVeicoli() {
		return (List<Veicolo>) veicoloRepository.findAll();
	}

	public Veicolo salvaVeicolo(Veicolo veicolo) {
		return veicoloRepository.save(veicolo);
	}

	public Veicolo mostraVeicolo(Long idVeicolo) {
		return veicoloRepository.findById(idVeicolo)
				.orElseThrow(() -> new NullPointerException("il veicolo non esiste"));
	}

	public Veicolo modificaVeicolo(Veicolo veicolo) {
		if (veicoloNonEsiste(veicolo)) {
			throw new NullPointerException("il veicolo non esiste");
		}
		return veicoloRepository.save(veicolo);
	}

	public void cancellaVeicolo(Long idVeicolo) {
		veicoloRepository.deleteById(idVeicolo);
	}

	private boolean veicoloNonEsiste(Veicolo veicolo) {
		return veicolo.getId() == null;
	}

}
