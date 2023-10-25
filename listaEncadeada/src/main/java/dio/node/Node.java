package dio.node;

public class Node <T> {

    private T data;
    private Node nextNode;

    public Node() {
        this.nextNode = null;
    }

    public Node(T data) {
        this.data = data;
        this.nextNode = null;
    }

    public Node(T data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public String toStringMod(){
        String str = "Node{" +
                "conteudo=" + conteudo +
                '}';
        if(nextNode != null)
            str += "->" + nextNode.toString();
        else
            str += "-> null";

        return str;
    }
}
