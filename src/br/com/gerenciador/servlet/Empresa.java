package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Empresa
 */
@WebServlet(name = "empresa", urlPatterns = { "/empresa" })
public class Empresa extends HttpServlet {

	private static final long serialVersionUID = 3090335723980843489L;

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
		System.out.println("Executando o método doGet");
		response.getWriter().println(
				"<html><body>Executando o método doGet - QueryString: " + request.getQueryString() + "!</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Executando o método doPost");
		response.getWriter().println(
				"<html><body>Empresa " + request.getParameter("nome") + " cadastrada com sucesso!</body></html>");
	}

}
