package it.fiani.progettoTurni.DTO;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.istack.NotNull;

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

	private Long id;
	@NotNull
	private VeicoloDTO veicolo;
	@NotNull
	@Size(min = 2, max = 3)
	private List<DipendenteDTO> dipendenti;
	@NotNull
	private TipoTurno tipoTurno;
	@NotNull
	private TipoZona tipoZona;
	@NotNull
	private String postazione;
	@NotNull
	private LocalTime istanteInizio;
	@NotNull
	private LocalTime istanteFine;
	private LocalTime istanteFineEffettivo;

	@CreationTimestamp
	private OffsetDateTime instanteCreazione;
	@UpdateTimestamp
	private OffsetDateTime instanteUltimoAggiornamento;

	// ==================================================================================

}
