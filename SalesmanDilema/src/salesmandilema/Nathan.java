package salesmandilema;

public class Nathan implements TSP{

    int mostIsolatedDist, isolatedDist;
    int closestCity, nextClosestCity;
    int mostIsolCity;
    int maxDist, minDist;

    public String description (){return "Nathan";}
    
    public int[] solveIt(int[][] cityDistances){
        
    int numberOfCities = cityDistances[0].length;
    mostIsolatedDist = 0;
        isolatedDist = 0;
        maxDist = 0;
        minDist = 0x7FFFFFFF;
        for (int i = 0; i < numberOfCities; i++)
        {
            for (int j = 0; j < numberOfCities; j++)
            {
                isolatedDist += cityDistances[i][j];
            }
            if (isolatedDist > mostIsolatedDist)
            {
                mostIsolatedDist = isolatedDist;
                mostIsolCity = i;
            }
            isolatedDist = 0;
        }
        
        int[] solution = new int[numberOfCities];
        closestCity = mostIsolCity;
        for (int i = 0; i < numberOfCities; i++)
        {
            if (cityDistances[mostIsolCity][i] < minDist && i != mostIsolCity)
            {
                minDist = cityDistances[mostIsolCity][i];
                solution[1] = i;
            }
        }    
        minDist = 0x7FFFFFFF;
        for (int i = 0; i < numberOfCities; i++)
        {
            if (cityDistances[mostIsolCity][i] < minDist && i != mostIsolCity && i != closestCity)
            {
                minDist = cityDistances[mostIsolCity][i];
                solution[2] = i;
            }
        }
        
        for (int i = 3; i < numberOfCities; i++)
        {
            solution[i] = i;
        }
  
        
        return solution;
    }
}
