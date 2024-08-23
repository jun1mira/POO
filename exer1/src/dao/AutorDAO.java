package dao;

import entity.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutorDAO extends BaseDAO{

    public void inserir(Autor p) {
        String sql = """
        insert into autor(nome, nacionalidade) values(?, ?);
        """;
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, p.getNome());
            pre.setString(2, p.getNacionalidade());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Autor p){
        String sql = """
        update autor set nome = ?, nacionalidade = ? where id_pessoa = ?;
        """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,p.getNome());
            pre.setString(2, p.getNacionalidade());
            pre.setInt(3,p.getId());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Autor p){
        String sql = """
            delete from autor where id_autor = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,p.getId());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Autor> obterTodos(){
        List<Autor> lista = new ArrayList<>();
        String sql = """
            select id_pessoa, nome, nacionalidade from pessoa
            order by nome asc;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Autor p = new Autor();
                // Selecionado um registro da consulta
                p.setId(rs.getInt("id_pessoa"));
                p.setNome(rs.getString("nome"));
                p.setNacionalidade(rs.getString("nacionalidade"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public Optional<Autor> obterPeloId(int id){
        String sql = """
            select id_pessoa, nome, nacionalidade from pessoa
            where id_pessoa = ?;
                """;

        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                Autor p = new Autor();
                p.setId(rs.getInt("id_pessoa"));
                p.setNome(rs.getString("nome"));
                p.setNacionalidade(rs.getString("nacionalidade"));
                return Optional.of(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

}