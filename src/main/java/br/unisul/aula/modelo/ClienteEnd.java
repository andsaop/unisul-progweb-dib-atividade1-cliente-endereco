package br.unisul.aula.modelo;

public class ClienteEnd {
    private Long id;
    private String nome;
    
    public ClienteEnd() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "ClientEnd{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}