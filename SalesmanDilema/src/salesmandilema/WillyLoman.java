package salesmandilema;

public class WillyLoman implements TSP{
    public String description (){return "Willy Loman";}
    public int[] solveIt(int[][] cityDistances){
        int numberOfCities = cityDistances[0].length;
        int[] sol = new int[numberOfCities+1];
        int temp;
        int farthest = 0;
        int farthestC = 0;
        
        for (int i = 0; i < numberOfCities; i++)
        {
            for (int j = 1+i; j < numberOfCities; j++)
            {
                if (cityDistances[i][j] > farthest)
                {
                        farthest = cityDistances[i][j];
                        farthestC = i;
                }
            }
        }
        for (int i = 0; i < numberOfCities; i++)
        {
            sol[i] = i;
        }
        sol[0] = farthestC;
        sol[farthestC] = 0;
        
        for (int i = 0; i < numberOfCities-1; i++){
            for (int j = 1+i; j < numberOfCities-i; j++)
            {
                if (cityDistances[sol[i]][sol[i+1]] > cityDistances[sol[i]][sol[j]])
                {
                    temp = sol[i+1];
                    sol[i+1] = sol[j];
                    sol[j] = temp;
                }
            }
        }
        sol[numberOfCities] = sol[0];
        return sol;
    }
}
