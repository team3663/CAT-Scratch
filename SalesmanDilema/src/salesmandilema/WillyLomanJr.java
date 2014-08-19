/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package salesmandilema;

/**
 *
 * @author Angelique
 */
public class WillyLomanJr {
    public int[] solveIt(int[][] cityDistances){
        int numberOfCities = cityDistances[0].length;
        int[] sol = new int[numberOfCities+1];
        int temp;
        int farthest = 0;
        int farthestC = 0;
        int[] nearestD = new int[numberOfCities];
        int[] sndNearestD = new int[numberOfCities];
        
        for (int i = 0; i < numberOfCities; i++)
        {
            sol[i] = i;
            nearestD[i] = 1000;
            sndNearestD[i] = 1000;
        }
        //store the closest distances for each city & 2nd Nearest
        for (int i = 0; i < numberOfCities; i++)
        {
            for (int j = 1; j < numberOfCities; j++)
            {
                if (cityDistances[i][j] < nearestD[i] && cityDistances[i][j] != 0)
                {
                    nearestD[i] = cityDistances[i][j];
                }
            }
        }
        for (int i = 0; i < numberOfCities; i++)
        {
            for (int j = 1; j < numberOfCities; j++)
            {
                if (cityDistances[i][j] > nearestD[i] && 
                    cityDistances[i][j] < sndNearestD[i])
                {
                    sndNearestD[i] = cityDistances[i][j];
                }
            }
        }
        //put the most remote city in the beginning down under here (if we want it)
        //-----------
        sol[numberOfCities] = sol[0];
        //following is code to order the cities
        for (int i = 0; i < numberOfCities; i++)
        {
            for (int j = 1+i; j < numberOfCities; j++)
            {
                if (cityDistances[i][j] == nearestD[i])
                {
                    temp = sol[i+1];
                    sol[i+1] = sol[j];
                    sol[j] = temp;
                    temp = nearestD[i];
                    nearestD[i] = nearestD[i+1];
                    nearestD[i+1] = temp;
                    temp = sndNearestD[i];
                    sndNearestD[i] = sndNearestD[i+1];
                    sndNearestD[i+1] = temp;
                }
                else if (i != 0 && cityDistances[i][j] == sndNearestD[i] && sndNearestD[i] < sndNearestD[i-1] && j == numberOfCities-1)
                {
                     i = i-1;
                     for (int k = i+1; k < numberOfCities; k++)
                     {
                         if (cityDistances[i][k] == sndNearestD[i])
                         {
                             temp = sol[i];
                             sol[i] = sol[k];
                             sol[k] = temp;
                             temp = nearestD[i];
                             nearestD[i] = nearestD[k];
                             nearestD[k] = temp;
                             temp = sndNearestD[i];
                             sndNearestD[i] = sndNearestD[k];
                             sndNearestD[k] = temp;
                         }
                     }
                }
            }
        }
        sol[numberOfCities] = sol[0];
        return sol;
    }
}
//code for putting the farthest city first
/*  for (int i = 0; i < numberOfCities; i++)
        {
            for (int j = 1; j < numberOfCities-1; j++)
            {
                if (cityDistances[sol[i]][sol[j]] > cityDistances[sol[i]][sol[j+1]])
                {
                    if (cityDistances[sol[i]][sol[j]] > farthest)
                    {
                        farthest = cityDistances[sol[i]][sol[j]];
                        farthestC = sol[j];
                    }
                }
                else
                {
                    if (cityDistances[sol[i]][sol[j+1]] > farthest)
                    {
                        farthest = cityDistances[sol[i]][sol[j+1]];
                        farthestC = sol[j+1];
                    }
                }
            }
        }
        for (int i = 0; i < numberOfCities; i++)
        {
            if (farthestC == i)
            {
                temp = sol[0];
                sol[0] = sol[i];
                sol[i] = temp;
            }
        }*/