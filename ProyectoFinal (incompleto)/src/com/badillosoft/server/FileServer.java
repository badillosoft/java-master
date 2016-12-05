/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badillosoft.server;

import com.badillosoft.File;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase FileServer permite archivos los cuales se acceden por una llave.
 * Al inicializar la clase se instancia un servidor
 * que provee los archivos mediante sockets. La primer respuesta del
 * servidor será el tamaño del archivo en bytes. Seguido del archivo
 * enviado mediante un BuffedInputStream. Al instanciar la clase
 * se leerán los archivos para comprobar si existen o se generará
 * un error. El tamaño de los archivos es calculado cada que se
 * cambia el path del archivo nombrado.
 * 
 * @author Alan Badillo Salas [badillo.soft@hotmail.com]
 * @version 1.0
 * @see com.badillosoft.File
 * 
 */
public final class FileServer extends Thread {

    // Creamos un diccionario de objetos con la información de los archivos
    // Un objeto File contiene path, size y los métodos para leer el archivo
    private Dictionary<String, File> files = new Hashtable();
    
    // Instancia del servidor socket
    private ServerSocket server;
    
    /**
     * Instancia un nuevo servidor de archivos
     * con el puerto donde será montado el servidor.
     * 
     * @param port el puerto del servidor socket
     * @throws IOException si el servidor no puede ser montado
     */
    public FileServer(int port) throws IOException {
        this.server = new ServerSocket(port);
    }
    
    /**
     * Devuelve un com.badillosoft.File con la información del 
     * archivo en la llave dada
     * @param key la llave del archivo asociado
     * @return el archivo asociado a la llave
     */
    public File getFile(String key) {
        return files.get(key);
    }
    
    /**
     * Guarda un com.badillosoft.File
     * @param key llave del archivo a guardad
     * @param file archivo a guardar
     */
    public void setFile(String key, File file) {
        files.put(key, file);
    }
    
    /**
     * @return el servidor instanciado
     */
    public ServerSocket getServer() {
        return server;
    }

    /**
     * @param server ajusta el servidor por si se desea cambiar
     */
    public void setServer(ServerSocket server) {
        this.server = server;
    }
    
    /**
     * Ejecuta la rutina de obtener clientes y procesarlos
     */
    @Override
    public void run() {
        while (true) {
            // Obtenemos al cliente
            Socket client = null;
            try {
                // TODO: Aceptar al cliente
                // Hint: usa algún métodos de this.server para aceptarlo
            } catch (IOException ex) {
                Logger.getLogger(FileServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                this.nextClient(client);
            } catch (IOException ex) {
                Enumeration<File> it = this.files.elements();
                
                while (it.hasMoreElements()) {
                    File file = it.nextElement();
                    
                    file.setProgress(0);
                }
            }
        }
    }
    
    /**
     * Muestra un mensaje en la consola
     * @param message el mensaje a mostrar
     */
    public void log(String message) {
        System.out.println(message);
    }
    
    /**
     * Procesa el siguiente cliente aceptado siguiendo el protocolo de
     * comunicación establecido.
     * 
     * Protocolo de comunicación:
     * 1. El cliente envia la clave del archivo que desea leer
     * 2. El servidor responde con el tamaño del archivo
     * 3. El servidor responde con el archivo
     * 
     * @param client cliente aceptado
     * @throws IOException si el cliente genera un error a su entrada o salida
     */
    public void nextClient(Socket client) throws IOException {
        log(String.format("@ Procesando cliente..."));
        // Obtenemos el stream de entrada del cliente
        DataInputStream in = new DataInputStream(
            client.getInputStream()
        );
        
        // Obtenemos el stream de salida del cliente
        // TODO: Recupera un DataOutputStream llamado `out` a partir
        // del stream de salida del cliente
        // Hint: es similar al DataInputStream anterior
        
        // Protocolo de comunicación:
        // 1. El cliente envia la clave del archivo que desea leer
        // 2. El servidor responde con el tamaño del archivo
        // 3. El servidor responde con el archivo
        
        // Leemos la clave del archivo solicitado del cliente
        //String key = ??;// TODO: Lee del input stream la llave con el método readUTF()
        
        File file = this.getFile(key);
        
        if (file == null) {
            log(String.format("@ Error: La clave <%s> solicitada no existe", key));
            client.close();
            return;
        }
        
        if (file.getPath() == null) {
            log(String.format("@ Error: no se ha definido el path <%s>", key));
            client.close();
            return;
        }
        
        // Recuperamos el tamaño del archivo
        int size = file.getSize();
        
        // Protocolo 1. Le enviamos al cliente el tamaño del archivo
        log(String.format("@ Enviando tamaño de archivo <%s>: %d",
            key, size));
        
        // Eviamos el tamaño del archivo al cliente (Protocolo 1)
        out.writeInt(size);
        
        // Protocolo 2. Le enviamos al cliente el archivo
        
        // Leemos el stream de entrada del archivo fisíco
        BufferedInputStream fileStream = file.getStream();
        
        // b guarda el byte actual
        // c cuenta el número actual de bytes enviados
        int b;
        int c = 0;
        int ip = -1;
        
        // Leemos cada byte del archivo
        for (int i = 0; i < size; i++) {
            b = fileStream.read();
            
            // Envíamos los bytes del archivo al cliente (Protocolo 3)
            //out.writeByte((byte)b); // TODO: Descomenta esta linea
            
            // Calculamos el porcentaje de datos enviados
            // TODO: Revisa como se calcula el porcentaje `p`
            // en el archivo com.badillosoft.FileUI
            
            // Actualizamos el progreso del archivo
            // TODO: Llama al método file.setProgress(p);
            
            // Si el porcentaje es distinto al anterior
            if (p != ip) {
                log(String.format("@ Enviando archivo <%s>: %d%%", key, p));
                ip = p;
            }
            
            c++;
        }
        
        // Reestablecemos el progreso del archivo
        file.setProgress(0);
        
        // Cerramos los streams y al cliente
        in.close();
        out.close();
        fileStream.close();
        client.close();
    }
    
    /**
     * Programa de ejemplo: Crea en la terminal un FileServer que provee
     * 4 archivos con las llaves A, B, C y D y las rutas dadas.
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        FileServer fs = new FileServer(3000);
        
        String keys[] = new String[] { "A", "B", "C", "D" };
        String paths[] = new String[] {
            "/Users/alan/Desktop/a.txt",
            "/Users/alan/Desktop/b.txt",
            "/Users/alan/Desktop/c.txt",
            "/Users/alan/Desktop/d.txt"
        };
        
        for (int i = 0; i < 4; i++) {
            String key = keys[i];
            String path = paths[i];
            
            fs.setFile(key, new File(path));
            
            File file = fs.getFile(key);
            
            System.out.format("Archivo %s: %s | Tamaño: %d%n",
                key, file.getPath(), file.getSize());
        }
        
        // Ejecutamos el FileServer sin usar hilos (directamente run)
        fs.run();
    }
    
}
