/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase_1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Aula E5
 */
public class Abecedario {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileWriter out = new FileWriter("C:\\test\\salida.txt", true);
        
        for (int c = 65; c < 91; c++) {
            out.write(c);
        }
        
        out.close();
    }
    
}
