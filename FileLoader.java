/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.javawc.entities.shell;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Load a file into memory for further processing
 * @author lgomes
 */
public class FileLoader {

    /**
     * Default constructor
     */
    public FileLoader() {

    }
    
    /**
     *
     * @param fileURL
     * @param charset
     * @return
     * @throws IOException
     */
    public List<String> loadFile(String fileURL, Charset charset) throws IOException {
        File f = new File(fileURL);
        if (f.isFile() && f.canRead()) {
            return loadFile(f.toPath(), charset);
        }
        else {
            throw new IOException("Cannot read file "+fileURL);
        }
        
    }
    
    /**
     *
     * @param fileURL
     * @return
     * @throws IOException
     */
    public List<String> loadFile(String fileURL) throws IOException {
        File f = new File(fileURL);
        if (f.isFile() && f.canRead()) {
            return loadFile(f.toPath());
        }
        else {
            throw new IOException("Cannot read file "+fileURL);
        }
    }

    /**
     * Load a file into memory
     * @param path
     * @return
     * @throws IOException 
     */
    public List<String> loadFile(Path path) throws IOException {                
        return Files.readAllLines(path);
    }

    /**
     * Load a file into memory based on the specified Charset
     * @param path
     * @param cs
     * @return
     * @throws IOException 
     */
    public List<String> loadFile(Path path, Charset cs) throws IOException {        
        return Files.readAllLines(path, cs);
    }
        
}
