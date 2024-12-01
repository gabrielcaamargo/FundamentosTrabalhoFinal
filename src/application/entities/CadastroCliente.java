package application.entities;

import java.util.ArrayList;
import java.util.List;

public class CadastroCliente {

    private Cliente[] clientes;
    private int quantidadeAtual;

    public CadastroCliente() {
        this.clientes = new Cliente[10];
        this.quantidadeAtual = 0;
    }

    public boolean adicionaCliente(Cliente cliente) {
        if (quantidadeAtual < clientes.length) {
            clientes[quantidadeAtual] = cliente;
            quantidadeAtual++;
            return true;
        } else {
            return false;
        }
    }

    public Cliente buscaClientePeloNome(String nome) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getNomeCliente().equalsIgnoreCase(nome)) {
                return clientes[i];
            }
        }
        return null;
    }

    public void mostraClientes() {
        if (quantidadeAtual == 0) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (int i = 0; i < quantidadeAtual; i++) {
                System.out.println(clientes[i]);
            }
        }
    }
}
