package salesmandilema;

public class WillyLoman {
    public int[] solveIt(int numberOfCities, int[][] cityDistances){
        int[] sol = new int[numberOfCities];
        int temp;
        
        for (int i = 0; i < numberOfCities-1; i++){
            for (int j = 0; j < 6; j++)
            {
                if (cityDistances[sol[i]][sol[i+1]] > cityDistances[sol[i]][sol[j]])
                {
                    temp = sol[i+1];
                    sol[i+1] = sol[j];
                    sol[j] = temp;
                }
            }
        }
        
        return sol;
    }
}
