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

@Entity
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

	// FIX: Could not determine type for: it.fiani.progettoTurni.entity.Veicolo, at
	// table: turno, for columns: [org.hibernate.mapping.Column(veicolo)]
	@ManyToOne
	private Veicolo veicolo;

	@OneToMany
	private List<Dipendente> dipendenti;
	private TipoTurno tipoTurno;
	private TipoZona tipoZona;
	private String postazione;
	private OffsetDateTime istanteInizio;
	private OffsetDateTime istanteFine;
	private OffsetDateTime istanteFineEffettivo;

	@CreationTimestamp
	private OffsetDateTime instanteCreazione;
	@UpdateTimestamp
	private OffsetDateTime instanteUltimoAggiornamento;

	// ==================================================================================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Veicolo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}

	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}

	public TipoTurno getTipoTurno() {
		return tipoTurno;
	}

	public void setTipoTurno(TipoTurno tipoTurno) {
		this.tipoTurno = tipoTurno;
	}

	public TipoZona getTipoZona() {
		return tipoZona;
	}

	public void setTipoZona(TipoZona tipoZona) {
		this.tipoZona = tipoZona;
	}

	public String getPostazione() {
		return postazione;
	}

	public void setPostazione(String postazione) {
		this.postazione = postazione;
	}

	public OffsetDateTime getIstanteInizio() {
		return istanteInizio;
	}

	public void setIstanteInizio(OffsetDateTime istanteInizio) {
		this.istanteInizio = istanteInizio;
	}

	public OffsetDateTime getIstanteFine() {
		return istanteFine;
	}

	public void setIstanteFine(OffsetDateTime istanteFine) {
		this.istanteFine = istanteFine;
	}

	public OffsetDateTime getIstanteFineEffettivo() {
		return istanteFineEffettivo;
	}

	public void setIstanteFineEffettivo(OffsetDateTime istanteFineEffettivo) {
		this.istanteFineEffettivo = istanteFineEffettivo;
	}

	public OffsetDateTime getInstanteCreazione() {
		return instanteCreazione;
	}

	public void setInstanteCreazione(OffsetDateTime instanteCreazione) {
		this.instanteCreazione = instanteCreazione;
	}

	public OffsetDateTime getInstanteUltimoAggiornamento() {
		return instanteUltimoAggiornamento;
	}

	public void setInstanteUltimoAggiornamento(OffsetDateTime instanteUltimoAggiornamento) {
		this.instanteUltimoAggiornamento = instanteUltimoAggiornamento;
	}

}
