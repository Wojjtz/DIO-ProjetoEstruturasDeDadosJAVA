package dio.node;

public class LinkedList <T>{

    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        int sizeList = 0;
        Node <T> auxNode = head;

        for(; auxNode != null ; auxNode = auxNode.getNextNode())
            sizeList++;

        return  sizeList;

        /*while (true){
            if(auxNode != null){
                sizeList++;
                if(auxNode.getNextNode() != null){
                    auxNode = auxNode.getNextNode();
                }else{
                    break;
                }
            }else{
                break;
            }
        }*/
    }

    public void add(T data){
        if(this.isEmpty()){
            head = new Node<>(data);
        }else{
            Node<T> auxNode = head;

            for (; auxNode.getNextNode() != null; auxNode = auxNode.getNextNode());

            auxNode.setNextNode(new Node<>(data));
        }
    }

    public void addHead(T data){
        if(isEmpty()){
            head = new Node<>(data);
        }else{
            Node<T> newNode = new Node<>(data, head);
            head = newNode;
        }
    }

    public T get(int index){
        return getNode(index).getData();
    }

    private Node<T> getNode(int index){

        validateIndex(index);
        Node<T> auxNode = head;
        Node<T> returnNode = null;

        for (; index > 0; index--)
            auxNode = auxNode.getNextNode();
        returnNode = auxNode;


        return returnNode;
    }

    public T remove(int index){
        Node<T> pivotNode = this.getNode(index);
        if(index == 0){
            head = pivotNode.getNextNode();
            return pivotNode.getData();
        }
        Node<T> previousNode = getNode(index-1);
        previousNode.setNextNode(pivotNode.getNextNode());
        return pivotNode.getData();
    }

    public String toString(){
        String str = "Lista Encadeada\n";

        Node<T> auxNode = head;
        for (; auxNode != null; auxNode = auxNode.getNextNode())
            str += auxNode.toString() + "--->";

        return str += "null";
    }

    private void validateIndex(int index){
        if(index >= size()){
            throw new IndexOutOfBoundsException("Não existe contúdo no índice " + index + " desta lista."
                    + "\nEsta lista só vai até o índice: " + (size()-1));
        }
    }
}
