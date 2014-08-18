package salesmandilema;

import java.util.Random;

public class WeightedGuesses {
    public int[] solveIt(int numberOfCities, int[][] cityDistances){
        int[] solution = new int[numberOfCities];
        int[] bestSolution = new int[numberOfCities];
        int bestDistance = 0x3fffffff;

        boolean[] visited = new boolean[numberOfCities];
        int[][] weights = new int[numberOfCities][numberOfCities];
        int[] startWeights = new int[numberOfCities];
        
        int guesses = 10000;//100*numberOfCities*numberOfCities;
        int i,j;
            
        for (i=0; i<numberOfCities; i++) {
            startWeights[i] = guesses;
            for (j=0; j<numberOfCities; j++) {
                weights[i][j] = guesses;
            }
        }
        Random r = new Random();

        for (j = 0; j<guesses; j++){
            for (i = 0; i < numberOfCities; i++){
                visited[i]=false;
            }
            
            // start in random city
            int sumOfStartWeights = 0;
            for (i = 0; i < numberOfCities; i++) 
                sumOfStartWeights += startWeights[i];
            
            int startGuess = r.nextInt(sumOfStartWeights);
            
            for (i = 0; i < numberOfCities; i++){
                if (startGuess <= startWeights[i]){
                    visited[i] = true;
                    solution[0] = i;
                    break;
                }
                startGuess -= startWeights[i];
            }

            int visitedCityCount = 1;
            
            int nextCity=0;
            while (visitedCityCount<numberOfCities){

                int sumOfWeights=0;
                for (i = 0; i < numberOfCities; i++) {
                    if (!visited[i]){
                        sumOfWeights += weights[i][solution[visitedCityCount-1]];
                    }
                }
 
                int weightedGuess = r.nextInt(sumOfWeights);
                
                for (i = 0; i < numberOfCities; i++) {
                    if (!visited[i]){
                        if (weightedGuess <= weights[i][solution[visitedCityCount-1]]){
                            nextCity = i;
                            break;
                        }
                        weightedGuess -= weights[i][solution[visitedCityCount-1]];
                    }
                }
                solution[visitedCityCount]=nextCity;
                visited[nextCity]=true;

                visitedCityCount++;
            }
            int weight;
            int distance = 0;
            for (i=1; i<numberOfCities; i++){
                distance += cityDistances[solution[i-1]][solution[i]];
            }
            
            if (distance<bestDistance){
                for (i = 0; i < numberOfCities; i++) 
                    bestSolution[i] = solution[i];

                bestDistance = distance;
                j = 0; // reset the guess counter
            }

            if (distance<bestDistance+100)                
                weight = 10;
            else
                weight = -1;
            
            startWeights[solution[0]] += weight;
            for (i = 1; i < numberOfCities; i++) {
                weights[solution[i-1]][solution[i]] += weight;
            }
        }
        return bestSolution;
    }    
}
