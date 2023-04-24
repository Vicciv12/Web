package guga;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookies")
public class Cookies extends HttpServlet{
   protected void doGet(HttpServletRequest request, HttpServletResponse response) {
      try{
    	  String nomePessoa = "";
    	  String dadoAcademico = "";
    	  String dadoProfissional = "";
    	  Cookies  cookies [] = null;
    	  Cookie[] Cookies = request.getCookies();
    	  
	PrintWriter writer = response.getWriter();	
	writer.append( " <HTML>  <BODY> " );
	writer.append("<FORM action=\"Cookies\" method=\"get\">");
	writer.append("<INPUT type=\"text\" name=\"dadosPessoais\" placeholder=\"Informe seu dados pessoais\"/>");
	writer.append("<INPUT type=\"text\" name=\"dadosAcademicos\" placeholder=\"Informe seu dados academicos\"/>");
	writer.append("<INPUT type=\"text\" name=\"dadosProfissionais\" placeholder=\"Informe seus dados profissionais\"/>");
	writer.append("<INPUT type=\"submit\" value=\"Enviar\"/>");
	writer.append("</FORM>");
	
	nomePessoa = request.getParameter("dadosPessoais");
	dadoAcademico = request.getParameter("dadosAcademicos");
	dadoProfissional = request.getParameter("dadosProfissionais");
	
	Cookie cookie1 = new Cookie("dadosPessoais", nomePessoa);
	Cookie cookie2 = new Cookie("dadosAcademicos", dadoAcademico);		
	Cookie cookie3 = new Cookie("dadosProfissionais", dadoProfissional);
	
	cookie1.setMaxAge(60*2); //2 minutos
	cookie2.setMaxAge(60*2); //2 minutos
	cookie3.setMaxAge(60*2); //2 minutos
	
	response.addCookie(cookie1);
	response.addCookie(cookie2);
	response.addCookie(cookie3);
	
	writer.append( " <H1> Exemplo de cookies (nome, valor) </H1> " );
	writer.append(  "Dados pessoais:  " + cookie1.getValue() +"<br> " );
	writer.append(  "Dados academicos: " + cookie2.getValue() +"<br> " );
	writer.append(  "Dados profissionais: " + cookie3.getValue() +"<br> " );
	writer.append( "</BODY> </HTML>  " );
	
       } catch (IOException e){
e.printStackTrace();	
       } 
   }

public static void main(String[] args) {
} 
}
