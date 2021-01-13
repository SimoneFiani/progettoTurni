package it.fiani.progettoTurni.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

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
	@NotNull
	@Size(min = 2, max = 3)
	private List<Dipendente> dipendenti = new ArrayList<>();
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoTurno tipoTurno;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoZona tipoZona;
	@NotNull
	private String postazione;
	@NotNull
	private OffsetDateTime istanteInizio;
	@NotNull
	private OffsetDateTime istanteFine;
	private OffsetDateTime istanteFineEffettivo;

	@CreationTimestamp
	private OffsetDateTime instanteCreazione;
	@UpdateTimestamp
	private OffsetDateTime instanteUltimoAggiornamento;

	// ==================================================================================

	public void aggiungiDipendente(Dipendente dipedente) {
		this.dipendenti.add(dipedente);
	}

}
