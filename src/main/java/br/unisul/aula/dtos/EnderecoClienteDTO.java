package br.unisul.aula.dtos;

import br.unisul.aula.modelo.Endereco;
import br.unisul.aula.modelo.Cliente;

import br.unisul.aula.modelo.ClienteEnd;
import java.util.ArrayList;
import java.util.List;

public class EnderecoClienteDTO {
    private List<ClienteEnd> clientes;
    private String cidadeEndereco;
    private String ufEndereco;

    public EnderecoClienteDTO(Endereco endereco, List<Cliente> listaClientes) {
        this.clientes = converterParaClienteEnd(listaClientes);
        this.cidadeEndereco = endereco.getCidade();
        this.ufEndereco = endereco.getUf().name();
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
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getUfEndereco() {
        return ufEndereco;
    }

    public void setUfEndereco(String ufEndereco) {
        this.ufEndereco = ufEndereco;
    }

    @Override
    public String toString() {
        return "EnderecoClienteDTO{" +
                ", clientes='" + clientes + '\'' +
                ", cidadeEndereco='" + cidadeEndereco + '\'' +
                ", ufEndereco='" + ufEndereco + '\'' +
                '}';
    }
}
