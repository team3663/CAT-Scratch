package salesmandilema;

import java.util.Random;

public class RandomGuesses {
    public int[] solveIt(int numberOfCities, int[][] cityDistances){
        int[] solution = new int[numberOfCities];
        int[] bestSolution = new int[numberOfCities];
        int bestDistance = 0x7fffffff;
        boolean[] visited = new boolean[numberOfCities];
        int guesses = 500000;
        int i,j;
        
        Random r = new Random();

        for (j = 0; j<guesses; j++){
            for (i = 0; i < numberOfCities; i++){
                visited[i]=false;
            }

            int visitedCityCount = 0;
            
            int nextCity=0;
            while (visitedCityCount<numberOfCities){

                int index = r.nextInt(numberOfCities-visitedCityCount);
                for (i = 0; i < numberOfCities; i++) {
                    if (!visited[i]){
                        if (index-- == 0){
                            nextCity = i;
                            break;
                        }
                    }
                }
                solution[visitedCityCount]=nextCity;
                visited[nextCity]=true;
                visitedCityCount++;
            }
            
            int distance = 0;
            for (i = 1; i < numberOfCities; i++)
                distance += cityDistances[i-1][i];
            
            if (distance<bestDistance){
                for (i = 0; i < numberOfCities; i++)
                    bestSolution[i] = solution[i];

                bestDistance = distance;
            }
        }
        return bestSolution;
    }    
}
