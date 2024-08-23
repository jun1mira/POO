package Elementos;


public class Equipamento {
    private int id;
    private String nomeEquipamento;
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "id=" + id +
                ", nomeEquipamento='" + nomeEquipamento + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public int getIdEquipamento() {
        return id;
    }

    public void setIdEquipamento(int idEquipamento) {
    }
}