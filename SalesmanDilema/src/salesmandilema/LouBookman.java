package salesmandilema;

import java.util.Random;


public class LouBookman implements TSP{
    public int numberOfCities;
    public int[] visited;
    public Random rnd;
    public int[][] kcityDistances;
    
    public String description (){return "Lou Bookman";}

    public int[] solveIt(int[][] cityDistances){
        kcityDistances = cityDistances;
        numberOfCities = cityDistances[0].length;
        int[] solution = new int[numberOfCities+1];
        visited = new int[numberOfCities];
        rnd = new Random();
        /*for(int j = 0; j < numberOfCities; j++){
            for(int i = 0; i < numberOfCities; i++){
                solution[j] = findTheClosest(i, cityDistances);
            }
        }*/
        
        //make a random arrangement
            //fill the solution array with different numbers
        //do it a lot
        //compare distances
        //return best distance
        
        solution = fillTheSolutionXTimes(10000);
        
        return solution;
    }
    
    //fill an array of cities X number of times and find the shortest route of those X tries
    public int[] fillTheSolutionXTimes(int numberOfTimes){
        int[] bestAnswer = new int[numberOfCities + 1];
        int[] newAnswer = new int[numberOfCities + 1];
        int bestDistance = 0x7fffffff;
        for(int i = 0; i < numberOfTimes; i++){
            clearVisited();
            for(int j = 0; j < numberOfCities; j++){
                newAnswer[j] = findARandomCityNotYetVisitedYet();
            }
            
            newAnswer[numberOfCities] = newAnswer[0];
            
            if(calculateDistanceOfRoute(newAnswer) < bestDistance){
                bestAnswer = newAnswer;
            }
        }
        return bestAnswer;
    }

 
    //find a random city that hasn't been visited and return it
    public int findARandomCityNotYetVisitedYet(){
        int city;
        for(int i = 0; ; i++){
            city = rnd.nextInt(numberOfCities);
            if(visited[city] != 1){
                visited[city] = 1;
                break;
            }
        }
        return city; 
    }
    
    //adds all the distances from the route and returns the total distance
    public int calculateDistanceOfRoute(int[] route){
        int total = 0;
        for(int i = 0; i < numberOfCities; i++){
            total += kcityDistances[route[i]][route[i + 1]];
        }
        return total;
    }
    
    public void clearVisited(){
        for(int i = 0; i < visited.length; i++){
            visited[i] = 0;
        }
    }
    //returns the nearest city, not including itself
    /*public int findTheClosest(int theCityInQuestion, int[][]theCityDistances){
        int theClosest = theCityInQuestion;
        
        for(int i = 0; i < numberOfCities; i++){
            if(theCityDistances[theCityInQuestion][i] < theClosest && theCityDistances[theCityInQuestion][i] != 0 && theCityDistances[theCityInQuestion][i] != -1)
                theClosest = theCityDistances[theCityInQuestion][i];
                theCityDistances[theCityInQuestion][i] = -1;
        }
        
        return theClosest;
    }*/
    
}
