package salesmandilema;

public class Test implements TSP{

    public String description (){return "Test";}
    public int[] solveIt(int[][] cityDistances){
        
        int numberOfCities = cityDistances[0].length;

        int[] solution = new int[numberOfCities+1];
        
        for (int i = 0; i < numberOfCities; i++){
            solution[i]=i;
        }
        
        solution[numberOfCities] = solution[0];
        return solution;
    }
}
