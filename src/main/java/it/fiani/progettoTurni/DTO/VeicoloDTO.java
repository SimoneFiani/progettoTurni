package it.fiani.progettoTurni.DTO;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class VeicoloDTO {

	public enum TipoVeicolo {
		AM, MSB, MSA
	}
//	AM: Automedica, MSB: Ambulanza senza medico, MSA: Ambulanza con medico.

	// ==================================================================================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codice;
	private String targa;
	private String enteDiAppartenenza;
	private List<NumeroDiTelefonoDTO> numeriDiTelefono;

	@CreationTimestamp
	private OffsetDateTime instanteCreazione;
	@UpdateTimestamp
	private OffsetDateTime instanteUltimoAggiornamento;

	// ==================================================================================

}
