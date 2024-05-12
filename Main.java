/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.javawc.main;

import com.oracle.javawc.entities.shell.FileLoader;
import com.oracle.javawc.entities.shell.WordCount;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author lgomes
 */
public class Main {
    
    /**
     *
     */
    public static final Logger LOG = Logger.getLogger(Main.class.getName());
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        LOG.fine("Starting Main");
        if (args != null && args.length == 1)  {
            String path = args[0];
            
            FileLoader instance = new FileLoader();
            List<String> lines = instance.loadFile(path);
            WordCount wc = new WordCount();
            wc.showStatistics(lines);
        }
        else {
            System.out.println("Invalid parameter. Expecting 'wc <file>'");
        }
        LOG.fine("Finalizing Main");
    }
}
