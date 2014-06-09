
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
    public static String dir;
    
    public static void main(String[] args) {
        grid[0][0] = 2;
        grid[0][2] = 2;
        grid[1][1] = 2;
        grid[1][3] = 2;
        grid[2][0] = 2;
        grid[2][2] = 2;
        grid[3][1] = 2;
        grid[3][3] = 2;
        Display();
        AddNewNum();
        Display();
        moveAndMerge();
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
    public static void moveAndMerge()
    {
        dir = sc.next();
        do
        {
            switch(dir)
            {
           /*     case "a":
                    mMLeft();
                    break;*/
                case "w":
                    mMUp();
                    break;
         /*       case "s":
                    mMDown();
                    break;
                case "d":
                    mMRight();
                    break;*/
            }
        }while(stopLooping == false);
    }
    public static void mMUp()
    {
        for (int y = 0;y < 4;y++)
        {
            for (int x = 0;x < 4;x++)
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
       /*     for (int x = 1;x < 4;x++)
            {
                if (grid[x-1][y] == grid[x][y])
                {
                    grid[x-1][y] = 2*grid[x][y];
                    grid[x][y] = 0;
                }
            }
     /*       for (int x = 0;x < 4;x++)
            {
                for (int compareNum = 1;compareNum < 4;compareNum++)
                {
                    if (grid[x][y] == grid[x][compareNum])
                    {
                        grid[x][y] = 2*grid[x][y];
                        grid[x][compareNum] = 0;
                        for (int i = compareNum;i < 4;i++)
                        {
                            if (grid[x][i] != 0)
                            {
                                grid[x][compareNum] = grid[x][i];
                                grid[x][i] = 0;
                                if (compareNum < 3)
                                {
                                    compareNum++;
                                }
                                break;
                            }
                        }
                        stopLooping = true;
                    }
                }
            }*/
        }
        /*temp not using & remember code below is for mMUp()
        for (int y = 0;y < 4;y++)
        {
            if (grid[y][0] == 0)
            {
                while (grid[y][0] == 0)
                {
                    for (int m = 1;m < 4;m++)
                    {
                        if (grid[y][m] > 0)
                        {
                            grid[y][0] = grid[y][m];
                            grid[y][m] = 0;
                        }
                    }
                }
            }
            for (int i = 1;i < 4;i++)
            {
                if (grid[y][0] == grid[y][i])
                {
                    grid[y][0] = 2*grid[y][0];
                    grid[y][i] = 0;
                    stopLooping = true;
                }
                else
                {
                    for (int j = i;j < 4;j++)
                    {
                        if (grid[y][j] == 0)
                        {
                            grid[y][j] = grid[y][i];
                            grid[y][i] = 0;
                            stopLooping = true;
                            break;
                        }
                    }
                }
            }
        }
        */
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
}
   /* public void mMLeft()
    {
        
    }
    public void mMDown()
    {
        
    }
    public void mMRight()
    {
        
    }
}*/
