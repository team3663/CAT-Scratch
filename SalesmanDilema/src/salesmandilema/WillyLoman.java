package salesmandilema;

public class WillyLoman {
    public int[] solveIt(int[][] cityDistances){
        int numberOfCities = cityDistances[0].length;
        int[] sol = new int[numberOfCities];
        int temp;
        int farthest = 0;
        int farthestC = 0;
        
        for (int i = 0; i < numberOfCities; i++)
        {
            sol[i] = i;
        }
        for (int i = 0; i < numberOfCities; i++)
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
        }
        
        for (int i = 0; i < numberOfCities-1; i++){
            for (int j = 1; j < numberOfCities-i; j++)
            {
                if (cityDistances[sol[i]][sol[i+1]] > cityDistances[sol[i]][sol[i+j]])
                {
                    temp = sol[i+1];
                    sol[i+1] = sol[i+j];
                    sol[i+j] = temp;
                }
            }
        }
        
        return sol;
    }
}
