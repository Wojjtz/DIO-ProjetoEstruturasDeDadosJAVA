package dio.listaduplamenteencadeada;

public class Main {
    public static void main(String[] args) {
        DublyLinkedList<Integer> lista = new DublyLinkedList<>();

        lista.addHead(5);
        lista.addHead(2);
        lista.addHead(3);
        lista.addHead(1);

        System.out.println(lista.toString());

        lista.addNextTo(3, 4);

        System.out.println(lista.toString());
    }
}
