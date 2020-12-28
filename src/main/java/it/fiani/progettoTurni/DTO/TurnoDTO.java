package it.fiani.progettoTurni.DTO;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class TurnoDTO {

	public enum TipoTurno {
		NOTTURNO, DIURNO
	}

	public enum TipoZona {
		ROMA, PROVINCIA
	}

	// ==================================================================================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private VeicoloDTO veicolo;
	private List<DipendenteDTO> dipendenti;
	private TipoTurno tipoTurno;
	private TipoZona tipoZona;
	private String postazione;
	private LocalTime istanteInizio;
	private LocalTime istanteFine;
	private LocalTime istanteFineEffettivo;

	@CreationTimestamp
	private OffsetDateTime instanteCreazione;
	@UpdateTimestamp
	private OffsetDateTime instanteUltimoAggiornamento;

	// ==================================================================================

}
