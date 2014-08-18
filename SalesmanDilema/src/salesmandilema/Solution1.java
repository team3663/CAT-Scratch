package salesmandilema;

public class Solution1 {

    public int[] solveIt(int numberOfCities, int[][] cityDistances){
        int[] solution = new int[numberOfCities];
        
        for (int i = 0; i < numberOfCities; i++){
            solution[i]=i;
        }
        
        return solution;
    }
}
