package salesmandilema;

public class SalesmanDilema {

    static int[][] cityDistances;
    static final int NUMCITIES = 100;
    static final int WORLDSIZE = 10000;
    static CityGenerator map;
    
    public static void main(String[] args) {
        map = new CityGenerator();
        
        cityDistances = map.GenerateMap(NUMCITIES, WORLDSIZE, 1);
        
        for(int i = 0; i < NUMCITIES; i++){
            map.cities[i].printCity();
            map.cities[i].printDistances();
            System.out.println();
        }
        
        /*
        Solution1 solution1 = new Solution1();
        int[] sol1 = solution1.solveIt(NUMCITIES, cityDistances);
        printSolution("Solution1 - initial order",sol1);
*/
        RandomGuesses randomGuesses = new RandomGuesses();
        int[] solRan = randomGuesses.solveIt(NUMCITIES, cityDistances);
        printSolution("Random",solRan);
        
        NearestNeighbor solution3 = new NearestNeighbor();
        int[] sol3 = solution3.solveIt(NUMCITIES, cityDistances);
        printSolution("Nearest neighbor",sol3);

        WeightedGuesses weightedGuesses = new WeightedGuesses();
        int[] solWG = weightedGuesses.solveIt(NUMCITIES, cityDistances);
        printSolution("Weighted guesses",solWG);
/*
        Exhaustive exhaustive = new Exhaustive();
        int[] solEx = exhaustive.solveIt(NUMCITIES, cityDistances);
        printSolution("Exhaustive",solEx);
*/        
        /*
        Nathan nathan = new Nathan();
        int[] solNathan = nathan.solveIt(NUMCITIES, cityDistances);
        printSolution("Nathan's Solution",solNathan);
        */
    }
    
    public static void printSolution(String solver, int[] solution) {
                
        System.out.println("\n"+solver);
        int totalDistance = 0;
        for (int i = 0; i < NUMCITIES-1; i++){
            map.cities[solution[i]].printCity();
            System.out.print("to ");
            map.cities[solution[i+1]].printCity(solution[i]);
            System.out.println();
            totalDistance += cityDistances[solution[i]][solution[i+1]];
        }
        System.out.println("Total Distance: "+totalDistance);

    }

}
