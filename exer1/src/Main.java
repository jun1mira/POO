import dao.AutorDAO;
import dao.LivroDAO;
import entity.Autor;
import entity.Livro;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        AutorDAO autorDAO = new AutorDAO();
        LivroDAO livroDAO = new LivroDAO();

        Autor autor = new Autor();
        autor.setNome("Michael Bibi");
        autor.setNacionalidade("Russo");

        autorDAO.inserir(autor);

        Optional<Autor> optAutor = autorDAO.obterPeloId(1); // Substitua pelo ID correto
        if (optAutor.isPresent()) {
            Autor retrievedAutor = optAutor.get();
            System.out.println("Autor encontrado:");
            System.out.println("ID: " + retrievedAutor.getId());
            System.out.println("Nome: " + retrievedAutor.getNome());
            System.out.println("Nacionalidade: " + retrievedAutor.getNacionalidade());
        } else {
            System.out.println("Autor não encontrado.");
        }

        Livro livro = new Livro();
        livro.setTitulo("Broke");
        livro.setAutorId(2);
        livro.setAnoPublicacao(2002);

        livroDAO.inserir(livro);

        Optional<Livro> optLivro = livroDAO.obterPeloId(1);
        if (optLivro.isPresent()) {
            Livro retrievedLivro = optLivro.get();
            System.out.println("Livro encontrado:");
            System.out.println("ID: " + retrievedLivro.getId());
            System.out.println("Título: " + retrievedLivro.getTitulo());
            System.out.println("Autor ID: " + retrievedLivro.getAutorId());
            System.out.println("Ano de Publicação: " + retrievedLivro.getAnoPublicacao());
        } else {
            System.out.println("Livro não encontrado.");
        }

        System.out.println("Lista de todos os livros:");
        List<Livro> livros = livroDAO.obterTodos();
        for (Livro l : livros) {
            System.out.println("ID: " + l.getId() + ", Título: " + l.getTitulo() + ", Autor ID: " + l.getAutorId() + ", Ano: " + l.getAnoPublicacao());
        }

        livroDAO.deletar(livro);
    }
}