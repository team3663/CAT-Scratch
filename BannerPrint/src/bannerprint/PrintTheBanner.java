package bannerprint;

import java.util.Scanner;

public class PrintTheBanner {
    Scanner KB = new Scanner(System.in);
    final char FIRSTCHARACTER = 'A';
    String[][] characters = new String[][]{
        {"   A   ","BBBB "," CCC ","DDDD ","EEEEE","FFFFF"," GGG ","H   H","IIIII","JJJJJ","K   K","L    ","M     M","N   N"," OOO ","PPPP "," QQQ ","RRRR "," SSSS","TTTTT","U   U","VVVVV","WWWWW","X   X","Y   Y","ZZZZZ"},
        {"  A A  ","B   B","C   C","D   D","E    ","F    ","G    ","H   H","  I  ","  J  ","K  K ","L    ","M M M M","N N N","O   O","P   P","Q   Q","R   R","S    ","  T  ","U   U","VVVVV","WWWWW"," X X "," Y Y ","   Z "},
        {"  AAA  ","BBBB ","C    ","D   D","EEE  ","FFF  ","G  GG","HHHHH","  I  ","  J  ","KKK  ","L    ","M  M  M","N  NN","O   O","PPPPP","Q   Q","RRRR "," SSS ","  T  ","U   U","VVVVV","WWWWW","  X  ","  Y  ","  Z  "},
        {" A   A ","B   B","C   C","D   D","E    ","F    ","G   G","H   H","  I  ","J J  ","K  K ","L    ","M     M","N   N","O   O","P    ","Q  QQ","R   R","    S","  T  ","U   U","VVVVV","WWWWW"," X X ","  Y  "," Z   "},
        {"A     A","BBBB "," CCC ","DDDD ","EEEEE","F    "," GGG ","H   H","IIIII"," J   ","K   K","LLLLL","M     M","N   N"," OOO ","P    "," QQQQ","R   R","SSSS ","  T  "," UUU ","VVVVV","WWWWW","X   X","  Y  ","ZZZZZ"}};
    
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