package DAO;

import Alocacao.ConsumoMaterial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ConsumoMaterialDAO {
    private Connection connection;

    public ConsumoMaterialDAO() {
        try {
            this.connection = ConexaoBD.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consumirMaterial(ConsumoMaterial consumoMaterial) {
        String sql = "INSERT INTO Consumo_Material (idProjeto, idMaterial) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, consumoMaterial.getIdProjeto());
            stmt.setInt(2, consumoMaterial.getIdMaterial());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ConsumoMaterial> listarPorProjeto(int idProjetoUtilizados) {
        return List.of();
    }
}
