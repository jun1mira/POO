package Entidades;

public class Engenheiro {
    private int id;
    private String nomeEngenheiro;
    private String especialidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeEngenheiro() {
        return nomeEngenheiro;
    }

    public void setNomeEngenheiro(String nomeEngenheiro) {
        this.nomeEngenheiro = nomeEngenheiro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Engenheiro{" +
                "id=" + id +
                ", nomeEngenheiro='" + nomeEngenheiro + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }

}
