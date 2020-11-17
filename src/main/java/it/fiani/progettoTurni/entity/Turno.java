package it.fiani.progettoTurni.entity;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Turno {

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

	private Veicolo veicolo;
	private List<Dipendente> dipendenti;
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

	public LocalTime getIstanteInizio() {
		return istanteInizio;
	}

	public void setIstanteInizio(LocalTime istanteInizio) {
		this.istanteInizio = istanteInizio;
	}

	public LocalTime getIstanteFine() {
		return istanteFine;
	}

	public void setIstanteFine(LocalTime istanteFine) {
		this.istanteFine = istanteFine;
	}

	public LocalTime getIstanteFineEffettivo() {
		return istanteFineEffettivo;
	}

	public void setIstanteFineEffettivo(LocalTime istanteFineEffettivo) {
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
