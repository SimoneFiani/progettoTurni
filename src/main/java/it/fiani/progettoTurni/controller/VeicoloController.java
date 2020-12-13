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

import it.fiani.progettoTurni.DTO.VeicoloDTO;
import it.fiani.progettoTurni.entity.Veicolo;
import it.fiani.progettoTurni.service.VeicoloService;

@RestController
@RequestMapping("/veicolo")
public class VeicoloController {

	VeicoloService veicoloService;
	ModelMapper modelMapper;

	@Autowired
	public VeicoloController(VeicoloService veicoloService, ModelMapper modelMapper) {
		this.veicoloService = veicoloService;
		this.modelMapper = modelMapper;
	}

	@GetMapping
	public List<VeicoloDTO> mostraLista() {
		return veicoloService.mostraListaVeicoli().stream().map(veicolo -> convertiInDTO(veicolo))
				.collect(Collectors.toList());

	}

	@PostMapping
	public void salvaVeicolo(@RequestBody VeicoloDTO veicoloDTO) {
		veicoloService.salvaVeicolo(convertiInEntity(veicoloDTO));

	}

	@GetMapping("/{idVeicolo}")
	public VeicoloDTO dettaglioVeicolo(@PathVariable Long idVeicolo) {
		return convertiInDTO(veicoloService.dettagliVeicolo(idVeicolo));

	}

	@PutMapping("/{idVeicolo}")
	public void modificaVeicolo(@RequestBody VeicoloDTO veicoloDTO) {
		if (veicoloDTO.getId() == null) {
			throw new IllegalArgumentException("l'id del dipendente non può esserre null");
		}
		veicoloService.modificaVeicolo(convertiInEntity(veicoloDTO));

	}

	@DeleteMapping("/{idVeicolo}")
	public void cancellaVeicolo(@PathVariable Long idVeicolo) {

		veicoloService.cancellaVeicolo(idVeicolo);

	}

	public VeicoloDTO convertiInDTO(Veicolo veicolo) {
		return modelMapper.map(veicolo, VeicoloDTO.class);
	}

	public Veicolo convertiInEntity(VeicoloDTO veicoloDTO) {
		return modelMapper.map(veicoloDTO, Veicolo.class);

	}

}
