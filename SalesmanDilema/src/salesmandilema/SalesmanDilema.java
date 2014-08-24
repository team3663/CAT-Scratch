package salesmandilema;

public class SalesmanDilema {

    static int[][] cityDistances;
    static final int NUMCITIES = 10;
    static final int WORLDSIZE = 100;
    static final int SEED = 1;
    static CityGenerator map;
    
    public static void main(String[] args) {
        map = new CityGenerator();        
        cityDistances = map.GenerateMap(NUMCITIES, WORLDSIZE, SEED);
        
        for(int i = 0; i < NUMCITIES; i++){
            map.cities[i].printCity();
            map.cities[i].printDistances();
            System.out.println();
        }

        //Test test = new Test();
        //runAnalysis(test);

        LouBookman louBookman = new LouBookman();
        runAnalysis(louBookman);

        WillyLoman willy = new WillyLoman();
        runAnalysis(willy);

        RandomGuesses randomGuesses = new RandomGuesses();
        runAnalysis(randomGuesses);
        
        NearestNeighbor nearestNeighbor = new NearestNeighbor();
        runAnalysis(nearestNeighbor);

        AntColony antColony = new AntColony();
        runAnalysis(antColony);

        if (NUMCITIES < 10) {
            Exhaustive exhaustive = new Exhaustive();
            runAnalysis(exhaustive);
        }

        //Nathan nathan = new Nathan();
        //runAnalysis(nathan);        
    }
    
    public static void runAnalysis(TSP t){
        long time;
        int[] sol;
        
        System.out.println("\n"+t.description()+" Route"+"\nguess progress");
        time = System.nanoTime();
        sol = t.solveIt(cityDistances);
        time = System.nanoTime() - time;
        verifyAndPrintSolution(time,sol);
    }
    
    public static void verifyAndPrintSolution(long duration, int[] solution) {
                
        int totalDistance = 0;
        int i;
        
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
        System.out.println("Total Duration: "+duration/1000000.0+" (milliseconds)");
    }
}
