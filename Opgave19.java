import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Opgave19 {
    public static void main(String[] args) {
        Map<String,Integer> map1 = new HashMap<>();

        map1.put("Andreas",22);
        map1.put("Kasper",22);
        map1.put("Anders",11);
        map1.put("Jesper", 11);
        map1.put("Christian", 19);
        map1.put("Lukas", 19);
        map1.put("Søren",22);

        rarest(map1);


        // Denne opgave tog mig lang tid, der er sikkert en nemmere måde at lave den på men lige pt har jeg ikke fundet en nemmere måde :)
    }

    public static int rarest(Map<String, Integer> a)
    {
        int returnering = 0;
        boolean minIsFound = false;
        Map<Integer,Integer> map2 = new HashMap<>();

        Iterator<String> J = a.keySet().iterator();

        if(a.isEmpty())
        {
            J.next(); // giver no such elementexception hvis map er empty
        }

        while (J.hasNext()){
            int number = a.get(J.next());
            if(map2.containsKey(number))
            {
                map2.put(number,map2.get(number)+1); // Fortæller mappen der er 2 values af nummeret
            }else
            {
                map2.put(number,1);
            }
        }

        int minNumber = 100;

        for (Integer n : map2.values())
        {
            if(minNumber > n)
            {
                minNumber = n;
            }else if(minNumber == n)
            {
                minNumber = 100;
                for (Integer K : map2.keySet())
                {
                    if(K < minNumber)
                    {
                        minNumber = K;
                        returnering = minNumber; // sætter returnering til minNumber da vi får key værdien her
                        minIsFound = true; // hvis minimum er fundet sørger dette for at det nedenstående while loop ikke køre
                    }
                }
                break;
            }

        }
        Iterator it = map2.entrySet().iterator();

        if(!minIsFound)
        {
            while (it.hasNext())
            {
                Map.Entry getKey = (Map.Entry) it.next();

                if (getKey.getValue().equals(minNumber))
                {
                    returnering = (int) getKey.getKey(); // sætter returnering til værdien af key
                }
            }
        }
        System.out.println(returnering); // udskriver returnering
        return returnering;
    }
}
