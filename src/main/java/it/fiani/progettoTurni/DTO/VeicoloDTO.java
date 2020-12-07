package it.fiani.progettoTurni.DTO;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

// FIX: Could not determine type for: it.fiani.progettoTurni.DTO.NumeroTelefonoDTO, at table: veicolodto, for columns: [org.hibernate.mapping.Column(numero_telefono)]
// QUesto è un DTO, non un entity!!!
public class VeicoloDTO {

	public enum TipoVeicolo {
		AM, MSB, MSA
	}
//	AM: Automedica, MSB: Ambulanza senza medico, MSA: Ambulanza con medico.

	// ==================================================================================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codice;
	private String targa;
	private String entiDiAppartenenza;
	private NumeroDiTelefonoDTO numeroTelefono;

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

	public NumeroDiTelefonoDTO getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(NumeroDiTelefonoDTO numeroTelefono) {
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

}
