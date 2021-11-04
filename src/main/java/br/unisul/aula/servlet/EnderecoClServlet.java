package br.unisul.aula.servlet;

import br.unisul.aula.banco.EnderecoDAO;
import br.unisul.aula.banco.ClienteDAO;
import br.unisul.aula.dtos.EnderecoClienteDTO;
import br.unisul.aula.modelo.Endereco;
import br.unisul.aula.modelo.Cliente;


import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EnderecoClServlet", value = "/enderecocl")
public class EnderecoClServlet extends HttpServlet {
    private final Gson gson = new Gson();
    private final EnderecoDAO enderecoDAO = new EnderecoDAO();
    private final ClienteDAO clienteDAO = new ClienteDAO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        Endereco endereco = consultarEnderecoPorCity(request);
        List<Cliente> clientes = consultarClientePorCity(request);

        EnderecoClienteDTO dto = new EnderecoClienteDTO(endereco, clientes);

        String enderecoJson = gson.toJson(dto);
        response.getWriter().println(enderecoJson);
    }

    private Endereco consultarEnderecoPorCity(HttpServletRequest request) {
        String cidade = request.getParameter("cidade");
        return enderecoDAO.findByCidade(cidade);
    }

    private List<Cliente> consultarClientePorCity(HttpServletRequest request) {
        String cidade = request.getParameter("cidade");
        return clienteDAO.findByCidade(cidade);
    }
}
