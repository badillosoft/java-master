/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Aula E5
 */
public class Clase_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        FileInputStream in = new FileInputStream("C:\\test\\archivo.txt");
        
        int c;
        
        while ((c = in.read()) != -1) {
            System.out.format("%x ", c);
        }
        
        in.close();
    }
    
}
