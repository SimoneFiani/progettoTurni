package it.fiani.progettoTurni.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
public class NumeroDiTelefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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