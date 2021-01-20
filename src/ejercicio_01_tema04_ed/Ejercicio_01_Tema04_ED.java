/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_01_tema04_ed;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author francis
 */
public class Ejercicio_01_Tema04_ED 
{
    private static byte[] controlador = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream Corriente = null;
    private static BufferedInputStream entradaControlador = null;

    public static void inicializateFiles() throws FileNotFoundException
    {
        Corriente = new FileInputStream(nombreArchivo);
        entradaControlador = new BufferedInputStream(Corriente);
    }
    
    public static int showFileText() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = Corriente.read(controlador)) != -1) 
        {
            System.out.println(new String(controlador));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializateFiles();
            
            int total = showFileText();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( entradaControlador != null && Corriente != null )
                {
                    Corriente.close();
                    entradaControlador.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
