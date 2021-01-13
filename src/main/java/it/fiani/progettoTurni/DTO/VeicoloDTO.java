package it.fiani.progettoTurni.DTO;

import java.time.OffsetDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import it.fiani.progettoTurni.entity.NumeroDiTelefono;
import lombok.Data;

@Data
public class VeicoloDTO {

	public enum TipoVeicolo {
		AM, MSB, MSA
	}
//	AM: Automedica, MSB: Ambulanza senza medico, MSA: Ambulanza con medico.

	// ==================================================================================

	private Long id;

	private TipoVeicolo tipoVeicolo;
	private String codice;
	private String targa;
	private String enteDiAppartenenza;
	private List<NumeroDiTelefono> numeriDiTelefono;

	@CreationTimestamp
	private OffsetDateTime instanteCreazione;
	@UpdateTimestamp
	private OffsetDateTime instanteUltimoAggiornamento;

	// ==================================================================================

}
