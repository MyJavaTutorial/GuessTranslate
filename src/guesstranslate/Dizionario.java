/*
 * Dizionario.java: implementa una classe wrapper di una 
 * matrice di stringhe n*2.
 */

package guesstranslate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3Ai
 */
public class Dizionario {
    
    String[][] d;   // la matrice di strighe che contiene il dizionario

    public Dizionario(String csvFileName) {
        int lines = contaRigheFile(csvFileName);
        d = new String[lines][2];
        caricaDizionario(csvFileName);
    }
    
    private int contaRigheFile(String filename) {
        int count=0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bfr = new BufferedReader(fr);
            while (bfr.ready()) {
                bfr.readLine();
                count++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Dizionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    private void caricaDizionario(String csvFileName) {
        int numRiga=0;
        try {
            BufferedReader bfr = new BufferedReader( new FileReader(csvFileName) );
            while(bfr.ready()) {
                String s = bfr.readLine();
                String[] csv = s.split(";");
                if (csv.length!=2) {
                    System.out.println("AHAHAHAHAHAHAHAHAHAHAHAHAHAHAHA!!!!!!!!!!!");
                    System.exit(-1);
                }
                d[numRiga][0] = csv[0];
                d[numRiga][1] = csv[0];
                numRiga++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Dizionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
