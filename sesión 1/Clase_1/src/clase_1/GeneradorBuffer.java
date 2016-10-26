/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase_1;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Aula E5
 */
public class GeneradorBuffer {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileOutputStream out = new FileOutputStream("C:\\test\\big2.txt");
        
        BufferedOutputStream bout = new BufferedOutputStream(out);
        
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 1000; j++) {
                bout.write(65);
            }
        }
        
        bout.close();
        out.close();
    }
}
