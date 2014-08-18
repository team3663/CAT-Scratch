package salesmandilema;

public class SalesmanDilema {

    static int[][] cityDistances;
    static final int NUMCITIES = 6;
    static final int WORLDSIZE = 100;
    static CityGenerator map;
    
    public static void main(String[] args) {
        map = new CityGenerator();
        
        cityDistances = map.GenerateMap(NUMCITIES, WORLDSIZE, 1);
        
        for(int i = 0; i < NUMCITIES; i++){
            map.cities[i].printCity();
            map.cities[i].printDistances();
            System.out.println();
        }

        Test solution1 = new Test();
        int[] solTest = solution1.solveIt(NUMCITIES, cityDistances);
        printSolution("Test route",solTest);
        
        WillyLoman willy = new WillyLoman();
        int[] solWilly = willy.solveIt(NUMCITIES, cityDistances);
        printSolution("Willy's(Curtis's) Route",solWilly);

        RandomGuesses randomGuesses = new RandomGuesses();
        int[] solRan = randomGuesses.solveIt(NUMCITIES, cityDistances);
        printSolution("Random",solRan);
        
        NearestNeighbor solution3 = new NearestNeighbor();
        int[] sol3 = solution3.solveIt(NUMCITIES, cityDistances);
        printSolution("Nearest neighbor",sol3);

        WeightedGuesses weightedGuesses = new WeightedGuesses();
        int[] solWG = weightedGuesses.solveIt(NUMCITIES, cityDistances);
        printSolution("Weighted guesses",solWG);

        Exhaustive exhaustive = new Exhaustive();
        int[] solEx = exhaustive.solveIt(NUMCITIES, cityDistances);
        printSolution("Exhaustive",solEx);
        
        /*
        Nathan nathan = new Nathan();
        int[] solNathan = nathan.solveIt(NUMCITIES, cityDistances);
        printSolution("Nathan's Solution",solNathan);
        */
    }
    
    public static void printSolution(String solver, int[] solution) {
                
        int totalDistance = 0;
        int i;
        
        System.out.println("\n"+solver);

        if (solution.length != NUMCITIES+1) {
            System.out.println("solution array is wrong length ("+solution.length+") expected " + (NUMCITIES+1));
            return;
        }
        
        for (i = 0; i < NUMCITIES+1; i++){
            if (solution[i] >= NUMCITIES || solution[i] < 0){
                System.out.println("At least one invalid entry in solution array: index "+i+" is "+solution[i]);
                return;
            }
        }
        
        if (solution[NUMCITIES] != solution[0]){
            System.out.println("Solution did not end in starting city. Start is "+solution[0]+", end is "+solution[NUMCITIES]);
            return;
        }
        
        for (i = 0; i < NUMCITIES; i++){
            map.cities[solution[i]].printCity();
            System.out.print("to ");
            map.cities[solution[i+1]].printCity(solution[i]);
            System.out.println();
            totalDistance += cityDistances[solution[i]][solution[i+1]];
        }
                
        boolean[] verifier = new boolean[NUMCITIES];
        
        for (i = 0; i < NUMCITIES; i++)
            verifier[i] = false;
        
        for (i = 0; i < NUMCITIES; i++)
            verifier[solution[i]] = true;

        for (i = 0; i < NUMCITIES; i++){
            if (verifier[i] == false){
                System.out.println("At least one city never visited: "+i);
                return;
            }
        }

        System.out.println("Total Distance: "+totalDistance);
    }
}
