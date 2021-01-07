package it.fiani.progettoTurni.entity;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Turno {

	private enum TipoTurno {
		NOTTURNO, DIURNO
	}

	private enum TipoZona {
		ROMA, PROVINCIA
	}

	// ==================================================================================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@NotNull
	private Veicolo veicolo;

	@OneToMany
	private List<Dipendente> dipendenti;

	private TipoTurno tipoTurno;
	private TipoZona tipoZona;

	@NotNull
	private String postazione;
	private OffsetDateTime istanteInizio;
	private OffsetDateTime istanteFine;
	private OffsetDateTime istanteFineEffettivo;

	@CreationTimestamp
	private OffsetDateTime instanteCreazione;
	@UpdateTimestamp
	private OffsetDateTime instanteUltimoAggiornamento;

	// ==================================================================================

}
