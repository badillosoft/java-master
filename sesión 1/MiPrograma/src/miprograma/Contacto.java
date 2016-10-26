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
public class Contacto {
    
    public String Nombre;
    public String Telefono;
    
    public Contacto(String nombre, String telefono) {
        this.Nombre = nombre;
        this.Telefono = telefono;
    }
    
    public String descripcion() {
        return String.format("%s (%s)", this.Nombre, this.Telefono);
    }
    
    public static void main(String[] args) {
//        Contacto c = new Contacto("Ash", "5512345678");
//        System.out.println(c.descripcion());

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Buscar contacto");
            System.out.println("2. Agregar contacto");
            System.out.println("3. Modificar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");
            System.out.println(":> ");
            
            int op = sc.nextInt();
            
            if (op == 5) {
                break;
            }
        }
    }
    
}
