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

        Test test = new Test();
        verifyAndPrintSolution("Test route",test.solveIt(cityDistances));

        WillyLoman willy = new WillyLoman();
        verifyAndPrintSolution("Willy's(Curtis's) Route",willy.solveIt(cityDistances));

        RandomGuesses randomGuesses = new RandomGuesses();
        verifyAndPrintSolution("Random",randomGuesses.solveIt(cityDistances));
        
        NearestNeighbor nearestNeighbor = new NearestNeighbor();
        verifyAndPrintSolution("Nearest neighbor",nearestNeighbor.solveIt(cityDistances));

        AntColony antColony = new AntColony();
        verifyAndPrintSolution("Ant Colony",antColony.solveIt(cityDistances));

        if (NUMCITIES > 11) {
            Exhaustive exhaustive = new Exhaustive();
            verifyAndPrintSolution("Exhaustive",exhaustive.solveIt(cityDistances));
        }

        /*
        Nathan nathan = new Nathan();
        printSolution("Nathan's Solution",nathan.solveIt(NUMCITIES, cityDistances));
        */
    }
    
    public static void verifyAndPrintSolution(String solver, int[] solution) {
                
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

        for (i = 0; i < NUMCITIES; i++){
            map.cities[solution[i]].printCity();
            System.out.print("to ");
            map.cities[solution[i+1]].printCity(solution[i]);
            System.out.println();
            totalDistance += cityDistances[solution[i]][solution[i+1]];
        }
                
        System.out.println("Total Distance: "+totalDistance);
    }
}
