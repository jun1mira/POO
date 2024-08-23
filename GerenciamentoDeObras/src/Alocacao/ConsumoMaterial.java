package Alocacao;

public class ConsumoMaterial {
    private int idProjeto;
    private int idMaterial;

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Override
    public String toString() {
        return "ConsumoMaterial{" +
                "idProjeto=" + idProjeto +
                ", idMaterial=" + idMaterial +
                '}';
    }
}
