package Alocacao;

public class UsoEquipamento {
    private int idProjeto;
    private int idEquipamento;

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    @Override
    public String toString() {
        return "UsoEquipamento{" +
                "idProjeto=" + idProjeto +
                ", idEquipamento=" + idEquipamento +
                '}';
    }
}
