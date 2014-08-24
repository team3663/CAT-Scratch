package salesmandilema;

public class Exhaustive implements TSP{

    public String description (){return "Exhaustive";}

    public int[] solveIt(int[][] cityDistances){
        int numberOfCities = cityDistances[0].length;
        int[] bestSolution = new int[numberOfCities+1];
        int bestDistance = 0x7fffffff;

        int i;
        int[] ct = new int[numberOfCities];
        for (i=0; i<numberOfCities; i++) ct[i]=0;

        int count = 0;
        while (true) {
            
            ct = advance(ct);
            if (ct[0] > 0) 
                break;

            count++;
            int currentDistance=0;
            for (i=1; i<numberOfCities; i++)
                currentDistance += cityDistances[ct[i-1]][ct[i]];

            currentDistance += cityDistances[ct[numberOfCities-1]][ct[0]];
            
            if (currentDistance<bestDistance){
                System.out.println(""+count+": "+currentDistance);
                System.arraycopy(ct, 0, bestSolution, 0, numberOfCities);

                bestSolution[numberOfCities]=ct[0];
                bestDistance = currentDistance;
                System.out.println(""+count+": "+bestDistance);
            }
        }
        System.out.println(""+count+": "+bestDistance);
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
