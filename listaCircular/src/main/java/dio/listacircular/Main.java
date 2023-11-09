package dio.listacircular;

public class Main {
    public static void main(String[] args) {

        CircularLinkedList<Integer> circulo = new CircularLinkedList<>();

        circulo.add(2);
        circulo.add(3);
        circulo.add(5);
        circulo.add(1);

        System.out.println(circulo.toString());
    }
}
