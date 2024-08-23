import DAO.*;
import Alocacao.AlocacaoEngenheiro;
import Alocacao.AlocacaoOperario;
import Alocacao.ConsumoMaterial;
import Alocacao.UsoEquipamento;
import Elementos.Equipamento;
import Elementos.Material;
import Entidades.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            SetupDatabase.setupTables();

            EngenheiroDAO engenheiroDAO = new EngenheiroDAO();
            OperarioDAO operarioDAO = new OperarioDAO();
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
            MaterialDAO materialDAO = new MaterialDAO();
            ProjetoDAO projetoDAO = new ProjetoDAO();
            AlocacaoEngenheiroDAO alocacaoEngenheiroDAO = new AlocacaoEngenheiroDAO();
            AlocacaoOperarioDAO alocacaoOperarioDAO = new AlocacaoOperarioDAO();
            UsoEquipamentoDAO usoEquipamentoDAO = new UsoEquipamentoDAO();
            ConsumoMaterialDAO consumoMaterialDAO = new ConsumoMaterialDAO();

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Inserir Projeto");
                System.out.println("2. Listar Projetos");
                System.out.println("3. Atualizar Projeto");
                System.out.println("4. Excluir Projeto");
                System.out.println("5. Inserir Engenheiro");
                System.out.println("6. Listar Engenheiros");
                System.out.println("7. Atualizar Engenheiro");
                System.out.println("8. Excluir Engenheiro");
                System.out.println("9. Inserir Operário");
                System.out.println("10. Listar Operários");
                System.out.println("11. Atualizar Operário");
                System.out.println("12. Excluir Operário");
                System.out.println("13. Inserir Equipamento");
                System.out.println("14. Listar Equipamentos");
                System.out.println("15. Atualizar Equipamento");
                System.out.println("16. Excluir Equipamento");
                System.out.println("17. Inserir Material");
                System.out.println("18. Listar Materiais");
                System.out.println("19. Atualizar Material");
                System.out.println("20. Excluir Material");
                System.out.println("21. Listar Engenheiros e Operários Alocados em um Projeto");
                System.out.println("22. Listar Equipamentos e Materiais Utilizados em um Projeto");
                System.out.println("0. Sair");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        Projeto projeto = new Projeto();
                        System.out.print("Nome do Projeto: ");
                        projeto.setNomeProjeto(scanner.nextLine());
                        System.out.print("Local: ");
                        projeto.setLocal(scanner.nextLine());
                        System.out.print("Data de Início (YYYY-MM-DD): ");
                        projeto.setDataInicio(scanner.nextLine());
                        System.out.print("Data de Término (YYYY-MM-DD): ");
                        projeto.setDataTermino(scanner.nextLine());
                        projetoDAO.inserir(projeto);
                        break;

                    case 2:
                        List<Projeto> projetos = projetoDAO.listar();
                        projetos.forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("ID do Projeto para Atualizar: ");
                        int idProjeto = scanner.nextInt();
                        scanner.nextLine();
                        Projeto projetoAtualizar = new Projeto();
                        projetoAtualizar.setId(idProjeto);
                        System.out.print("Nome do Projeto: ");
                        projetoAtualizar.setNomeProjeto(scanner.nextLine());
                        System.out.print("Local: ");
                        projetoAtualizar.setLocal(scanner.nextLine());
                        System.out.print("Data de Início (YYYY-MM-DD): ");
                        projetoAtualizar.setDataInicio(scanner.nextLine());
                        System.out.print("Data de Término (YYYY-MM-DD): ");
                        projetoAtualizar.setDataTermino(scanner.nextLine());
                        projetoDAO.atualizar(projetoAtualizar);
                        break;

                    case 4:
                        System.out.print("ID do Projeto para Excluir: ");
                        int idProjetoExcluir = scanner.nextInt();
                        scanner.nextLine();
                        projetoDAO.excluir(idProjetoExcluir);
                        break;

                    case 5:
                        Engenheiro engenheiro = new Engenheiro();
                        System.out.print("Nome do Engenheiro: ");
                        engenheiro.setNomeEngenheiro(scanner.nextLine());
                        System.out.print("Especialidade: ");
                        engenheiro.setEspecialidade(scanner.nextLine());
                        engenheiroDAO.inserir(engenheiro);
                        break;

                    case 6:
                        List<Engenheiro> engenheiros = engenheiroDAO.listar();
                        engenheiros.forEach(System.out::println);
                        break;

                    case 7:
                        System.out.print("ID do Engenheiro para Atualizar: ");
                        int idEngenheiro = scanner.nextInt();
                        scanner.nextLine();
                        Engenheiro engenheiroAtualizar = new Engenheiro();
                        engenheiroAtualizar.setId(idEngenheiro);
                        System.out.print("Nome do Engenheiro: ");
                        engenheiroAtualizar.setNomeEngenheiro(scanner.nextLine());
                        System.out.print("Especialidade: ");
                        engenheiroAtualizar.setEspecialidade(scanner.nextLine());
                        engenheiroDAO.atualizar(engenheiroAtualizar);
                        break;

                    case 8:
                        System.out.print("ID do Engenheiro para Excluir: ");
                        int idEngenheiroExcluir = scanner.nextInt();
                        scanner.nextLine();
                        engenheiroDAO.excluir(idEngenheiroExcluir);
                        break;

                    case 9:
                        Operario operario = new Operario();
                        System.out.print("Nome do Operário: ");
                        operario.setNomeOperario(scanner.nextLine());
                        System.out.print("Função: ");
                        operario.setFuncao(scanner.nextLine());
                        operarioDAO.inserir(operario);
                        break;

                    case 10:
                        List<Operario> operarios = operarioDAO.listar();
                        operarios.forEach(System.out::println);
                        break;

                    case 11:
                        System.out.print("ID do Operário para Atualizar: ");
                        int idOperario = scanner.nextInt();
                        scanner.nextLine();
                        Operario operarioAtualizar = new Operario();
                        operarioAtualizar.setId(idOperario);
                        System.out.print("Nome do Operário: ");
                        operarioAtualizar.setNomeOperario(scanner.nextLine());
                        System.out.print("Função: ");
                        operarioAtualizar.setFuncao(scanner.nextLine());
                        operarioDAO.atualizar(operarioAtualizar);
                        break;

                    case 12:
                        System.out.print("ID do Operário para Excluir: ");
                        int idOperarioExcluir = scanner.nextInt();
                        scanner.nextLine();
                        operarioDAO.excluir(idOperarioExcluir);
                        break;

                    case 13:
                        Equipamento equipamento = new Equipamento();
                        System.out.print("Nome do Equipamento: ");
                        equipamento.setNomeEquipamento(scanner.nextLine());
                        System.out.print("Tipo: ");
                        equipamento.setTipo(scanner.nextLine());
                        equipamentoDAO.inserir(equipamento);
                        break;

                    case 14:
                        List<Equipamento> equipamentos = equipamentoDAO.listar();
                        equipamentos.forEach(System.out::println);
                        break;

                    case 15:
                        System.out.print("ID do Equipamento para Atualizar: ");
                        int idEquipamento = scanner.nextInt();
                        scanner.nextLine();
                        Equipamento equipamentoAtualizar = new Equipamento();
                        equipamentoAtualizar.setIdEquipamento(idEquipamento);
                        System.out.print("Nome do Equipamento: ");
                        equipamentoAtualizar.setNomeEquipamento(scanner.nextLine());
                        System.out.print("Tipo: ");
                        equipamentoAtualizar.setTipo(scanner.nextLine());
                        equipamentoDAO.atualizar(equipamentoAtualizar);
                        break;

                    case 16:
                        System.out.print("ID do Equipamento para Excluir: ");
                        int idEquipamentoExcluir = scanner.nextInt();
                        scanner.nextLine();
                        equipamentoDAO.excluir(idEquipamentoExcluir);
                        break;

                    case 17:
                        Material material = new Material();
                        System.out.print("Nome do Material: ");
                        material.setNomeMaterial(scanner.nextLine());
                        System.out.print("Quantidade: ");
                        material.setQuantidade(scanner.nextInt());
                        scanner.nextLine();
                        materialDAO.inserir(material);
                        break;

                    case 18:
                        List<Material> materiais = materialDAO.listar();
                        materiais.forEach(System.out::println);
                        break;

                    case 19:
                        System.out.print("ID do Material para Atualizar: ");
                        int idMaterial = scanner.nextInt();
                        scanner.nextLine();
                        Material materialAtualizar = new Material();
                        materialAtualizar.setId(idMaterial);
                        System.out.print("Nome do Material: ");
                        materialAtualizar.setNomeMaterial(scanner.nextLine());
                        System.out.print("Quantidade: ");
                        materialAtualizar.setQuantidade(scanner.nextInt());
                        scanner.nextLine();
                        materialDAO.atualizar(materialAtualizar);
                        break;

                    case 20:
                        System.out.print("ID do Material para Excluir: ");
                        int idMaterialExcluir = scanner.nextInt();
                        scanner.nextLine();
                        materialDAO.excluir(idMaterialExcluir);
                        break;

                    case 21:
                        System.out.print("ID do Projeto: ");
                        int idProjetoAlocados = scanner.nextInt();
                        scanner.nextLine();
                        List<AlocacaoEngenheiro> engenheirosAlocados = alocacaoEngenheiroDAO.listarPorProjeto(idProjetoAlocados);
                        List<AlocacaoOperario> operariosAlocados = alocacaoOperarioDAO.listarPorProjeto(idProjetoAlocados);
                        System.out.println("Engenheiros Alocados:");
                        engenheirosAlocados.forEach(System.out::println);
                        System.out.println("Operários Alocados:");
                        operariosAlocados.forEach(System.out::println);
                        break;

                    case 22:
                        System.out.print("ID do Projeto: ");
                        int idProjetoUtilizados = scanner.nextInt();
                        scanner.nextLine();
                        List<UsoEquipamento> equipamentosUtilizados = usoEquipamentoDAO.listarPorProjeto(idProjetoUtilizados);
                        List<ConsumoMaterial> materiaisUtilizados = consumoMaterialDAO.listarPorProjeto(idProjetoUtilizados);
                        System.out.println("Equipamentos Utilizados:");
                        equipamentosUtilizados.forEach(System.out::println);
                        System.out.println("Materiais Utilizados:");
                        materiaisUtilizados.forEach(System.out::println);
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (choice != 0);

            scanner.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
