package application.entities;
public class Cliente {

    private int matricula;
    private String nomeCliente, empresa;
    private Equipamento dadosEquipamentosRetirados;

    public Cliente(int matricula, String nomeCliente, String empresa, Equipamento dadosEquipamentosRetirados) {
        this.matricula = matricula;
        this.nomeCliente = nomeCliente;
        this.empresa = empresa;
        this.dadosEquipamentosRetirados = dadosEquipamentosRetirados;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Equipamento getDadosEquipamentosRetirados() {
        return dadosEquipamentosRetirados;
    }

    public void setDadosEquipamentosRetirados(Equipamento dadosEquipamentosRetirados) {
        this.dadosEquipamentosRetirados = dadosEquipamentosRetirados;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Cliente{" +
                "matricula=" + matricula +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", empresa='" + empresa + '\'' +
                ", dadosEquipamentosRetirados=" + dadosEquipamentosRetirados +
                '}';
    }
}