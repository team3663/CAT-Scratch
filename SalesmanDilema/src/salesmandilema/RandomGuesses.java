package salesmandilema;

import java.util.Random;

public class RandomGuesses {
    public int[] solveIt(int[][] cityDistances){
        int numberOfCities = cityDistances[0].length;
        int[] solution = new int[numberOfCities+1];
        int[] bestSolution = new int[numberOfCities+1];
        int bestDistance = 0x7fffffff;
        boolean[] visited = new boolean[numberOfCities];
        int guesses = 500000;
        int i,j;
        
        Random r = new Random();

        int count = 0;
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
            solution[numberOfCities] = solution[0];
            int distance = 0;
            for (i = 1; i < numberOfCities+1; i++)
                distance += cityDistances[solution[i-1]][solution[i]];
            
            count++;
            if (distance<bestDistance){
                System.arraycopy(solution, 0, bestSolution, 0, numberOfCities+1);

                bestDistance = distance;
                System.out.println(""+count+": "+bestDistance);
                j = 0;
            }
        }
        System.out.println(""+count+": "+bestDistance);
        return bestSolution;
    }    
}
