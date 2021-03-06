/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.flickr4java.uploader.UploaderImp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Ruben
 */
public class DescargarImg {
   
    public String DescargarImagen(String idFoto){
        
       
       //url de la imagen a descargar
        String urlFinal = "http://static.panoramio.com/photos/large/"+idFoto+".jpg";
        //nombre del fichero destino
        String nombre = "foto.jpg";
        
        // Carpeta donde se guardarán las descargas, si no existe, se creará
        String folder = "imagenes/";

        // crea el directorio de destino en caso de que no exista
        File dir = new File(folder);

        if (!dir.exists())
                if (!dir.mkdir())
                        return null; // no se pudo crear la carpeta de destino

        // Crea el archivo destino
        File file = new File(folder + nombre);
        File file2 = null;

        try {

            // establece la conexion con la url
            URLConnection conn = new URL(urlFinal).openConnection();
            conn.connect();

            System.out.println("\nempezando descarga: \n");
            System.out.println(">> URL: " + urlFinal);
            System.out.println(">> Nombre: " + nombre);
            System.out.println(">> tamaño: " + conn.getContentLength()
                            + " bytes");

            // Abre los streams
            InputStream in = conn.getInputStream();
            OutputStream out = new FileOutputStream(file);

            int b = 0;


            /*Leemos cada byte de la imagen y los escribirmos en el archivo
             -1 cuando llega al final */
            while (b != -1) {
                    b = in.read();

                    if (b != -1)
                            out.write(b);
            }

            // Cierra los streams
            out.close();
            in.close();

            System.out.println("\ndescarga finalizada\n");
            
            BufferedImage bufferedImage = ImageIO.read(new File(file.getAbsolutePath()));
            file2 = new File("imagenes/foto.png");
            ImageIO.write(bufferedImage, "png", file2);
            
        } catch (MalformedURLException e) {
                System.out.println("la id de la imagen: " + idFoto + " no es valida!");
        } catch (IOException e) {
                e.printStackTrace();
        }
       return file2.getAbsolutePath();
        
    }
    
    
        
}

    

