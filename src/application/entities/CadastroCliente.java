package application.entities;

public class CadastroCliente {

    private Cliente[] clientes;
    private int tamanho;

    public CadastroCliente() {
        clientes = new Cliente[10];
        tamanho = 0;
    }

    public boolean adicionaCliente(Cliente cliente) {
        if (tamaho < 10) {
            clientes[tamanho] = cliente;
            tamanho++;
            return true;
        }
        else {
            return false;
        }
    }

    public Cliente buscaClientePeloNome(String nome) {
        for(int i = 0; i < tamanho; i++) {
            if(cliente[i].getNome().equals(nome)); {
                return clientes[i];
            }

        }
        return null;
    }
}
