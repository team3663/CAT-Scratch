
package twentyfourtyeight;

import java.util.Random;
import java.util.Scanner;

public class Twentyfourtyeight {
    public static final int HEIGHT = 4;
    public static final int WIDTH = 4;
    public static int[][] grid = new int[WIDTH][HEIGHT];
    public static int currentScore = 0;
    public static int highScore = 0;
    public static int turns = 0;
    public static Scanner sc = new Scanner(System.in);
    public static boolean stopLooping = false;
    
    public static void main(String[] args) {
        grid[0][0] = 2;
        grid[0][1] = 0;
        grid[0][2] = 0;
        grid[0][3] = 2;
        grid[1][0] = 0;
        grid[1][1] = 0;
        grid[1][2] = 2;
        grid[1][3] = 0;
        grid[2][0] = 0;
        grid[2][1] = 0;
        grid[2][2] = 2;
        grid[2][3] = 0;
        grid[3][0] = 0;
        grid[3][1] = 2;
        grid[3][2] = 0;
        grid[3][3] = 0;
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
        AddNewNum();
        Display();
        MoveAndMerge();
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
    //comment to test github push
    public static void MoveAndMerge()
    {
        do
        {
            System.out.println("1: Up,    w\n2: Down,  s\n3: Left,  a\n4: Right, d");
            String dir = sc.nextLine();
            dir = dir.toLowerCase();
            if((dir.contains("1")) || (dir.contains("up")) || (dir.contains("w")))
            {
                MMUp();
            }
            if((dir.contains("2")) || (dir.contains("down")) || (dir.contains("s")))
            {
            }
            if((dir.contains("3")) || (dir.contains("left")) || (dir.contains("a")))
            {
            }
            if((dir.contains("4")) || (dir.contains("right")) || (dir.contains("d")))
            {
            }
        }while(stopLooping == false);
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
    public static void MMLeft()
    {
        for (int y = 0;y < 4;y++)
        {
            for (int x = 0;x < 4;x++)
            {
                if (grid[x][y] == 0)
                {
                    for (int j = x;j < 4;j++)
                    {
                        if (grid[x][j] != 0)
                        {
                            grid[x][y] = grid[x][j];
                            grid[x][j] = 0;
                            stopLooping = true;
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void MMUp()
    {
        for (int x = 0;x < 4;x++)
        {
            for (int y = 0;y < 4;y++)
            {
                if (grid[x][y] == 0)
                {
                    for (int j = y;j < 4;j++)
                    {
                        if (grid[x][j] != 0)
                        {
                            grid[x][y] = grid[x][j];
                            grid[x][j] = 0;
                            stopLooping = true;
                            break;
                        }
                    }
                }
            }
            for (int y = 0;y < 3;y++)
            {
                if (grid[x][y] == grid[x][y+1])
                {
                    grid[x][y] = 2*grid[x][y];
                    grid[x][y+1] = 0;
                    for (int i = y + 1;i < 3;i++)
                    {
                        grid[x][i] = grid[x][i+1];
                        grid[x][i+1] = 0;
                        stopLooping = true;
                    }
                }
            }
        }
        
    }
    public static void MMDown()
    {
        
    }
    public static void MMRight()
    {
        
    }
}
