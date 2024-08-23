package DAO;

import Alocacao.AlocacaoOperario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlocacaoOperarioDAO {
    private Connection connection;

    public AlocacaoOperarioDAO() {
        try {
            this.connection = ConexaoBD.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alocarOperario(AlocacaoOperario alocarOperario) throws SQLException {
        String sql = "INSERT INTO Alocacao_Operario (idProjeto, idOperario) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, alocarOperario.getIdProjeto());
            pstmt.setInt(2, alocarOperario.getIdOperario());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void desalocarOperario(int idProjeto, int idOperario) throws SQLException {
        String sql = "DELETE FROM Alocacao_Operario WHERE idProjeto = ? AND idOperario = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idProjeto);
            pstmt.setInt(2, idOperario);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AlocacaoOperario> listarPorProjeto(int idProjeto) {
        List<AlocacaoOperario> alocacoes = new ArrayList<>();
        String sql = "SELECT * FROM Alocacao_Operario WHERE idProjeto = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idProjeto);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    AlocacaoOperario alocacao = new AlocacaoOperario();
                    alocacao.setIdProjeto(rs.getInt("idProjeto"));
                    alocacao.setIdOperario(rs.getInt("idOperario"));
                    alocacoes.add(alocacao);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alocacoes;
    }
}
