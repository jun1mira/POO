package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {

    public static void setupTables() {
        try (Connection connection = ConexaoBD.getInstance().getConnection();
             Statement stmt = connection.createStatement()) {

            // Tabela Projeto
            String createTableProjeto = """
                CREATE TABLE IF NOT EXISTS Projeto (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nomeProjeto TEXT NOT NULL,
                    local TEXT NOT NULL,
                    dataInicio TEXT,
                    dataTermino TEXT
                );
            """;

            // Tabela Engenheiro
            String createTableEngenheiro = """
                CREATE TABLE IF NOT EXISTS Engenheiro (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nomeEngenheiro TEXT NOT NULL,
                    especialidade TEXT NOT NULL
                );
            """;

            // Tabela Operario
            String createTableOperario = """
                CREATE TABLE IF NOT EXISTS Operario (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nomeOperario TEXT NOT NULL,
                    funcao TEXT NOT NULL
                );
            """;

            // Tabela Equipamento
            String createTableEquipamento = """
                CREATE TABLE IF NOT EXISTS Equipamento (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nomeEquipamento TEXT NOT NULL,
                    tipo TEXT NOT NULL
                );
            """;

            // Tabela Material
            String createTableMaterial = """
                CREATE TABLE IF NOT EXISTS Material (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nomeMaterial TEXT NOT NULL,
                    quantidade INTEGER NOT NULL
                );
            """;

            // Tabela Associativa Alocacao_Engenheiro
            String createTableAlocacaoEngenheiro = """
                CREATE TABLE IF NOT EXISTS Alocacao_Engenheiro (
            
                    idProjeto INTEGER,
                    idEngenheiro INTEGER,
                    PRIMARY KEY (idProjeto, idEngenheiro),
                    FOREIGN KEY (idProjeto) REFERENCES Projeto(id),
                    FOREIGN KEY (idEngenheiro) REFERENCES Engenheiro(id)
                );
            """;

            // Tabela Associativa Alocacao_Operario
            String createTableAlocacaoOperario = """
                CREATE TABLE IF NOT EXISTS Alocacao_Operario (
                    idProjeto INTEGER,
                    idOperario INTEGER,
                    PRIMARY KEY (idProjeto, idOperario),
                    FOREIGN KEY (idProjeto) REFERENCES Projeto(id),
                    FOREIGN KEY (idOperario) REFERENCES Operario(id)
                );
            """;

            // Tabela Associativa Uso_Equipamento
            String createTableUsoEquipamento = """
                CREATE TABLE IF NOT EXISTS Uso_Equipamento (
                    idProjeto INTEGER,
                    idEquipamento INTEGER,
                    PRIMARY KEY (idProjeto, idEquipamento),
                    FOREIGN KEY (idProjeto) REFERENCES Projeto(id),
                    FOREIGN KEY (idEquipamento) REFERENCES Equipamento(id)
                );
            """;

            // Tabela Associativa Consumo_Material
            String createTableConsumoMaterial = """
                CREATE TABLE IF NOT EXISTS Consumo_Material (
                    idProjeto INTEGER,
                    idMaterial INTEGER,
                    PRIMARY KEY (idProjeto, idMaterial),
                    FOREIGN KEY (idProjeto) REFERENCES Projeto(id),
                    FOREIGN KEY (idMaterial) REFERENCES Material(id)
                );
            """;

            // Executa a criação das tabelas
            stmt.execute(createTableProjeto);
            stmt.execute(createTableEngenheiro);
            stmt.execute(createTableOperario);
            stmt.execute(createTableEquipamento);
            stmt.execute(createTableMaterial);
            stmt.execute(createTableAlocacaoEngenheiro);
            stmt.execute(createTableAlocacaoOperario);
            stmt.execute(createTableUsoEquipamento);
            stmt.execute(createTableConsumoMaterial);

            System.out.println("Tabelas criadas com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
