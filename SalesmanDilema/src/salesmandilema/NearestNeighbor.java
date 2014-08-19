package salesmandilema;

public class NearestNeighbor {
    
    public int[] solveIt(int[][] cityDistances){
        int numberOfCities = cityDistances[0].length;
        int[] solution = new int[numberOfCities];
        int[] bestSolution = new int[numberOfCities+1];
        int bestDistance = 0x7fffffff;
        int currentDistance;
        boolean[] visited = new boolean[numberOfCities];
        
        int count=0;
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
                solution[citiesVisited++]=nextCity;
                visited[nextCity]=true;
                currentCity = nextCity;
            }
            
            currentDistance += cityDistances[solution[0]][solution[numberOfCities-1]];
            count++;
            if (currentDistance<bestDistance){

                System.arraycopy(solution, 0, bestSolution, 0, numberOfCities);

                bestSolution[numberOfCities] = solution[0];
                bestDistance = currentDistance;
                System.out.println(""+count+": "+bestDistance);
            }
        }
        System.out.println(""+count+": "+bestDistance);
        return bestSolution;
    }
}