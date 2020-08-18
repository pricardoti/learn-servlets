# Projeto de Estudos Sobre Servlets

Nós usamos o navegador para realizar uma requisição para o Tomcat por meio do protocolo HTTP (no qual o navegador é especialista). 

O navegador envia as informações na requisição HTTP, e o Tomcat reconhece essa requisição e devolve o conteúdo solicitado na reposta HTTP. *O protocolo HTTP funciona sempre na dinâmica de requisição e reposta.*

Ao receber uma requisição podemos configurar o envio de um e-mail, cadastrar alguma informação no banco de dados ou ler dados do banco e gerar um HTML dinamicamente, por exemplo.

*Servlet é um objeto especial armazenado dentro do projeto*, e sua particularidade consiste na possibilidade de o chamarmos via protocolo HTTP.

O termo **let** de **Servlet** é um sufixo diminutivo no inglês, e uma tradução livre seria algo como "Servidorzinho". A ideia é o Servlet opera de forma semelhante e auxiliar, em cima de um servidor principal como Tomcat, Widefly e etc, mas que saiba interpretar as requisições que utilizam o protocolo HTTP.

Utilizando um projeto do tipo **"Dynamic Web Project"** devidamente configurado e funcionando, temos a seguinte classe:

```
package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = -8897971612765283204L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Olá, parabéns você escreveu o primeiro servlets.");
		out.println("</body>");
		out.println("</html>");
	}
}
```
Podemos elencar dois pontos principais para trabalharmos com Servlet, o primeiro:

```
@WebServlet(urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet 
```

O uso da anotation ```@WebServlet```, por meio dela que poderemos definir um ```urlPatterns```, que é nada mais que o nome do Servlet na URL que utilizaremos no navegador. 

E o segundo ponto é o ```@Override``` no método ```service()``` que sempre será chamado automaticamente quando houver uma requisição para o PATH configurado, nele implementamos o retorno de um HTML de exemplo.

