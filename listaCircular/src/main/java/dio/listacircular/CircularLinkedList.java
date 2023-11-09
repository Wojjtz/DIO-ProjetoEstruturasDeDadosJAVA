package dio.listacircular;

public class CircularLinkedList <T> {
    //neste caso, o head refere ao primeiro objecto da fila, e tail ao ultimo
    //
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(this.isEmpty()){
            head = newNode;
            tail = newNode;
            this.head.setNextNode(tail);
        }else{
            newNode.setNextNode(tail);
            head.setNextNode(newNode);
            tail = newNode;
        }
        size++;
    }

    public void addHead(T data){
        if(isEmpty()){
            Node<T> newNode = new Node<>(data);
            head = newNode;
            tail = newNode;
            size++;
        }else{
            Node<T> newNode = new Node<>(data);
            head = newNode;
            head.setNextNode(tail);
            tail.setNextNode(head);
            size++;
        }
    }

    public T get(int index){
        return getNode(index).getData();
    }

    private Node<T> getNode(int index){

        validateIndex(index);
        if(index == 0){
            return tail;
        }

        Node<T> auxNode = tail;

        for (; index > 0; index--)
            auxNode = auxNode.getNextNode();

        return auxNode;
    }

    public T remove(int index){

        Node<T> pivotNode = this.getNode(index);
        if(index == 0){
            tail = pivotNode.getNextNode();
            head.setNextNode(tail);
            size--;
            return pivotNode.getData();
        }

        Node<T> previousNode = getNode(index-1);
        previousNode.setNextNode(pivotNode.getNextNode());
        size--;
        return pivotNode.getData();
    }

    public String toString(){
        String str = "Lista Circular\n";

        Node<T> auxNode = tail;
        for (int i = 0; i < size; auxNode = auxNode.getNextNode(), i ++)
            str += auxNode.toString() + "--->";

        return str += "volta inicio";
    }

    private void validateIndex(int index){
        if(index >= size()){
            throw new IndexOutOfBoundsException("Não existe contúdo no índice " + index + " desta lista."
                    + "\nEsta lista só vai até o índice: " + (size()-1));
        }
    }
}
