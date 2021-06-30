/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pre_aed_ut1_manejoficherosiii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Leslie J. HL
 */
public class ReadFilex {
    
    public static String read(File file){
        String text = "";
        try {
            FileReader fR = new FileReader(file);
            BufferedReader bR = new BufferedReader(fR);
            String line = "";
            
            
            while((line = bR.readLine())!=null){
                text += line + "\n"; 
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return text;
    }
}
