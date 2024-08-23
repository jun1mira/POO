package Alocacao;

public class AlocacaoEngenheiro {
    private int idProjeto;
    private int idEngenheiro;

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public int getIdEngenheiro() {
        return idEngenheiro;
    }

    public void setIdEngenheiro(int idEngenheiro) {
        this.idEngenheiro = idEngenheiro;
    }

    @Override
    public String toString() {
        return "AlocacaoEngenheiro{" +
                "idProjeto=" + idProjeto +
                ", idEngenheiro=" + idEngenheiro +
                '}';
    }
}