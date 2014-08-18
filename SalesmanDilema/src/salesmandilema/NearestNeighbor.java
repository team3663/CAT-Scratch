package salesmandilema;

import java.util.Random;

public class NearestNeighbor {
    
    public int[] solveIt(int numberOfCities, int[][] cityDistances){
        int[] solution = new int[numberOfCities];
        int[] bestSolution = new int[numberOfCities+1];
        int bestDistance = 0x7fffffff;
        int currentDistance;
        boolean[] visited = new boolean[numberOfCities];
        
        // start from every city
        for (int j = 0; j<numberOfCities; j++){
            for (int i = 0; i < numberOfCities; i++){
                visited[i]=false;
            }
            visited[j]=true;
            solution[0] = j;
            currentDistance = 0;
            int citiesVisited = 1;
            int currentCity = j;
            int nextCityDistance;
            int nextCity;
            
            while (citiesVisited<numberOfCities){
                nextCityDistance = 0x7fffffff;
                nextCity = 0;

                // loop through all cities finding the nearest one
                for (int k = 0; k < numberOfCities; k++){

                    //look for nearest remaining city
                    if (visited[k]==false){
                        if (cityDistances[currentCity][k]<nextCityDistance){
                            nextCityDistance = cityDistances[currentCity][k];
                            nextCity = k;
                        }
                    }
                }
                
                currentDistance += nextCityDistance;
                //System.out.print("("+nextCity+","+nextCityDistance+","+currentDistance+")");
                solution[citiesVisited++]=nextCity;
                visited[nextCity]=true;
                currentCity = nextCity;
            }
            
            currentDistance += cityDistances[solution[0]][solution[numberOfCities-1]];
            //System.out.println(""+j+": "+currentDistance+", "+bestDistance);
            if (currentDistance<bestDistance){
                for (int m = 0; m < numberOfCities; m++)
                    bestSolution[m] = solution[m];

                bestSolution[numberOfCities] = solution[0];
                bestDistance = currentDistance;
            }
        }
        return bestSolution;
    }
}