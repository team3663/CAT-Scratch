package bannerprint;

import java.util.Scanner;

public class PrintTheBanner {
    Scanner KB = new Scanner(System.in);
    final char FIRSTCHARACTER = 'A';
    String[][] characters = new String[][]{
        {"   A   ","BBBB "},
        {"  A A  ","B   B"},
        {"  AAA  ","BBBB "},
        {" A   A ","B   B"},
        {"A     A","BBBB "}};
    
    public void printIt(){
        String inputString;
        String[] banner = new String[characters.length];
        
        do {
            System.out.println("Enter string to be \"Bannerized\" (empty line will exit)");
            inputString = KB.nextLine();

            if (inputString.length()>0){
                for (int i=0; i<banner.length; i++){
                    banner[i]="";
                }

                for (int j=0; j<inputString.length(); j++){

                    int letterIndex = inputString.charAt(j)-FIRSTCHARACTER;

                    if (letterIndex < characters[0].length){
                        for (int i=0; i<banner.length; i++){
                            banner[i]+=characters[i][letterIndex]+" ";
                        }
                    } else {
                        System.out.println(inputString.charAt(j)+" is an unsupported character. Ask Garret to expand support");
                    }
                }
                for (int i=0; i<banner.length; i++){
                    System.out.println(banner[i]);
                }
            }
        }while (inputString.length()>0);
        
        System.out.println("Goodbye");        
    }
}