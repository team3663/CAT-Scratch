/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package salesmandilema;

/**
 *
 * @author kingb_000
 */
public class City {
    
    String name;
    int xPos;
    int yPos;
    int[] distances;
    
    public City(String pName, int pXPos, int pYPos, int cities){
        name = pName;
        xPos = pXPos;
        yPos = pYPos;
        distances = new int[cities];
        
        for (int i = 0; i < 0; i++)
            distances[i] = 0;
    }
    
    public void setDistance(int cityNum, int distance){
        distances[cityNum] = distance;
    }

    public int getDistance(int cityNum){
        return distances[cityNum];
    }
    
    public void printCity(){
        System.out.print(name+"("+xPos+","+yPos+") ");
    }

    public void printDistances(){
        for (int i =0; i < distances.length; i++){
            System.out.print(""+distances[i]+", ");
        }
    }

    public void printCity(int city){
        System.out.print(name+"("+xPos+","+yPos+") "+distances[city]);
    }
}
