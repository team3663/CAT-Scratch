//curtis

//HAHA Angelique is ruining code with comments!

package twentyfourtyeight;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Twentyfourtyeight {
    public static File file = new File("HighScore.txt");
    public static final int HEIGHT = 4;
    public static final int WIDTH = 4;
    public static int[][] grid = new int[WIDTH][HEIGHT];
    public static int currentScore = 0;
    public static int highScore = 0;
    public static int turns = 0;
    public static Scanner sc = new Scanner(System.in);
    public static boolean stopLooping = false;
    public static boolean pairsLeft = true;
    
    public static void main(String[] args) throws IOException{
                AddNewNum();
        AddNewNum();
        Display();
        while (KeepGoing())
        {
            MoveAndMerge();
            AddNewNum();
            Display();
        }
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
                MMDown();
            }
            if((dir.contains("3")) || (dir.contains("left")) || (dir.contains("a")))
            {
                MMLeft();
            }
            if((dir.contains("4")) || (dir.contains("right")) || (dir.contains("d")))
            {
                MMRight();
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
    /*    do
        {*/
            for (int y = 0;y < HEIGHT;y++)
            {
                for (int x = 0;x < WIDTH;x++)
                {
                    if (grid[x][y] == 0)
                    {
                        for (int j = x;j < WIDTH;j++)
                        {
                            if (grid[j][y] != 0)
                            {
                                grid[x][y] = grid[j][y];
                                grid[j][y] = 0;
                                stopLooping = true;
                                break;
                            }
                        }
                    }
                    else if (x == WIDTH - 1 && y == HEIGHT - 1)
                    {
                        stopLooping = false;
                    }
                }
                for (int x = 0;x < WIDTH-1;x++)
                {
                    if (grid[x][y] == grid[x+1][y])
                    {
                        grid[x][y] = 2*grid[x][y];
                        currentScore += grid[x][y];
                        grid[x+1][y] = 0;
                        stopLooping = true;
                    }
                    else if (x == WIDTH - 2)//////KEEP WORKING FROM HERE
                    {
                        stopLooping = false;
                    }
                    for (int i = x+1;i < WIDTH-1;i++)
                    {
                        if (grid[i][y] != 0 && grid[x+1][y] == 0)
                        {
                            grid[x+1][y] = grid[i][y];
                            grid[i][y] = 0;
                            stopLooping = true;
                        }
                        else
                        {
                            stopLooping = false;
                        }
                    }
                }
            }
     /*       for (int y = 0;y < HEIGHT;y++)
            {
                for (int x = 0;x < WIDTH-1;x++)
                {
                    if (grid[x][y] == grid[x+1][y])
                    {
                        pairsLeft = true;
                        break;
                    }
                    else
                    {
                        pairsLeft = false;
                    }
                }
            }
        }while (pairsLeft);*/
    }
    public static void MMUp()
    {
        for (int x = 0;x < WIDTH;x++)
        {
            for (int y = 0;y < HEIGHT;y++)
            {
                if (grid[x][y] == 0)
                {
                    for (int j = y;j < HEIGHT;j++)
                    {
                        if (grid[x][j] != 0)
                        {
                            grid[x][y] = grid[x][j];
                            grid[x][j] = 0;
                            stopLooping = true;
                            break;
                        }
                        else
                        {
                            stopLooping = false;
                        }
                    }
                }
            }
            for (int y = 0;y < HEIGHT-1;y++)
            {
                if (grid[x][y] == grid[x][y+1])
                {
                    grid[x][y] = 2*grid[x][y];
                    grid[x][y+1] = 0;
                    stopLooping = true;
                }
                else
                {
                    stopLooping = false;
                }
                for (int i = y+1;i < HEIGHT;i++)
                {
                    if (grid[x][i] != 0 && grid[x][y+1] == 0)
                    {
                        grid[x][y+1] = grid[x][i];
                        grid[x][i] = 0;
                        stopLooping = true;
                        break;
                    }
                    else
                    {
                        stopLooping = false;
                    }
                }
            }
        }
        
    }
    public static void MMDown()
    {
        for (int x = 0;x < WIDTH;x++)
        {
            for (int y = HEIGHT-1;y >= 0;y--)
            {
                if (grid[x][y] == 0)
                {
                    for (int j = y;j >= 0;j--)
                    {
                        if (grid[x][j] != 0)
                        {
                            grid[x][y] = grid[x][j];
                            grid[x][j] = 0;
                            stopLooping = true;
                            break;
                        }
                        else
                        {
                            stopLooping = false;
                        }
                    }
                }
            }
            for (int y = HEIGHT-1;y > 0;y--)
            {
                if (grid[x][y] == grid[x][y-1])
                {
                    grid[x][y] = 2*grid[x][y];
                    grid[x][y-1] = 0;
                    stopLooping = true;
                }
                else
                {
                    stopLooping = false;
                }
                for (int j = y-1;j >= 0;j--)
                {
                    if (grid[x][y-1] == 0 && grid[x][j] != 0)
                    {
                        grid[x][y-1] = grid[x][j];
                        grid[x][j] = 0;
                        stopLooping = true;
                        break;
                    }
                    else
                    {
                        stopLooping = false;
                    }
                }
            }
        }
    }
    public static void MMRight()
    {
        for (int y = 0;y < HEIGHT;y++)
        {
            for (int x = WIDTH-1;x >= 0;x--)
            {
                if (grid[x][y] == 0)
                {
                    for (int j = x;j >= 0;j--)
                    {
                        if (grid[j][y] != 0)
                        {
                            grid[x][y] = grid[j][y];
                            grid[j][y] = 0;
                            stopLooping = true;
                            break;
                        }
                        else
                        {
                            stopLooping = false;
                        }
                    }
                }
            }
            for (int x = WIDTH-1;x > 0;x--)
            {
                if (grid[x][y] == grid[x-1][y])
                {
                    grid[x][y] = 2*grid[x][y];
                    grid[x-1][y] = 0;
                    stopLooping = true;
                }
                else
                {
                    stopLooping = false;
                }
                for (int i = x-1;i >= 0;i--)
                {
                    if (grid[i][y] != 0 && grid[x-1][y] == 0)
                    {
                        grid[x-1][y] = grid[i][y];
                        grid[i][y] = 0;
                        stopLooping = true;
                    }
                    else
                    {
                        stopLooping = false;
                    }
                }
            }
        }
    }
    public static void FileCreater(int passin)throws IOException
    {
        
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        String scoreintstring = "" + passin;
        writer.write(scoreintstring);
        writer.flush();
        writer.close();
    }
    public static void FileReader()
    {
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                highScore = sc.nextInt();
            }
            sc.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("ERROR: EEAII3492ISNGLK230");
            System.out.println("    File Not Found");
        }
    }
    public static void RecordScore()
    {
        
    }
    public static void CheckForFile()throws IOException
    {
       try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                highScore = sc.nextInt();
            }
            sc.close();
        }
        catch(FileNotFoundException e)
        {
            FileCreater(0);
        }
    }
}
        
    

