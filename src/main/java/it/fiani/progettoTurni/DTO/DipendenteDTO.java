package it.fiani.progettoTurni.DTO;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class DipendenteDTO {

	public enum TipoMansione {
		BARELLIERE, INFERMIERE, MEDICO, AUTISTA
	}

	// ==================================================================================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String cognome;
	private TipoMansione mansione;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public TipoMansione getMansione() {
		return mansione;
	}

	public void setMansione(TipoMansione mansione) {
		this.mansione = mansione;
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
