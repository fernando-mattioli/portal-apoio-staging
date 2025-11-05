package net.ebserh.hctm.model.pesquisa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import net.ebserh.hctm.model.util.AbstractEntity;

@Entity
@Table(schema = "pesquisa", name = "estudos_clinicos")
public class EstudoClinico extends AbstractEntity {

    @Size(max = 300)
    private String titulo;

    @Size(max = 300)
    private String pesquisador;

    @Size(max = 2)
    private String status;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPesquisador() {
        return pesquisador;
    }

    public void setPesquisador(String pesquisador) {
        this.pesquisador = pesquisador;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
