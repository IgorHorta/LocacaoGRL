package models;


import java.io.Serializable;

/**
 * Classe que representa um cliente da
 * loja de locação de veiculos
 */
public class Cliente implements Serializable{

    private String cpf;
    private String nome;
    private String profissao;

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {

        return "\n --------\n"+
                "\ncpf: "+ (cpf == null ? "":cpf) +
                "\nnome: "+ (nome == null ? "":nome)+
                "\nprofissao: "+ (profissao == null ? "":profissao);
    }

}
