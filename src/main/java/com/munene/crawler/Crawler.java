/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.munene.crawler;

/**
 *
 * @author munene
 */
import java.net.*;
import java.util.List;
import java.util.Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Crawler {

    public static void main(String[] args) {
        try {

            // Fetching URL by creating
            URL url = new URL(
                    "https://www.geeksforgeeks.org/java");

            URLConnection urlcon = url.openConnection();

            Map<String, List<String>> header
                    = urlcon.getHeaderFields();

            // Printing all the fields along with their
            // value
            for (Map.Entry<String, List<String>> mp
                    : header.entrySet()) {
                System.out.print(mp.getKey() + " : ");
                System.out.println(
                        mp.getValue().toString());
            }

            System.out.println();
            System.out.println(
                    "Complete source code of the URL is-");
            System.out.println(
                    "---------------------------------");

            // Getting the inputstream of the open
            // connection
            BufferedReader br
                    = new BufferedReader(new InputStreamReader(
                            urlcon.getInputStream()));
            String i;

            // Printing the source code line by line
            while ((i = br.readLine()) != null) {

                if (i.contains("a href=")) {
                    System.out.println(i.trim() + '\n');
                }

            }
        } // Catch block to handle exceptions
        catch (Exception e) {

            // Displaying exceptions
            System.out.println(e);
        }
    
    }
}
