package salesmandilema;

import java.util.HashSet;
import java.util.Random;

public class CityGenerator {
    
    City[] cities;
    String[] cityNames = {"Agra","Amsterdam","Antalya","Athens","Atlanta","Auckland","Bali","Bangkok","Barcelona","Beijing","Berlin","Bogotá","Boston","Brussels","Bucharest","Budapest","Buenos Aires","Cairo","Cancún","Cape Town","Chennai","Chicago","Copenhagen","Dallas","Delhi","Dubai","Dublin","Edinburgh","Edirne","Florence","Guangzhou","Hà Nội","Hồ Chí Minh","Hong Kong","Honolulu","Houston","Istanbul","Jakarta","Jerusalem","Johannesburg","Kiev","Kuala Lumpur","Las Vegas","Libson","Lima","London","Los Angeles","Luxor","Macau","Madrid","Manila","Marrakesh","Mecca","Melbourne","Mexico City","Miami","Milan","Montreal","Moscow","Mumbai","Munich","New Orleans","New York","Orlando","Oslo","Paris","Pattaya","Petra","Philadelphia","Phnom Penh","Phuket","Prague","Punta Cana","Rio de Janeiro","Riyadh","Rome","San Diego","San Francisco","Santiago","São Paulo","Seattle","Seoul","Shanghai","Sharm el-Sheikh","Shenzhen","Singapore","St. Petersburg","Stockholm","Sydney","Taipei","Tokyo","Toronto","Vancouver","Varna","Venice","Vienna","Warsaw","Washington D.C.","Wellington","Zürich"};
    Random r;
    int[][] cityDistances;
    
    public int[][] GenerateMap(int numberOfCities, int worldDimension, int seed){
        int i, j;
        
        if (seed != 0)
            r = new Random(seed);
        else
            r = new Random();
        
        if (numberOfCities > cityNames.length){
            System.out.println("Need more city names");
            return cityDistances;
        }
        cities = new City[numberOfCities];
        
        for (i = 0; i < numberOfCities; i++){
            cities[i]= new City(cityNames[i],r.nextInt(worldDimension),r.nextInt(worldDimension),numberOfCities);
        }
        
        cityDistances = new int[numberOfCities][numberOfCities];
        
        for (i = 0; i < numberOfCities; i++){
            for (j = 0; j < numberOfCities; j++){
                int xDelta = cities[i].xPos-cities[j].xPos;
                int yDelta = cities[i].yPos-cities[j].yPos;
                
                int distance = (int)Math.round(Math.sqrt((xDelta*xDelta)+(yDelta*yDelta)));
                cities[i].setDistance(j, distance);
                cityDistances[i][j]=distance;
                cityDistances[j][i]=distance;
            }
        }
        
        return cityDistances;
    }
}
