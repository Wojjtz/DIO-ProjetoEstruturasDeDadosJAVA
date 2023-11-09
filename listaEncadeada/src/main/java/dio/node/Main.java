package dio.node;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(3);
        list.add(2);
        list.add(1);
        list.add(5);
        System.out.println(list);

        System.out.println(list.remove(2));
        System.out.println(list);


    }
}
