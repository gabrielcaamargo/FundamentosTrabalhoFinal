package application.entities;

import application.enums.EquipamentoStatusEnum;

public class Equipamento {
    private int id;
    private String nome;
    private String tipo;
    private int quantidadeHorasEmprestimo;
    private boolean seguro;
    private double valorEmprestimo;
    private EquipamentoStatusEnum status;

    public Equipamento(int id, String nome, String tipo, int quantidadeHorasEmprestimo, boolean seguro, double valorEmprestimo) {
        if (id > 0) this.id = id;
        if (nome != null) this.nome = nome;
        if (tipo != null) this.tipo = tipo;
        if (quantidadeHorasEmprestimo >= 3) this.quantidadeHorasEmprestimo = quantidadeHorasEmprestimo;
        this.seguro = seguro;
        if (valorEmprestimo > 0) this.valorEmprestimo = valorEmprestimo;
        this.status = EquipamentoStatusEnum.DISPONIVEL;

        this.valorEmprestimo = calculaDescontoValorHoras(valorEmprestimo, quantidadeHorasEmprestimo);
        this.valorEmprestimo = calculaDescontoValorSeguro(this.valorEmprestimo, seguro);
    }

    public Equipamento() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidadeHorasEmprestimo() {
        return quantidadeHorasEmprestimo;
    }

    public void setQuantidadeHorasEmprestimo(int quantidadeHorasEmprestimo) {
        this.quantidadeHorasEmprestimo = quantidadeHorasEmprestimo;
    }

    public boolean getSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public EquipamentoStatusEnum getStatus() {
        return status;
    }

    public void setStatus(EquipamentoStatusEnum status) {
        this.status = status;
    }

    public double calculaDescontoValorSeguro(double valor, boolean seguro) {
        if (seguro) {
            return valor + (valor * 0.02);
        }
        return valor;
    }

    public double calculaDescontoValorHoras(double valor, int quantidadeHoras) {
        double desconto = 0;
        if (quantidadeHoras >= 36) {
            desconto = 0.10;
        } else if (quantidadeHoras >= 24) {
            desconto = 0.05;
        }
        return valor - (valor * desconto);
    }

    public void retirarEquipamento() {
        if (this.status == EquipamentoStatusEnum.DISPONIVEL) {
            this.status = EquipamentoStatusEnum.EMPRESTADO;
        }
    }

    public void devolverEquipamento() {
        this.status = EquipamentoStatusEnum.DISPONIVEL;
    }

    public double renovarHoras(int horasAdicionais) {
        if (horasAdicionais > 0) {
            double valorAdicional = (valorEmprestimo / quantidadeHorasEmprestimo) * horasAdicionais;
            quantidadeHorasEmprestimo += horasAdicionais;
            return valorAdicional;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "Equipamento: " +
                "id: " + id +
                ", nome: '" + nome + '\'' +
                ", tipo: '" + tipo + '\'' +
                ", Quantidade de horas de empréstimo: " + quantidadeHorasEmprestimo +
                ", Seguro: " + seguro +
                ", Valor do empréstimo: " + valorEmprestimo +
                ", Status: " + status +
                '}';
    }
}

