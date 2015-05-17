/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ruben
 */
@WebServlet(name = "Principal", urlPatterns = {"/Principal"})
public class Principal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"es\">\n" +
"<head>\n" +
"<title>MASH-UP</title>\n" +
"<meta charset=\"utf-8\">\n" +
"<style type=\"text/css\">\n" +
"\n" +
"header{\n" +
"	background-color: black;\n" +
"	border-radius: 20px;\n" +
"}\n" +
"nav{\n" +
"	background-color: #9cd;\n" +
"\n" +
"}\n" +
"h1{\n" +
"	color: white;\n" +
"	text-align: center;\n" +
"	\n" +
"}\n" +
"\n" +
"#ocultar{\n" +
"	border: 1px solid black;\n" +
"	width: 400px;\n" +
"	height: 350px;\n" +
"	/*background-image: url(\"./Ocultar.jpg\");*/\n" +
"\n" +
"}\n" +
"\n" +
"#descifrar{\n" +
"	border: 1px solid black;\n" +
"	width: 500px;\n" +
"	height: 350px;\n" +
"	/*background-image: url(\"./descifrar.jpg\");*/\n" +
"\n" +
"}\n" +
"td{\n" +
"	text-align: center;\n" +
"}\n" +
"table{\n" +
"\n" +
"	padding: 20px\n" +
"}\n" +
"div.centrarTabla{\n" +
"	text-align: center;\n" +
"}\n" +
"div.centrarTabla table{\n" +
"	margin: 0 auto;\n" +
"	text-align: left;\n" +
"}\n" +
"\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"\n" +
"	<header>\n" +
"		<img src=\"Logo2.jpg\" height=\"150px\" width\"150px\">\n" +
"		<h1>Esteganografía MASHUP - Software Corporativo</h1>\n" +
"\n" +
"	</header>\n" +
"\n" +
"	<nav>\n" +
"\n" +
"	</nav>\n" +
"<div class=\"centrarTabla\">\n" +
"	<table>\n" +
"		<tr>\n" +
"			<td>\n" +
"				<div id=\"ocultar\"><a href=\"./Ocultar\" target=\"_blank\"><img src=\"./Ocultar.jpg\" width=\"400px\" height=\"350px\"></a>\n" +
"						</div>\n" +
"			</td>\n" +
"\n" +
"			<td>\n" +
"				<div id=\"descifrar\"><a href=\"./Descifrar\" target=\"_blank\"><img src=\"./descifrar.jpg\" width=\"500px\" height=\"350px\"></a></div>\n" +
"\n" +
"			</td>\n" +
"\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td><h2>Ocultar</h2></td>\n" +
"			<td><h2>Descifrar</h2></td>\n" +
"		</tr>\n" +
"\n" +
"\n" +
"\n" +
"	</table>\n" +
"</div>\n" +
"	\n" +
"	\n" +
"	<footer>\n" +
"		<hr>\n" +
"		<h4>Autores:</h4>\n" +
"		<p>	Gómez Fuentes,Rubén</p>\n" +
"		<p>	Lago Aguado,Daniel</p>\n" +
"	</footer>\n" +
"\n" +
"\n" +
"</body>\n" +
"\n" +
"</html>");
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
