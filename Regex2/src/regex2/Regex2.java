/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package regex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Regex2 {

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args){
        try {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter regular expression: ");
            String regex;
            String searchString = "";
            String searchStringTemp;
            regex = console.readLine();
            while (!regex.equalsIgnoreCase("exit")) {

                Pattern pattern = Pattern.compile(regex);
                
                System.out.println("Enter string to search: ");
                searchStringTemp = console.readLine();
                if (!searchStringTemp.equals(""))
                    searchString = searchStringTemp;
                else
                    System.out.println(searchString);
                Matcher matcher = pattern.matcher(searchString);

                boolean found = false;
                while (matcher.find()) {
                    System.out.println("found matching text '"+ matcher.group()+ "' starting at index " +matcher.start()+ " and ending at index "  +matcher.end());
                    found = true;
                }
                if(!found){
                    System.out.println("No match found for " + regex + " in " + searchString);
                }
                System.out.println("Enter regular expression: ");
                String temp;
                temp = console.readLine();
                if (!temp.equals(""))
                    regex = temp;
                else
                    System.out.println(regex);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
