package dao;

import entity.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroDAO extends BaseDAO {

    public void inserir(Livro l) {
        String sql = """
        INSERT INTO livro(titulo, autor_id, ano_publicacao) VALUES(?, ?, ?);
        """;
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, l.getTitulo());
            pre.setInt(2, l.getAutorId());
            pre.setInt(3, l.getAnoPublicacao());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Livro l) {
        String sql = """
        UPDATE livro SET titulo = ?, autor_id = ?, ano_publicacao = ? WHERE id_livro = ?;
        """;
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, l.getTitulo());
            pre.setInt(2, l.getAutorId());
            pre.setInt(3, l.getAnoPublicacao());
            pre.setInt(4, l.getId());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(Livro l) {
        String sql = """
        DELETE FROM livro WHERE id_livro = ?;
        """;
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, l.getId());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> obterTodos() {
        List<Livro> lista = new ArrayList<>();
        String sql = """
        SELECT id_livro, titulo, autor_id, ano_publicacao FROM livro
        ORDER BY titulo ASC;
        """;
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql)) {
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Livro l = new Livro();
                l.setId(rs.getInt("id_livro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutorId(rs.getInt("autor_id"));
                l.setAnoPublicacao(rs.getInt("ano_publicacao"));
                lista.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Optional<Livro> obterPeloId(int id) {
        String sql = """
        SELECT id_livro, titulo, autor_id, ano_publicacao FROM livro
        WHERE id_livro = ?;
        """;
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Livro l = new Livro();
                l.setId(rs.getInt("id_livro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutorId(rs.getInt("autor_id"));
                l.setAnoPublicacao(rs.getInt("ano_publicacao"));
                return Optional.of(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}