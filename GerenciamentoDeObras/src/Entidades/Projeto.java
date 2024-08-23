package Entidades;

public class Projeto {
    private int id;
    private String nomeProjeto;
    private String local;
    private String dataInicio;
    private String dataTermino;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    @Override
    public String toString() {
        return "Entidades.Projeto{" +
                "id=" + id +
                ", nomeProjeto='" + nomeProjeto + '\'' +
                ", local='" + local + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataTermino='" + dataTermino + '\'' +
                '}';
    }

    public int getIdProjeto() {
        return id;
    }
}