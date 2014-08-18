/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linklist;

import java.util.Random;
/**
 *
 * @author Angelique
 */

public class LinkList2 {
    
    public void start()
    {
        Random random = new Random();
        int amount = 100 + random.nextInt(99900);
        DoWork dw = new DoWork();
       // for (int i = 0;i < amount;i++)
        {
            //dw.addNum(random.nextInt(100));
            dw.addNum(10);
            dw.addNum(8);
            dw.addNum(7);
            dw.addNum(6);
            dw.addNum(12);
            dw.addNum(14);
            dw.addNum(11);
        }
        dw.print();
        dw.sort();
        dw.print();
    }
    
}
