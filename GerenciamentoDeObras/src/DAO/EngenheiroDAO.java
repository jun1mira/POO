package DAO;

import Entidades.Engenheiro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EngenheiroDAO {
    private Connection connection;

    public EngenheiroDAO() {
        try {
            this.connection = ConexaoBD.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Engenheiro engenheiro) {
        String sql = "INSERT INTO Engenheiro (nomeEngenheiro, especialidade) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, engenheiro.getNomeEngenheiro());
            stmt.setString(2, engenheiro.getEspecialidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Engenheiro> listar() {
        List<Engenheiro> engenheiros = new ArrayList<>();
        String sql = "SELECT * FROM Engenheiro";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Engenheiro engenheiro = new Engenheiro();
                engenheiro.setId(rs.getInt("id"));
                engenheiro.setNomeEngenheiro(rs.getString("nomeEngenheiro"));
                engenheiro.setEspecialidade(rs.getString("especialidade"));
                engenheiros.add(engenheiro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return engenheiros;
    }

    public void atualizar(Engenheiro engenheiro) {
        String sql = "UPDATE Engenheiro SET nomeEngenheiro = ?, especialidade = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, engenheiro.getNomeEngenheiro());
            stmt.setString(2, engenheiro.getEspecialidade());
            stmt.setInt(3, engenheiro.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Engenheiro WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
