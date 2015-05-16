/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ruben
 */
public class EsteganoAparicion 
{
    public static String ocultar(String mensaje, String path)
    {
        BufferedImage img = null;
        String rutaNueva = null;
        try 
        {
            img = ImageIO.read(new File(path));
            
            // Cambiamos todos los componentes azules del pixel a numero par.
            for (int i = 0; i < img.getHeight();i++)
            {
                for(int j= 0; j < img.getWidth();j++)
                {
                    int rgb = img.getRGB(j, i);
                    int red = (rgb>>16)&0x0ff;
                    int green=(rgb>>8) &0x0ff;
                    int blue= (rgb)    &0x0ff;
                    
                    if(blue%2 != 0)
                    {
                        if(blue+1 < 256)
                        {
                            blue++;
                        }
                        else
                        {
                            blue--;
                        }
                        
                        img.setRGB(j, i, new Color(red,green,blue).getRGB());
                    }
                   
                }
            }
            
            for(int k = 0; k < mensaje.length(); k++)
            {
                    int j = Character.getNumericValue(mensaje.charAt(k));
                    int i = k;
                    
                    int rgb = img.getRGB(j, i);
                    int red = (rgb>>16)&0x0ff;
                    int green=(rgb>>8) &0x0ff;
                    int blue= (rgb)    &0x0ff;
                    
                    blue--;
                    
                    img.setRGB(Character.getNumericValue(mensaje.charAt(k)), k, new Color(red,green,blue).getRGB());
            }
            
            File outputfile = new File("imagenes/fotoReady.jpg");
            ImageIO.write(img, "jpg", outputfile);
            rutaNueva = outputfile.getAbsolutePath();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        return rutaNueva;
    }
    
    public static String mostrar(String path)
    {
        String mensaje = "";
        
        BufferedImage img = null;
        String rutaNueva = null;
        try 
        {
            img = ImageIO.read(new File(path));
            for (int i = 0; i < img.getHeight();i++)
            {
                for(int j= 0; j < img.getWidth();j++)
                {
                    int rgb = img.getRGB(j, i);
                    
                    int blue= (rgb)    &0x0ff;
                    
                    if(blue%2 != 0)
                    {
                        mensaje += Character.toChars(j);
                    }
                    
                }
            }
            
        }
        catch(Exception e)
        {
            
        }
        
        return mensaje;
    }
}
