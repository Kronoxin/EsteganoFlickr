/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.flickr4java.uploader.UploaderImp;
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
@WebServlet(name = "Ocultar", urlPatterns = {"/Ocultar"})
public class Ocultar extends HttpServlet {

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
"<html>\n" +
"  <head>\n" +
"    <title>Panoramio Layer</title>\n" +
"    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n" +
"    <meta charset=\"utf-8\">\n" +
"    <style>\n" +
"      html, body{\n" +
"        height: 100%;\n" +
"        margin: 0px;\n" +
"        padding: 0px\n" +
"      }\n" +
"	 #map-canvas\n" +
"	{\n" +
"			height: 100%;\n" +
"			width: 80%;\n" +
"			float:left;\n" +
"\n" +
"		}		  \n" +
"	  #formulario{\n" +
"		margin-top: 5px;\n" +
"		margin-left: 10px;\n" +
"		width: 19%;\n" +
"		height: 100%;\n" +
"		float:right;\n" +
"\n" +
"	  \n" +
"	  }\n" +
"    body{\n" +
"      background-color: #9eb;\n" +
"    }\n" +
"	  \n" +
"      #panel {\n" +
"        position: absolute;\n" +
"        top: 5px;\n" +
"        left: 50%;\n" +
"        margin-left: -180px;\n" +
"        z-index: 5;\n" +
"        background-color: #fff;\n" +
"        padding: 5px;\n" +
"        border: 1px solid #999;\n" +
"      }\n" +
"#photo-panel {\n" +
"  background: #fff;\n" +
"  padding: 5px;\n" +
"  overflow-y: auto;\n" +
"  overflow-x: hidden;\n" +
"  width: 300px;\n" +
"  max-height: 300px;\n" +
"  font-size: 14px;\n" +
"  font-family: Arial;\n" +
"  border: 1px solid #ccc;\n" +
"  box-shadow: -2px 2px 2px rgba(33, 33, 33, 0.4);\n" +
"  display: none;\n" +
"}\n" +
"    </style>\n" +
"    <script src=\"https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=panoramio\"></script>\n" +
"    <script>\n" +
"function initialize() {\n" +
"  var mapOptions = {\n" +
"    zoom: 16,\n" +
"    center: new google.maps.LatLng(40.4378271, -3.6795367)\n" +
"  };\n" +
"\n" +
"  var map = new google.maps.Map(document.getElementById('map-canvas'),\n" +
"      mapOptions);\n" +
"\n" +
"  var panoramioLayer = new google.maps.panoramio.PanoramioLayer();\n" +
"  panoramioLayer.setMap(map);\n" +
"\n" +
"  var photoPanel = document.getElementById('photo-panel');\n" +
"  map.controls[google.maps.ControlPosition.RIGHT_TOP].push(photoPanel);\n" +
"\n" +
"  google.maps.event.addListener(panoramioLayer, 'click', function(photo) {\n" +
"    var li = document.createElement('li');\n" +
"    var link = document.createElement('a');\n" +
"    link.innerHTML = photo.featureDetails.title + ': ' +\n" +
"        photo.featureDetails.author;\n" +
"    link.setAttribute('href', photo.featureDetails.url);\n" +
"	 //Mostramos el alert con la URL de la imagen\n" +
"    //alert(photo.featureDetails.url);\n" +
"    //Añadimos esa imagen elegida al input del formulario\n" +
"    var str = photo.featureDetails.url.lastIndexOf(\"/\");\n" +
"    str++;\n" +
"    var idFoto= photo.featureDetails.url.substring(str);\n" +
"\n" +
"    document.getElementById(\"imgelegida\").value=idFoto;\n" +
"\n" +
"    li.appendChild(link);\n" +
"    photoPanel.appendChild(li);\n" +
"    photoPanel.style.display = 'block';\n" +
"  });\n" +
"}\n" +
"\n" +
"google.maps.event.addDomListener(window, 'load', initialize);\n" +
"\n" +
"    </script>\n" +
"  </head>\n" +
"  <body>\n" +
" <ul id=\"photo-panel\">\n" +
"      <li><strong>Photos clicked</strong></li>\n" +
"    </ul>\n" +
"    <div id=\"map-canvas\"></div>\n" +
"  <div id=\"formulario\">\n" +
"    <h3 style=\"text-align: center; border-radius: 20px; border: 1px solid black;\">Ocultar</h3>\n" +
"  <form action=\"\" method=\"POST\">\n" +
"      <p>Has elegido la imagen: </p>\n" +
"      <input id=\"imgelegida\" name=\"imgelegida\" type\"text\" value=\"\" size=\"30\">\n" +
"      <p>Mensaje oculto: </p>\n" +
"      <textarea id=\"mensaje\" name=\"mensaje\" rows=\"10\" cols=\"30\"></textarea>\n" +
"      <br>\n" +
"      <input type =\"submit\" value=\"Ocultar mensaje y subir a Flickr\">\n" +
"  \n" +
"  </form>\n" +
"  </div>\n" +
"  </body>\n" +
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
        String id = request.getParameter("imgelegida");
        String mensaje = request.getParameter("mensaje");
        
        DescargarImg c = new DescargarImg();
        String path = c.DescargarImagen(id);
        String pathUpload = EsteganoAparicion.ocultar(mensaje,path);
        String mensajeSacado = EsteganoAparicion.mostrar(pathUpload);
        UploaderImp b = new UploaderImp();
        String idImagenFlickr= b.upload(pathUpload);
      
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"es\">\n" +
"<head>\n" +
"<title>MASH-UP</title>\n" +
"<script>\n" +
"window.location.replace(\'https://www.flickr.com/photos/kronoxin/"+idImagenFlickr+"/sizes/o');\n" +
"</script>\n" +
"\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"	\n" +
"\n" +
"</body>\n" +
"</html>");
                    }
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
