package DAO;

import Alocacao.AlocacaoEngenheiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AlocacaoEngenheiroDAO {
    private Connection connection;

    public AlocacaoEngenheiroDAO() {
        try {
            this.connection = ConexaoBD.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alocarEngenheiro(AlocacaoEngenheiro alocacaoEngenheiro) {
        String sql = "INSERT INTO Alocacao_Engenheiro (idProjeto, idEngenheiro) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, alocacaoEngenheiro.getIdProjeto());
            stmt.setInt(2, alocacaoEngenheiro.getIdEngenheiro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AlocacaoEngenheiro> listarPorProjeto(int idProjetoAlocados) {
        return List.of();
    }
}
