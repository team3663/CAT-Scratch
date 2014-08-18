/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linklist;

/**
 *
 * @author Angelique
 */
class LL {
    int num;
    LL next;
}
public class DoWork {
    LL head = null;
    
    public void print2(LL head)
    {
        if (head != null)
        {
            System.out.print(head.num + ", ");
        }
        if (head.next != null)
        {
            System.out.print(head.next.num + ", ");
        }
        if (head.next.next != null)
        {
            System.out.print(head.next.next.num + ", ");
        }
        if (head.next.next.next != null)
        {
            System.out.print(head.next.next.next.num);
        }
        System.out.println();
    }
    
    public void print()
    {
        LL head2 = head;
        System.out.print("{");
        while (head2 != null)
        {
            System.out.print(head2.num + ", ");
            head2 = head2.next;
        }
        System.out.println();
        System.out.println("size: " + size);
    }
    
    int size = 0;
    public void addNum(int n)
    {
        LL ll = new LL();
        ll.num = n;
        ll.next = head;
        head = ll;
        size++;
    }
    
    public void sort()
    {
        LL head3 = head;
        LL tempA;
        LL tempB;
        LL tempC;
        LL tempD;
        boolean switched = true;
        while (switched)
        {
            switched = false;
            if (head.num > head.next.num)
            {
                print2(head3);
                tempA = head3;
                tempB = head3.next;
                tempC = head3.next.next;
                head3 = tempB;
                tempB.next = tempA;
                tempA.next = tempC;
                print2(head3);
                switched = true;
            }
            while (head3.next.next.next != null)
            {
                if (head3.next.num > head3.next.next.num)
                {
                    tempB = head3.next;
                    tempC = head3.next.next;
                    tempD = head3.next.next.next;
                    head3.next = tempC;
                    tempC.next = tempB;
                    tempB.next = tempD;
                    switched = true;
                }
                head3 = head3.next;
            }
            head3 = head;
            
        }
    }
}

