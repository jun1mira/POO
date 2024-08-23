package Alocacao;

public class AlocacaoOperario {
    private int idProjeto;
    private int idOperario;

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public int getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(int idOperario) {
        this.idOperario = idOperario;
    }

    @Override
    public String toString() {
        return "AlocacaoOperario{" +
                "idProjeto=" + idProjeto +
                ", idOperario=" + idOperario +
                '}';
    }
}