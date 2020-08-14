import java.io.*;
import java.util.*;

public class reservoirSampling {

    public static void main(String[] args){
        Qgen mySampler = new Qgen();
        List<String> myList = mySampler.qgen(10);
        for(int index = 0;index<myList.size();index++){
            myList.get(index);
        }
    }
}

import java.io.*;
import java.util.*;

public class Qgen {

    public Qgen(){}
    public List<String> qgen (int reservoirSize)
    {
        String currentLine=null;
        //reservoirList is where our selected lines stored
        List <String> reservoirList= new ArrayList<String>(reservoirSize);
        // we will use this counter to count the current line number while iterating
        int count=0;

        Random ra = new Random();
        int randomNumber = 0;
        Scanner sc = new Scanner(new File("YuriQuote.txt")).useDelimiter("\n");
        while (sc.hasNext())
        {
            currentLine = sc.next();
            count ++;
            if (count<=reservoirSize)
            {
                reservoirList.add(currentLine);
            }
            else if ((randomNumber = (int) ra.nextInt(count))<reservoirSize)
            {
                reservoirList.set(randomNumber, currentLine);
            }
        }
        return reservoirList;
    }
