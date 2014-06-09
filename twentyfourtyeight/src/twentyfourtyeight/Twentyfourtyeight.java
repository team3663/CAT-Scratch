
package twentyfourtyeight;

import java.util.Random;

public class Twentyfourtyeight {
    public static final int HEIGHT = 4;
    public static final int WIDTH = 4;
    public static int[][] grid = new int[WIDTH][HEIGHT];
    public static int currentScore = 0;
    public static int highScore = 0;
    public static int turns = 0;
    
    public static void main(String[] args) {
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[0][2] = 3;
        grid[0][3] = 4;
        grid[1][0] = 5;
        grid[1][1] = 6;
        grid[1][2] = 7;
        grid[1][3] = 8;
        grid[2][0] = 9;
        grid[2][1] = 10;
        grid[2][2] = 11;
        grid[2][3] = 12;
        grid[3][0] = 14;
        grid[3][1] = 14;
        grid[3][2] = 15;
        grid[3][3] = 20;
        Display();
        if(!KeepGoing())
        {
            System.out.println("this is madness");
        }
        else
        {
            //AddNewNum();
            System.out.println("lalalala");
        }
        Display();
        
    }
    public static void Display()
    {
        for(int y = 0; y < HEIGHT; y++)
        {
            for(int i = 0; i < WIDTH; i ++){System.out.print("+-----");}
            System.out.print("+");
            System.out.println("");
            for(int x = 0; x < WIDTH; x ++)
            {
                System.out.print("|" + CorrectSpacing(grid[x][y]));
            }
            System.out.print("|");
            if(y ==0)
            {
                System.out.print("\t Current Score : " + currentScore);
            }
            else if(y == 1)
            { 
                System.out.print("\t High Score    : " + highScore);
            }
            else if(y == 2)
            { 
                System.out.print("\t Turns Used    : " + turns);
            }
            System.out.println("");
            
        }
        for(int i = 0; i < WIDTH; i ++){System.out.print("+-----");}
        System.out.println("+");
    }
    public static String CorrectSpacing(int pValue)
    {
        if(pValue == 0){return "     ";}
        else if(pValue < 10){return "    " + pValue;}
        else if(pValue < 100){return "   " + pValue;}
        else if(pValue < 1000){return "  " + pValue;}
        return " " + pValue;
    }
    public static void AddNewNum()
    {
        int openspace = 0;
        for(int y = 0; y < HEIGHT; y++)
        {
            for(int x = 0; x < WIDTH; x ++){
                if ((grid[x][y] == 0)){
                    openspace++;
                }
            }
        }
        Random rand = new Random();
        int r = rand.nextInt(openspace);
        for(int y = 0; y < HEIGHT; y++)
        {
            for(int x = 0; x < WIDTH; x ++){
                if(grid[x][y] == 0)
                {
                    if (r == 0){
                        grid[x][y] = SemiRandomTwoOrFour();
                        return;
                    }
                    r--;
                }
            }
        }
    }
    public static int SemiRandomTwoOrFour()
    {
        Random rand = new Random();
        int r = rand.nextInt(10);
        System.out.println("number is " + r);
        if(r < 9)
        {
            return 2;
        }
        return 4;  
    }
    public static boolean KeepGoing()
    {
        for(int x = 0; x < WIDTH; x++)
        {
            for(int y = 0; y< HEIGHT; y++)
            {
                if(grid[x][y] == 0)
                {
                    return true;
                }
                if(x +1 < WIDTH)
                {
                    if(grid[x][y] == grid[x + 1][y])
                    {
                        return true;
                    }
                }
                if(y + 1 < HEIGHT)
                {
                    if(grid[x][y] == grid[x][y + 1])
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
