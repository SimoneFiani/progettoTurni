package it.fiani.progettoTurni.DTO;

import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class DipendenteDTO {

	public enum TipoMansione {
		BARELLIERE, INFERMIERE, MEDICO, AUTISTA
	}

	// ==================================================================================

	private Long id;
	private String nome;
	private String cognome;
	private TipoMansione mansione;

	@CreationTimestamp
	private OffsetDateTime instanteCreazione;
	@UpdateTimestamp
	private OffsetDateTime instanteUltimoAggiornamento;

	// ==================================================================================

}
