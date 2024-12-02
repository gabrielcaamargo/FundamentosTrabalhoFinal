import application.entities.CadastroEquipa;
import application.entities.Cliente;
import application.entities.CadastroCliente;
import application.entities.Equipamento;
import application.enums.EquipamentoStatusEnum;

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
            System.out.println("10 - Renovar Equipamento");
            System.out.println("11 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        int matricula;
                        String nomeCliente;
                        String empresa;

                        System.out.print("Digite a matrícula do cliente: ");
                        matricula = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite o nome do cliente: ");
                        nomeCliente = scanner.nextLine();

                        System.out.println("Digite o nome da empresa: ");
                        empresa = scanner.nextLine();

                        Cliente cliente = new Cliente(matricula, nomeCliente, empresa, null);
                        cadastroClientes.adicionaCliente(cliente);
                        System.out.println("Cliente cadastrado com sucesso.");
                        break;

                    case 2:
                        cadastroClientes.mostraClientes();
                        break;
                    case 3:
                        System.out.println("Digite o nome do cliente: ");
                        String nome = scanner.nextLine();
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
                        scanner.nextLine();

                        System.out.println("Digite o nome do equipamento:");
                        String nomeEquipamento = scanner.nextLine();

                        System.out.println("Digite o tipo do equipamento: ");
                        tipo = scanner.nextLine();

                        System.out.println("Digite a quantidade de horas de empréstimo: ");
                        quantidadeHorasEmprestimo = scanner.nextInt();

                        System.out.println("Digite se o equipamento possui seguro (true/false): ");
                        seguro = scanner.nextBoolean();

                        System.out.println("Digite o valor do empréstimo: ");
                        valorEmprestimo = scanner.nextDouble();

                        Equipamento equipamento = new Equipamento(id, nomeEquipamento, tipo, quantidadeHorasEmprestimo, seguro, valorEmprestimo);
                        if (cadastroEquipa.adicionaEquipa(equipamento)) {
                            System.out.println("Equipamento cadastrado com sucesso.");
                        } else {
                            System.out.println("Não foi possível cadastrar o equipamento. Limite atingido.");
                        }
                        break;

                    case 5:
                        for (int i = 0; i < equipamentos.length; i++) {
                            if (equipamentos[i] != null) {
                                System.out.println(equipamentos[i].toString());
                            }
                        }
                        break;

                    case 6:
                        System.out.println("Digite o nome do equipamento: ");
                        nomeEquipamento = scanner.nextLine();

                        Equipamento equipamentoEncontrado = cadastroEquipa.buscaEquipaPeloNome(nomeEquipamento);
                        if (equipamentoEncontrado != null) {
                            System.out.println(equipamentoEncontrado.toString());
                        } else {
                            System.out.println("Equipamento não encontrado.");
                        }
                        break;

                    case 7:
                        System.out.println("Digite o nome do equipamento: ");
                        nomeEquipamento = scanner.nextLine();

                        System.out.println("Digite o nome do cliente: ");
                        String nomeClienteRetirar = scanner.nextLine();

                        Equipamento equipamentoParaRetirar = cadastroEquipa.buscaEquipaPeloNome(nomeEquipamento);
                        Cliente clienteParaRetirar = cadastroClientes.buscaClientePeloNome(nomeClienteRetirar);

                        if (equipamentoParaRetirar != null && clienteParaRetirar != null) {
                            if (equipamentoParaRetirar.getStatus() == EquipamentoStatusEnum.DISPONIVEL) {
                                equipamentoParaRetirar.retirarEquipamento();
                                clienteParaRetirar.setDadosEquipamentosRetirados(equipamentoParaRetirar);
                                System.out.println("Equipamento retirado com sucesso.");
                            } else {
                                System.out.println("Equipamento já está emprestado.");
                            }
                        } else {
                            System.out.println("Cliente ou equipamento não encontrado.");
                        }
                        break;

                    case 8:
                        System.out.println("Digite o nome do equipamento: ");
                        nomeEquipamento = scanner.nextLine();

                        System.out.println("Digite o nome do cliente: ");
                        nomeClienteRetirar = scanner.nextLine();

                        equipamentoParaRetirar = cadastroEquipa.buscaEquipaPeloNome(nomeEquipamento);
                        clienteParaRetirar = cadastroClientes.buscaClientePeloNome(nomeClienteRetirar);

                        if (equipamentoParaRetirar != null && clienteParaRetirar != null) {
                            if (equipamentoParaRetirar.getStatus() == EquipamentoStatusEnum.EMPRESTADO) {
                                equipamentoParaRetirar.devolverEquipamento();
                                clienteParaRetirar.setDadosEquipamentosRetirados(null);
                                System.out.println("Equipamento devolvido com sucesso.");
                            } else {
                                System.out.println("O equipamento não foi retirado.");
                            }
                        } else {
                            System.out.println("Cliente ou equipamento não encontrado.");
                        }
                        break;

                    case 9:
                        System.out.println("Quantidade de Equipamentos Disponíveis: " + (10 - quantidadeEquipamentos));
                        break;

                    case 10:
                        // Renovação de equipamento
                        System.out.println("Digite o nome do equipamento que deseja renovar:");
                        nomeEquipamento = scanner.nextLine();

                        Equipamento equipamentoParaRenovar = cadastroEquipa.buscaEquipaPeloNome(nomeEquipamento);
                        if (equipamentoParaRenovar != null) {
                            System.out.println("Digite a quantidade de horas adicionais para renovação:");
                            int horasAdicionais = scanner.nextInt();
                            scanner.nextLine();

                            double valorAdicional = equipamentoParaRenovar.renovarHoras(horasAdicionais);
                            if (valorAdicional > 0) {
                                System.out.printf("Horas renovadas com sucesso! Valor adicional a pagar: R$ %.2f\n", valorAdicional);
                            } else {
                                System.out.println("Erro na renovação. Verifique a quantidade de horas.");
                            }
                        } else {
                            System.out.println("Equipamento não encontrado.");
                        }
                        break;

                    case 11:
                        System.out.println("Saindo do programa...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida! Tente novamente.");
                scanner.nextLine();
            }
        } while (opcao != 11);

    }
}
