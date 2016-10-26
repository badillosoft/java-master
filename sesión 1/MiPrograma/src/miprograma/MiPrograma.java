/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miprograma;

import java.util.Scanner;

/**
 *
 * @author Aula E5
 */
public class MiPrograma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.print("Ingresa un número: ");
            try {
                int result = sc.nextInt();
                System.out.format("Entrada: %d %n", result);
            } catch(Exception e) {
                System.out.println("El número no es entero");
                break;
            }
        } while (sc.hasNext());
        
        System.out.println("Hola mundo");
    }
    
}
