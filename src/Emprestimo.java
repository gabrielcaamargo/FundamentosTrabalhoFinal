import application.entities.CadastroEquipa;
import application.entities.Cliente;
import application.entities.CadastroCliente;
import application.entities.Equipamento;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Emprestimo {
    private static CadastroCliente cadastroClientes = new CadastroCliente();
    private static Equipamento[] equipamentos = new Equipamento[10];
    private static int quantidadeEquipamentos = 0;
    private static CadastroEquipa cadastroEquipa = new CadastroEquipa(equipamentos, quantidadeEquipamentos);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("1 - Incluir Cliente");
            System.out.println("2 - Mostrar Clientes Cadastrados");
            System.out.println("3 - Pesquisar Cliente por Nome");
            System.out.println("4 - Incluir Equipamento");
            System.out.println("5 - Mostrar Equipamentos");
            System.out.println("6 - Pesquisar Equipamento por Nome");
            System.out.println("7 - Retirar Equipamento");
            System.out.println("8 - Devolver Equipamento");
            System.out.println("9 - Quantidade Total de Equipamentos Disponíveis");
            System.out.println("10 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    int matricula;
                    String nomeCliente;
                    String empresa;
                    Equipamento dadosEquipamentosRetirados;

                    System.out.println("Digite a matrícula do cliente: ");
                    matricula = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o nome do cliente: ");
                    nomeCliente = scanner.next();

                    System.out.println("Digite o nome da empresa: ");
                    empresa = scanner.next();

                    dadosEquipamentosRetirados = new Equipamento();

                    Cliente cliente = new Cliente(matricula, nomeCliente, empresa, dadosEquipamentosRetirados);
                    cadastroClientes.adicionaCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso.");
                    break;
                case 2:
                    cadastroClientes.mostraClientes();
                    break;
                case 3:
                    System.out.println("Digite o nome do cliente: ");
                    String nome = scanner.next();
                    Cliente clienteEncontrado = cadastroClientes.buscaClientePeloNome(nome);

                    if (clienteEncontrado != null) {
                        System.out.println(clienteEncontrado.toString());
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    int id;
                    String tipo;
                    int quantidadeHorasEmprestimo;
                    boolean seguro;
                    double valorEmprestimo;

                    System.out.println("Digite o ID do equipamento: ");
                    id = scanner.nextInt();
                    System.out.println("Digite o nome do equipamento:");
                    nome = scanner.next();

                    System.out.println("Digite o tipo do equipamento: ");
                    tipo = scanner.next();

                    System.out.println("Digite a quantidade de horas de empréstimo: ");
                    quantidadeHorasEmprestimo = scanner.nextInt();

                    System.out.println("Digite se o equipamento possui seguro (true/false): ");
                    seguro = scanner.nextBoolean();

                    System.out.println("Digite o valor do empréstimo: ");
                    valorEmprestimo = scanner.nextDouble();

                    Equipamento equipamento = new Equipamento(id, nome, tipo, quantidadeHorasEmprestimo, seguro, valorEmprestimo);
                    cadastroEquipa.adicionaEquipa(equipamento);
                    System.out.println("Equipamento cadastrado com sucesso.");
                    break;
                case 5:
                    for (int i = 0; i < equipamentos.length; i++) {
                        if(equipamentos[i] != null) {
                            System.out.println(equipamentos[i].toString());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Digite o nome do equipamento: ");
                    nome = scanner.next();

                    Equipamento equipamentoEncontrado = cadastroEquipa.buscaEquipaPeloNome(nome);
                    if (equipamentoEncontrado != null) {
                        System.out.println(equipamentoEncontrado.toString());
                    } else {
                        System.out.println("Equipamento não encontrado.");
                    }
                    break;
                case 7:
                    System.out.println("Digite o nome do equipamento: ");
                    String nomeEquipa = scanner.next();

                    System.out.println("Digite o nome do cliente: ");
                    nomeCliente = scanner.next();

                    equipamentoEncontrado = cadastroEquipa.buscaEquipaPeloNome(nomeEquipa);
                    clienteEncontrado = cadastroClientes.buscaClientePeloNome(nomeCliente);

                    if(clienteEncontrado == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    if(equipamentoEncontrado != null && clienteEncontrado != null) {
                        equipamentoEncontrado.retirarEquipamento();
                        clienteEncontrado.setDadosEquipamentosRetirados(equipamentoEncontrado);
                        System.out.println("Equipamento retirado com sucesso.");
                    } else {
                        System.out.println("Equipamento não encontrado.");
                    }

                    break;
                case 8:
                    System.out.println("Digite o nome do equipamento: ");
                    nomeEquipa = scanner.next();

                    System.out.println("Digite o nome do cliente: ");
                    nomeCliente = scanner.next();

                    equipamentoEncontrado = cadastroEquipa.buscaEquipaPeloNome(nomeEquipa);
                    clienteEncontrado = cadastroClientes.buscaClientePeloNome(nomeCliente);

                    if(clienteEncontrado == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    if(equipamentoEncontrado != null) {
                        equipamentoEncontrado.devolverEquipamento();
                        clienteEncontrado.setDadosEquipamentosRetirados(null);
                        System.out.println("Equipamento devolvido com sucesso.");
                    } else {
                        System.out.println("Equipamento não encontrado.");
                    }
                    break;
                case 9:
                    System.out.println("Quantidade de Equipamentos Disponíveis: " + (10 - quantidadeEquipamentos));
                    break;
                case 10:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 10);

        scanner.close();
    }}