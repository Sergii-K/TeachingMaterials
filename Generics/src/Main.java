import java.util.*;

/**
 * Created by akravets on 1/13/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(fact(5, 1));

        List<Integer> l = Collections.synchronizedList(new LinkedList<Integer>());

        for (int i = 0; i < 10; i++) {
            l.add(i);
        }


        Iterator<Integer> iterator = l.iterator();
        while (iterator.hasNext()) {
            Integer elem = iterator.next();
            if (elem % 2 == 0) iterator.remove();
        }


        System.out.println(l.toString());


        for(int i=0; i<10; i++){
            for(int j=0; j<=i; j++){
                System.out.print(pascalValue(i, j));
            }
            System.out.println();
        }

    }



    static <A> ArrayList<A> change(A[] arr) {
        ArrayList<A> list = new ArrayList<A>();
        for (A a : arr) {
            list.add(a);
        }
        return list;
    }


    private static int changeCount(int money, List<Integer> coins) {
        return 0;
    }

    private static boolean balance(List<Character> s) {
        return false;
    }


    private static int pascalValue(int row, int col){
        return 0;
    }





    private static int fact(int n) {
        return n == 0 ? 1 : n * fact(n - 1);
    }

    private static int fact(int n, int acc) {
        return n == 0 ? acc : fact(n - 1, acc * n);
    }


}
