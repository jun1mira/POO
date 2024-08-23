package DAO;

import Entidades.Operario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperarioDAO {
    private Connection connection;

    public OperarioDAO() throws SQLException {
        this.connection = ConexaoBD.getInstance().getConnection();
    }

    public void inserir(Operario operario) {
        String sql = "INSERT INTO Operario (nomeOperario, funcao) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, operario.getNomeOperario());
            stmt.setString(2, operario.getFuncao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Operario> listar() {
        List<Operario> operarios = new ArrayList<>();
        String sql = "SELECT * FROM Operario";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Operario operario = new Operario();
                operario.setId(rs.getInt("id"));
                operario.setNomeOperario(rs.getString("nomeOperario"));
                operario.setFuncao(rs.getString("funcao"));
                operarios.add(operario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operarios;
    }

    public void atualizar(Operario operario) {
        String sql = "UPDATE Operario SET nomeOperario = ?, funcao = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, operario.getNomeOperario());
            stmt.setString(2, operario.getFuncao());
            stmt.setInt(3, operario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Operario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
