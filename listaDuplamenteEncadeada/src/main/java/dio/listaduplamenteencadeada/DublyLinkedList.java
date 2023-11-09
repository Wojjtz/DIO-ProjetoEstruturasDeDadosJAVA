package dio.listaduplamenteencadeada;

public class DublyLinkedList <T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public DublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return this.size;
    }

    public void addTail(T data){
        if(this.isEmpty()){
            DoubleNode<T> newNode = new DoubleNode(data);
            newNode.setPreviousDoubleNode(null);
            newNode.setNextDoubleNode(tail);
            head = newNode;
            tail = newNode;
        }else{
            DoubleNode<T> pointer = head;

            for (; pointer.getNextDoubleNode() != null; pointer = pointer.getNextDoubleNode());

            DoubleNode newNode = new DoubleNode<>(data);
            pointer.setNextDoubleNode(newNode);
            newNode.setPreviousDoubleNode(pointer);
            newNode.setPreviousDoubleNode(null);
            tail = newNode;
        }
        size++;
    }

    public void addHead(T data){
        if(isEmpty()){
            DoubleNode<T> newNode = new DoubleNode(data);
            newNode.setPreviousDoubleNode(null);
            newNode.setNextDoubleNode(tail);
            head = newNode;
            tail = newNode;
        }else{
            DoubleNode<T> newDoubleNode = new DoubleNode<>(data, head, null);
            head.setPreviousDoubleNode(newDoubleNode);
            head = newDoubleNode;
        }
        size++;
    }

    public void addNextTo(T dataPointer, T data){
        DoubleNode<T> newNode = new DoubleNode<>(data);
        DoubleNode pointer = this.getNodePerData(dataPointer);

        newNode.setNextDoubleNode(pointer.getNextDoubleNode());
        pointer.getNextDoubleNode().setPreviousDoubleNode(newNode);
        pointer.setNextDoubleNode(newNode);
        newNode.setPreviousDoubleNode(pointer);
    }

    public void addAt(int index, T data){
        DoubleNode<T> pointer = getNode(index);
        DoubleNode<T> newNode = new DoubleNode<>(data);
        newNode.setNextDoubleNode(pointer);

        if(newNode.getNextDoubleNode() != null){
            newNode.setPreviousDoubleNode(pointer.getPreviousDoubleNode());
            newNode.getNextDoubleNode().setPreviousDoubleNode(newNode);
        }else {
            newNode.setPreviousDoubleNode(tail);
            tail = newNode;
        }

        if(index == 0){
            head = newNode;
        }else{
            newNode.getPreviousDoubleNode().setNextDoubleNode(newNode);
        }
        size++;
    }

    public T get(int index){
        return getNode(index).getData();
    }

    private DoubleNode<T> getNode(int index){
        validateIndex(index);
        DoubleNode<T> pointer = head;

        for (; index > 0; index--)
            pointer = pointer.getNextDoubleNode();

        return pointer;
    }

    private DoubleNode<T> getNodePerData(T data){
        DoubleNode pointer = head;
        for (; pointer.getData() != data; pointer = pointer.getNextDoubleNode());
        return pointer;
    }

    public void remove(int index){
        if(index == 0){
            head = head.getNextDoubleNode();
            if(head != null){
                head.setPreviousDoubleNode(null);
            }
        }else{
            DoubleNode<T> pointer = getNode(index);
            pointer.getPreviousDoubleNode().setNextDoubleNode(pointer.getNextDoubleNode());
            if(pointer != head){
                pointer.getNextDoubleNode().setPreviousDoubleNode(pointer.getPreviousDoubleNode());
            }else{
                head = pointer;
            }
        }
        size--;
    }

    public String toString(){
        String str = "Lista Duplamente Encadeada\n";

        DoubleNode<T> pointer = head;
        for (; pointer != null; pointer = pointer.getNextDoubleNode())
            str += pointer.toString() + "--->";

        return str += "null";
    }

    private void validateIndex(int index){
        if(index >= size()){
            throw new IndexOutOfBoundsException("Não existe contúdo no índice " + index + " desta lista."
                    + "\nEsta lista só vai até o índice: " + (size()-1));
        }
    }
}
