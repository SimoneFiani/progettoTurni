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

import it.fiani.progettoTurni.DTO.NumeroDiTelefonoDTO;
import it.fiani.progettoTurni.DTO.VeicoloDTO;
import it.fiani.progettoTurni.entity.NumeroDiTelefono;
import it.fiani.progettoTurni.entity.Veicolo;
import it.fiani.progettoTurni.service.VeicoloService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/veicoli")
@AllArgsConstructor
public class VeicoloController {

	private final VeicoloService veicoloService;
	private final ModelMapper modelMapper;

//============================================================================================================

	@GetMapping
	public List<VeicoloDTO> mostraLista() {
		return veicoloService.mostraListaVeicoli().stream().map(veicolo -> toDTO(veicolo)).collect(Collectors.toList());
	}

	@PostMapping
	public VeicoloDTO salvaVeicolo(@RequestBody VeicoloDTO veicoloDTO) {
		return toDTO(veicoloService.salvaVeicolo(toEntity(veicoloDTO)));
	}

	@GetMapping("/{idVeicolo}")
	public VeicoloDTO dettaglioVeicolo(@PathVariable Long idVeicolo) {
		return toDTO(veicoloService.mostraVeicolo(idVeicolo));

	}

	@PutMapping("/{idVeicolo}")
	public VeicoloDTO modificaVeicolo(@RequestBody VeicoloDTO veicoloDTO) {
		return toDTO(veicoloService.modificaVeicolo(toEntity(veicoloDTO)));
	}

	@DeleteMapping("/{idVeicolo}")
	public void cancellaVeicolo(@PathVariable Long idVeicolo) {
		veicoloService.cancellaVeicolo(idVeicolo);

	}

//============================================================================================================

	@PostMapping("/{idVeicolo}/numeriDiTelefono")
	public void aggiungiNumeroDiTelefono(@PathVariable Long idVeicolo,
			@RequestBody NumeroDiTelefonoDTO numeroDiTelefonoDTO) {
		Veicolo veicolo = veicoloService.mostraVeicolo(idVeicolo);
		veicolo.aggiungiNumeroDiTelfono(numeroDiTelefonoDTOToEntity(numeroDiTelefonoDTO));
		veicoloService.modificaVeicolo(veicolo);
	}

	// TODO: implemetare la modifica e la cancellazione del numero di telefono

//============================================================================================================

	public VeicoloDTO toDTO(Veicolo veicolo) {
		return modelMapper.map(veicolo, VeicoloDTO.class);
	}

	public Veicolo toEntity(VeicoloDTO veicoloDTO) {
		return modelMapper.map(veicoloDTO, Veicolo.class);
	}

	private NumeroDiTelefonoDTO numeroDiTelefonoToDTO(NumeroDiTelefono numeroDiTelefono) {
		return modelMapper.map(numeroDiTelefono, NumeroDiTelefonoDTO.class);
	}

	private NumeroDiTelefono numeroDiTelefonoDTOToEntity(NumeroDiTelefonoDTO numeroDiTelefonoDTO) {
		return modelMapper.map(numeroDiTelefonoDTO, NumeroDiTelefono.class);
	}

}
