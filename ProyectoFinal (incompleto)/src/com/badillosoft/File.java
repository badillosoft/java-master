/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badillosoft;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * La clase File guarda la información de un archivo
 * su path, el tamaño del archivo y el progreso leído (actualizado manualmente).
 * Un archivo calcula el tamaño en bytes del archivo cada que se cambia el path
 * o se inicializa con un path específico.
 * También posee un método para abrir el stream del archivo.
 * 
 * @author Alan Badillo Salas [badillo.soft@hotmail.com]
 * @version 1.0
 * 
 */
public class File {
    
    // Ruta física del archivo
    private String path;
    
    // Tamaño en bytes del archivo
    private int size;
    
    // Porcentaje del archivo leído (ajustado manualmente)
    private int progress;
    
    public File() {}
    
    public File(String path) throws IOException {
        this.setPath(path);
    }

    /**
     * Obtiene la ruta física del archivo
     * @return ruta física del archivo
     */
    public String getPath() {
        return path;
    }

    /**
     * Ajusta la ruta física del archivo, si este existe y actualiza el tamaño
     * @param path ruta física del archivo
     * @throws java.io.IOException si el archivo no se puede leer
     */
    public void setPath(String path) throws IOException {
        this.size = File.getFileSize(path);
        this.path = path;
    }

    /**
     * Obtiene el tamaño en bytes del archivo
     * @return el tamaño en bytes del archivo
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Actualiza el porcentaje leído del archivo
     * @param progress 
     */
    public void setProgress(int progress) {
        this.progress = progress;
    }
    
    /**
     * Obtiene el Stream del archivo
     * @return el BufferedInputStream del archivo leído
     * @throws FileNotFoundException si el archivo no existe
     */
    public BufferedInputStream getStream() throws FileNotFoundException {
        // TODO: Devolver un BufferedInputStream llamado `in` a 
        // partir del path del archivo.
        // Hint: usar this.getPath() y FileInputStream
        
        return in;
    }
    
    /**
     * @param path ruta física del archivo a calcular su tamaño en bytes
     * @return el número de bytes del archivo
     * @throws FileNotFoundException si el archivo no existe
     * @throws IOException si falla leer el archivo
     */
    public static int getFileSize(String path)
        throws FileNotFoundException, IOException {
        
        BufferedInputStream in = new BufferedInputStream(
            new FileInputStream(path)
        );
        
        int size = 0;
        
        // TODO: Leer los bytes del stream `in` y guardarlos en size
        // Hint: usa un ciclo while() y lee cada byte usando in.read()
        // recuerda que si el byte leido es -1 el stream terminó.
        
        in.close();
        
        return size;
    }
    
}
