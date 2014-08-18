package salesmandilema;

public class Test {

    public int[] solveIt(int numberOfCities, int[][] cityDistances){
        int[] solution = new int[numberOfCities+1];
        
        for (int i = 0; i < numberOfCities; i++){
            solution[i]=i;
        }
        
        solution[numberOfCities] = solution[0];
        return solution;
    }
}
