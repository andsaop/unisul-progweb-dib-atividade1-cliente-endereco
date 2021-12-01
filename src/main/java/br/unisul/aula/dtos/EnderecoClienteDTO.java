package br.unisul.aula.dtos;

import br.unisul.aula.modelo.Endereco;
import br.unisul.aula.modelo.Cliente;

import br.unisul.aula.modelo.ClienteEnd;
import java.util.ArrayList;
import java.util.List;

public class EnderecoClienteDTO {
    private List<ClienteEnd> clientes;
    private String cidade;
    private String uf;

    public EnderecoClienteDTO(Endereco endereco, List<Cliente> listaClientes) {
        this.clientes = converterParaClienteEnd(listaClientes);
        this.cidade = endereco.getCidade();
        this.uf = endereco.getUf().name();
    }

    public EnderecoClienteDTO() {

    }

    private List<ClienteEnd> converterParaClienteEnd(List<Cliente> listaClientes) {
        List<ClienteEnd> clientes = new ArrayList<>();
        for (Cliente element: listaClientes) {
            ClienteEnd clienteCurto = new ClienteEnd();
            clienteCurto.setId(element.getId());
            clienteCurto.setNome(element.getNome());
            clientes.add(clienteCurto);
        }

        return clientes;
    }

    public List<ClienteEnd> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteEnd> clientes) {
        this.clientes = clientes;
    }

    public String getCidadeEndereco() {
        return cidade;
    }

    public void setCidadeEndereco(String cidade) {
        this.cidade = cidade;
    }

    public String getUfEndereco() {
        return uf;
    }

    public void setUfEndereco(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "EnderecoClienteDTO{" +
                ", clientes='" + clientes + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
