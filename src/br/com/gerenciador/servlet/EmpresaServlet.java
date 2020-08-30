package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Empresa;

/**
 * Servlet implementation class Empresa
 */
@WebServlet(name = "empresa", urlPatterns = { "/empresa" })
public class EmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 3090335723980843489L;
	private Banco banco = new Banco();

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Executando o método service");
		super.service(req, resp);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("+--- Inicio - Executando o método doGet");

		StringBuilder retorno = new StringBuilder();
		retorno.append("<ul>");

		AtomicInteger index = new AtomicInteger();
		banco.getEmpresas().stream().forEach(element -> {
			retorno.append("<li>");
			retorno.append("Empresa: ");
			retorno.append(index.incrementAndGet());
			retorno.append(" - ");
			retorno.append(element.getNome());
			retorno.append("</li>");
		});

		retorno.append("</ul>");
		response.getWriter().println("<html><body>" + "<label><b>Resultado Empresas</b></label><br>" + "Served at: "
				+ request.getContextPath() + "<br>" + retorno + "</body></html>");

		System.out.println("+--- Fim - Executando o método doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("+--- Inicio - Executando o método doPost");

		Empresa empresa = new Empresa(request.getParameter("empresa"));
		banco.adicionar(empresa);
		
        // Uma outra forma de enviar dados para pagina JSP
        // request.setAttribute("empresa", empresa.getNome());
        
		//chamar o JSP
        RequestDispatcher rd = request.getRequestDispatcher("/empresa/mensagem.jsp");
        rd.forward(request, response);

		System.out.println("+--- Empresa: " + empresa);
		System.out.println("+--- Fim -Executando o método doPost");
	}

}
