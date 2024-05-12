/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.javawc.entities.shell;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static java.util.function.Function.identity;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 *
 * @author lgomes
 */
public class WordCount {

    /**
     *
     * @param file
     * @throws IOException
     */
    public void run(String file) throws IOException {
        FileLoader fl = new FileLoader();
        List<String> lines = fl.loadFile(file);
        showStatistics(lines);
    }

    /**
     * 
     * @param file
     * @param cs
     * @throws IOException 
     */
    public void run(String file, Charset cs) throws IOException {
        FileLoader fl = new FileLoader();
        List<String> lines = fl.loadFile(file, cs);
        showStatistics(lines);
    }

    /**
     * 
     * @param lines 
     */
    public void showStatistics(List<String> lines) {
        countLines(lines);
        countWords(lines);
        countAvgLettersPerWords(lines);
        mostCommonLetter(lines);

    }

    /**
     * 
     * @param lines
     * @return 
     */
    public Long countLines(List<String> lines) {

        long totalLines = 0;
        if (lines != null && !lines.isEmpty()) {
            totalLines = lines.size();
        }

        System.out.println("Lines: " + totalLines);
        return totalLines;
    }

    
    /**
     * 
     * @param lines
     * @return 
     */
    public long countWords(List<String> lines) {

        long totalWords = 0;
        if (lines != null && !lines.isEmpty()) {

            totalWords = lines.stream()
                    .map(l -> l.trim().split("[\\s]"))                    
                    .flatMap(Arrays::stream)
                    .filter(l -> !l.trim().equals(""))
                    .count();
        }

        System.out.println("Words: " + totalWords);

        return totalWords;
    }

    /**
     * 
     * @param lines
     * @return 
     */
    public double countAvgLettersPerWords(List<String> lines) {

        double avg = 0.0;

        if (lines != null && !lines.isEmpty()) {

//            lines.stream()
//                    .map(w -> w.split("[\\s]")) //String[]
//                    .flatMap(Arrays::stream)
//                    .forEach(s ->System.out.println(s + " = "+s.length()));
            avg = lines.stream()
                    .map(w -> w.split("[\\s]")) //String[]
                    .flatMap(Arrays::stream)
                    .collect(Collectors.averagingDouble(s -> s.length()));
        }

        System.out.format("average letters per word: %.2f%n", avg);

        return avg;

    }

    /**
     * 
     * @param lines
     * @return 
     */
    public String mostCommonLetter(List<String> lines) {

        String mostCommonChar = "";
        Map.Entry<String, Long> mostCommon = null;

        if (lines != null && !lines.isEmpty()) {

            Map<String, Long> letterToCount
                    = lines.stream()
                    .map(w -> w.split(""))
                    .flatMap(Arrays::stream)
                    .filter(c -> !c.trim().isEmpty())
                    .collect(groupingBy(identity(), TreeMap::new, counting())); //TreeMap is used to sort the chars in the ascending order

            mostCommon = letterToCount.entrySet().stream()
                    .max(Map.Entry.comparingByValue(Long::compareTo))
                    .orElse(null);

//                    letterToCount.entrySet().stream()                    
//                    .forEach(s ->System.out.println("letter-->"+s));
        }

        if (mostCommon != null) {
            mostCommonChar = mostCommon.getKey();
            System.out.println("most common letter: " + mostCommonChar);
        }

        return mostCommonChar;

    }

}
