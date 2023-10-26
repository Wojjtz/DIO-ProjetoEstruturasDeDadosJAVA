package dio.listaduplamenteencadeada;

public class DoubleNode<T> {

    private T data;
    private DoubleNode nextDoubleNode;
    private DoubleNode previousDoubleNode;

    public DoubleNode() {
        this.nextDoubleNode = null;
        this.previousDoubleNode = null;
    }

    public DoubleNode(T data) {
        this.data = data;
        this.nextDoubleNode = null;
        this.previousDoubleNode = null;
    }

    public DoubleNode(T data, DoubleNode nextDoubleNode, Double previousNode) {
        this.data = data;
        this.nextDoubleNode = nextDoubleNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleNode getNextDoubleNode() {
        return nextDoubleNode;
    }

    public void setNextDoubleNode(DoubleNode nextDoubleNode) {
        this.nextDoubleNode = nextDoubleNode;
    }

    public DoubleNode getPreviousDoubleNode() {
        return previousDoubleNode;
    }

    public void setPreviousDoubleNode(DoubleNode previousDoubleNode) {
        this.previousDoubleNode = previousDoubleNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public String toStringMod(){
        String str = "Node{" +
                "conteudo=" + data +
                '}';
        if(nextDoubleNode != null)
            str += "->" + nextDoubleNode.toString();
        else
            str += "-> null";

        return str;
    }
}