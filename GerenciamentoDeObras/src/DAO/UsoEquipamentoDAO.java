package DAO;

import Alocacao.UsoEquipamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsoEquipamentoDAO {
    private Connection connection;

    public UsoEquipamentoDAO() {
        try {
            this.connection = ConexaoBD.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void usarEquipamento(UsoEquipamento usarEquipamento) throws SQLException {
        String sql = "INSERT INTO Uso_Equipamento (idProjeto, idEquipamento) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, usarEquipamento.getIdProjeto());
            pstmt.setInt(2, usarEquipamento.getIdEquipamento());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UsoEquipamento> listarPorProjeto(int idProjeto) {
        List<UsoEquipamento> usos = new ArrayList<>();
        String sql = "SELECT idProjeto, idEquipamento FROM Uso_Equipamento WHERE idProjeto = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idProjeto);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    UsoEquipamento uso = new UsoEquipamento();
                    uso.setIdProjeto(rs.getInt("idProjeto"));
                    uso.setIdEquipamento(rs.getInt("idEquipamento"));
                    usos.add(uso);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usos;
    }

}
