import java.util.*;

public class first {

    public static List<String> translatePirate(List<String> original) {
        ListIterator<String> it = original.listIterator();
        while (it.hasNext()) {
            it.next();
            if (it.hasNext())
                it.add("...arr!...");
        }
        return original;
    }
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        String arr = "arr";

        list.add("I");
        list.add("am");
        list.add("fine");
        list.add("Thanks");

//        for (int i = list.size(); i > 0; i-= 1) {
//            list.add(i, "arr");
//        }
        System.out.println(translatePirate(list));


    }
}
