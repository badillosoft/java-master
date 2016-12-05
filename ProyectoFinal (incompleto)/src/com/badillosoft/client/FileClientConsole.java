/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badillosoft.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Este programa solicita una llave del archivo a leer y
 * se conecta a un FileServer para leer los archivos, sin embargo,
 * no hace nada con ellos, sólo mostrar el porcentaje descargado del archivo
 * 
 * @author Alan Badillo Salas [badillo.soft@hotmail.com]
 * @version 1.0
 * @see com.badillosoft.server.FileServer
 */
public class FileClientConsole {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingresa A, B, C o D: ");
        
        String key = scanner.nextLine();
        
        System.out.println("@ Conectando al servidor...");
        Socket socket = new Socket("localhost", 3000);
        
        System.out.format("@ Recuperando el archivo %s%n", key);
        
        // Protocolo 1. Enviamos la llave del archivo a recuperar
        
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        out.writeUTF(key);
        
        // Protocolo 2. Leemos el tamaño del archivo
        DataInputStream in = new DataInputStream(socket.getInputStream());
        
        int size = in.readInt();
        
        System.out.format("@ Recuperando archivo de %d bytes...%n", size);
        
        int b;
        int c = 0;
        int ip = -1;
        
        for (int i = 0; i < size; i++) {
            // Calculamos el porcentaje de datos enviados
            int p = (int)(100 * c / (size - 1));
            
            // Si el porcentaje es distinto al anterior
            if (p != ip) {
                System.out.format("@ Recibiendo archivo <%s>: %d%%%n", key, p);
                ip = p;
            }
            
            c++;
            
            b = in.readByte();
            // Envíamos los bytes del archivo
            //System.out.format("%x ", b);
        }
        
        in.close();
        out.close();
        socket.close();
    }
}
