package application.entities;

import application.enums.EquipamentoStatusEnum;

import java.util.Arrays;

public class CadastroEquipa {
    private Equipamento[] equipamentos;
    private int contador;

    public CadastroEquipa(Equipamento[] equipamentos, int contador) {
        this.equipamentos = equipamentos;
        this.contador = contador;
    }

    public Equipamento[] getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Equipamento[] equipamentos) {
        this.equipamentos = equipamentos;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public boolean adicionaEquipa(Equipamento equipamento) {
        if(contador <= 10) {
            equipamentos[contador] = equipamento;
            return true;
        }

        return false;
    }

    public boolean removeEquipa(Equipamento equipamento) {
        for(int i = 0; i < contador; i++) {
            if(equipamentos[i].equals(equipamento)) {
                for(int j = i; j < contador - 1; j++) {
                    equipamentos[j] = equipamentos[j + 1];
                }
                contador--;
                return true;
            }
        }

        return false;
    }

    public Equipamento buscaEquipaPeloNome(String nome) {
        for(int i = 0; i < contador; i++) {
            if(equipamentos[i].getNome().equals(nome)) {
                return equipamentos[i];
            }
        }

        return null;
    }

    public int totalEquipamentos() {
        int soma = 0;

        for(int i = 0; i < contador; i++) {
            if(equipamentos[i].getStatus() == EquipamentoStatusEnum.DISPONIVEL) {
                soma += equipamentos[i].getQuantidadeHorasEmprestimo();
            }
        }

        return soma;
    }

    public void mostraEquipamento() {
        for (int i = 0; i < contador; i++) {
            System.out.println(equipamentos[i].toString());
        }
    }
}
