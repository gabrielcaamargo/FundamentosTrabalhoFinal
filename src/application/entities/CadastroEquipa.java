package application.entities;

import application.enums.EquipamentoStatusEnum;
import java.util.Arrays;

public class CadastroEquipa {
    private Equipamento[] equipamentos;
    private int contador;

    public CadastroEquipa(Equipamento[] equipamentos) {
        this.equipamentos = equipamentos;
        this.contador = 6;

        equipamentos[0] = new Equipamento(1, "RaioX", "Raio-X", 50, true, 200.0);
        equipamentos[1] = new Equipamento(2, "RaioY", "Raio-X", 60, false, 180.0);
        equipamentos[2] = new Equipamento(3, "Laser1", "Raio Laser", 40, true, 150.0);
        equipamentos[3] = new Equipamento(4, "Laser2", "Raio Laser", 45, false, 170.0);
        equipamentos[4] = new Equipamento(5, "Audiometria1", "Audiometria", 30, true, 100.0);
        equipamentos[5] = new Equipamento(6, "Audiometria2", "Audiometria", 35, false, 120.0);
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

    @Override
    public String toString() {
        return "Equipamentos cadastrados: " +
                "equipamentos: " + Arrays.toString(equipamentos);
    }

    public boolean adicionaEquipa(Equipamento equipamento) {
        if (contador < 10) {
            equipamentos[contador] = equipamento;
            contador++;
            return true;
        }
        return false;
    }

    public boolean removeEquipa(Equipamento equipamento) {
        for (int i = 0; i < contador; i++) {
            if (equipamentos[i].equals(equipamento)) {
                for (int j = i; j < contador - 1; j++) {
                    equipamentos[j] = equipamentos[j + 1];
                }
                equipamentos[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    public Equipamento buscaEquipaPeloNome(String nome) {
        for (int i = 0; i < contador; i++) {
            if (equipamentos[i].getNome().equalsIgnoreCase(nome)) {
                return equipamentos[i];
            }
        }
        return null;
    }

    public int totalEquipamentos() {
        int soma = 0;
        for (int i = 0; i < contador; i++) {
            if (equipamentos[i].getStatus() == EquipamentoStatusEnum.DISPONIVEL) {
                soma++;
            }
        }
        return soma;
    }

    public void mostraEquipamento() {
        if (contador == 0) {
            System.out.println("Nenhum equipamento cadastrado.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(equipamentos[i].toString());
            }
        }
    }
}
