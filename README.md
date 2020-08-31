# Projeto de Estudos Sobre Servlets

[![GitHub license](https://img.shields.io/github/license/pricardoti/learn-servlets)](https://github.com/pricardoti/learn-servlets/blob/master/LICENSE)
[![Build Status](https://travis-ci.com/pricardoti/learn-servlets.svg?branch=master)](https://travis-ci.com/pricardoti/learn-servlets)

## Meu Primeiro Servlet

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

Primeiro o uso da anotation ```@WebServlet```, por meio dela que poderemos definir um ```urlPatterns```, que é nada mais que o nome do Servlet na URL que utilizaremos no navegador. 

E o segundo ponto é o ```@Override``` no método ```service()``` que sempre será chamado automaticamente quando houver uma requisição para o PATH configurado, nele implementamos o retorno de um HTML de exemplo.

Iremos executar o nosso servidor web, então seguiremos para o navegador, onde digitaremos a URL http://localhost:8080/gerenciador/myServlet, onde devemos ter uma pagina HTML simples com texto "Olá, parabéns você escreveu o primeiro servlets." como resultado.

Uma observação bem importante, é que no mundo HTTP existem duas formas de devolver uma resposta, sendo uma dessas alternativas, o uso do método ```getWriter()``` para devolver um conteúdo HTML. O ```getWriter()``` devolve um objeto chamado ```PrintWriter``` do pacote ```java.io```. 

## Métodos GET e POST

Dentro das requisições trabalhamos com os verbos HTTP que especificamente no Servlet são representados e tratados por meio dos métodos "doPost" e "doGet" que são os mais comuns, porém existem outros. A seguir temos a seguinte implementação para representar este comportamento:

```
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

```

Iremos executar o nosso servidor web, então seguiremos para o navegador, onde digitaremos a URL http://localhost:8080/gerenciador/empresa. 

Quando uma URL via browser por padrão estamos executamos um GET, para exeutar uma reqisição do tipo POST é necessario criar um formulario (devidamente implementado) ou usar alguma ferramenta como Postman ou Insominia.

Alguns Links para entendermos melhor verbos HTTP:

- https://restfulapi.net/http-methods/
- https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Methods
- https://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html

## JSP - JavaServer Pages

JSP é o acrônimo para Java Server Pages, uma linguagem criada pela SUN gratuita, JSP é uma linguagem de script com especificação aberta que tem como objetivo primário a geração de conteúdo dinâmico para páginas da Internet.

Uma pagina JSP possui extensão ```.jsp``` e consiste em uma página com codificação HTML e com codificação Java, inserida entre as tag´s ```<% e %>```, que são chamdas de **scriptlets**.

### Scriptlet

Na tecnologia JavaServer Pages (JSP), um scriptlet (que vem da palavra em inglês script, que significa "roteiro" ou tecnicamente falando, um pedaço de código em linguagem script, e do sufixo let, que indica o diminutivo, ou seja pequeno script ou scriptzinho) é um pedaço de código Java embutido em um código JSP semelhante a um código HTML. O scriptlet é todo o conteúdo que está dentro das tags ```<% %>```. Entre elas o usuário pode adicionar qualquer scriptelt válido, isto é, qualquer código Java.

*Fonte: [Wikipedia Scriptlet](https://pt.wikipedia.org/wiki/Scriptlet)*

### JSTL - JavaServer Pages Standard Tag Library

A JavaServer Pages Standard Tag Library (JSTL) encapsula, como tags simples, a funcionalidade central comum a muitos aplicativos JSP. Por exemplo, em vez de sugerir que você itere em listas usando um scriptlet ou diferentes tags de iteração de vários fornecedores, o JSTL define uma tag padrão que funciona da mesma forma em todos os lugares. Essa padronização permite aprender uma única tag e usá-la em vários contêineres JSP.

JSTL tem suporte para tarefas estruturais comuns, como iteração e condicionais, tags para manipulação de documentos XML, internacionalização e tags de formatação com distinção de local e tags SQL. Ele também apresenta uma nova linguagem de expressão para simplificar o desenvolvimento da página e fornece uma API para os desenvolvedores simplificar a configuração de tags JSTL e o desenvolvimento de tags customizadas que estão em conformidade com as convenções JSTL. 

*Fonte: [JSTL Documentation](https://www.oracle.com/java/technologies/jstl-documentation.html)*
