package it.fiani.progettoTurni.DTO;

import java.time.OffsetDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class NumeroDiTelefonoDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;

	@CreationTimestamp
	private OffsetDateTime instanteCreazione;
	@UpdateTimestamp
	private OffsetDateTime instanteUltimoAggiornamento;

	// ==================================================================================

}
