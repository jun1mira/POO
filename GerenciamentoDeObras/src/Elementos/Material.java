package Elementos;


public class Material {
    private int id;
    private String nomeMaterial;
    private int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeMaterial() {
        return nomeMaterial;
    }

    public void setNomeMaterial(String nomeMaterial) {
        this.nomeMaterial = nomeMaterial;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", nomeMaterial='" + nomeMaterial + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }

    public int getIdMaterial() {
        return 0;
    }
}