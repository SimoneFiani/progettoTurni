package it.fiani.progettoTurni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fiani.progettoTurni.entity.Veicolo;
import it.fiani.progettoTurni.repository.VeicoloRepository;

@Service
public class VeicoloService {

	VeicoloRepository veicoloRepository;

	@Autowired
	public VeicoloService(VeicoloRepository veicoloRepository) {
		this.veicoloRepository = veicoloRepository;
	}

	public List<Veicolo> mostraListaVeicoli() {
		return (List<Veicolo>) veicoloRepository.findAll();

	}

	public void salvaVeicolo(Veicolo veicolo) {
		veicoloRepository.save(veicolo);

	}

	public Veicolo dettagliVeicolo(Long idVeicolo) {
		return veicoloRepository.findById(idVeicolo).get();
	}

	public void modificaVeicolo(Veicolo veicolo) {
		veicoloRepository.save(veicolo);

	}

	public void cancellaVeicolo(Long idVeicolo) {
		veicoloRepository.deleteById(idVeicolo);

	}

}
