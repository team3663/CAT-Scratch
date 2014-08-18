package salesmandilema;

public class Exhaustive {
    
    public int[] solveIt(int numberOfCities, int[][] cityDistances){
        int[] bestSolution = new int[numberOfCities];
        int bestDistance = 0x7fffffff;

        int i;
        int[] ct = new int[numberOfCities];
        for (i=0; i<numberOfCities; i++) ct[i]=0;
        int highBit = 0;

        while (true) {
            
            ct = advance(ct);
            if (ct[0] < highBit) break;
            highBit = ct[0];

            int currentDistance=0;
            for (i=1; i<numberOfCities; i++)
                currentDistance += cityDistances[ct[i-1]][ct[i]];

            if (currentDistance<bestDistance){
                for (i = 0; i < numberOfCities; i++)
                    bestSolution[i] = ct[i];
                bestDistance = currentDistance;
            }
        }
        return bestSolution;
    }
    
    int[] advance(int[] ct) {
        int size = ct.length;
        int i,j;
        boolean tryAgain;
        
        do {
            for (i = size-1; i>=0; i--){
                if (++ct[i] == size)
                    ct[i]=0;
                else
                    break;
            }
            
            tryAgain = false;
            
            for (i=1; i<size; i++){
                for (j=0; j<i; j++) {
                    if (ct[i] == ct[j]) {
                        tryAgain = true;
                        break;
                    }
                }
                if (tryAgain) break;
            }
            
        } while (tryAgain);
        
        return ct;
    }
}
