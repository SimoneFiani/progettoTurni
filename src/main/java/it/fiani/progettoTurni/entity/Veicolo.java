package it.fiani.progettoTurni.entity;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Veicolo {

//	private enum TipoVeicolo {
//		AM, MSB, MSA
//	}
//	AM: Automedica, MSB: Ambulanza senza medico, MSA: Ambulanza con medico.

	// ==================================================================================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	private TipoVeicolo tipoVeicolo;
	private String codice;
	private String targa;
	private String entiDiAppartenenza;
	@OneToMany
	private List<NumeroDiTelefono> numeroTelefono;

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

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getEntiDiAppartenenza() {
		return entiDiAppartenenza;
	}

	public void setEntiDiAppartenenza(String entiDiAppartenenza) {
		this.entiDiAppartenenza = entiDiAppartenenza;
	}

	public List<NumeroDiTelefono> getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(List<NumeroDiTelefono> numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
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

//	public TipoVeicolo getTipoVeicolo() {
//		return tipoVeicolo;
//	}
//
//	public void setTipoVeicolo(TipoVeicolo tipoVeicolo) {
//		this.tipoVeicolo = tipoVeicolo;
//	}

}
