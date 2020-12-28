package it.fiani.progettoTurni.entity;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Veicolo {

	private enum TipoVeicolo {
		AM, MSB, MSA
	}
//	AM: Automedica, MSB: Ambulanza senza medico, MSA: Ambulanza con medico.

	// ==================================================================================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private TipoVeicolo tipoVeicolo;
	private String codice;
	private String targa;
	private String enteDiAppartenenza;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_VEICOLO")
	private List<NumeroDiTelefono> numeriDiTelefono;

	@CreationTimestamp
	private OffsetDateTime instanteCreazione;
	@UpdateTimestamp
	private OffsetDateTime instanteUltimoAggiornamento;

	// ==================================================================================

}
