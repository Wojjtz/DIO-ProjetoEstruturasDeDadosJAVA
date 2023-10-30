package dio.arvore;

public class BinaryTree <T extends Comparable<T>>{

    private BinNode<T> root;

    public BinaryTree(){
        this.root = null;
    }

    public void insert(T data){
        BinNode<T> newNode = new BinNode<>(data);
        root = insert(root, newNode);
    }

    private BinNode<T> insert(BinNode<T> current, BinNode<T> newNode){
        if(current == null){
            return newNode;
        }else if(newNode.getData().compareTo(current.getData()) < 0){
            current.setLeftNode(insert(current.getLeftNode(), newNode));
        }else{
            current.setRightNode(insert(current.getRightNode(), newNode));
        }
        return current;
    }

    public void showInOrder(){
        System.out.println("\n Exibindo InOrder:");
        showInOrder(this.root);
    }
    private void showInOrder(BinNode<T> current){
        if(current != null){
            showInOrder(current.getLeftNode());
            System.out.print(current.getData() + ", ");
            showInOrder(current.getRightNode());
        }
    }

    public void showPostOrder(){
        System.out.println("\n Exibindo PostOrder:");
        showPostOrder(this.root);
    }
    private void showPostOrder(BinNode<T> current){
        if(current != null){
            showPostOrder(current.getLeftNode());
            showPostOrder(current.getRightNode());
            System.out.print(current.getData() + ", ");
        }
    }

    public void showPreOrder(){
        System.out.println("\n Exibindo PreOrder:");
        showPreOrder(this.root);
    }
    private void showPreOrder(BinNode<T> current){
        if(current != null){
            System.out.print(current.getData() + ", ");
            showPreOrder(current.getLeftNode());
            showPreOrder(current.getRightNode());
        }
    }

    public void remove(T data){
        try{
            BinNode<T> current = this.root;
            BinNode<T> parent = this.root;
            BinNode<T> child;
            BinNode<T> temp;

            while(current != null && !current.getData().equals(data)){
                parent = current;
                if(data.compareTo(current.getData()) < 0){
                    current = current.getLeftNode();
                }else{
                    current = current.getRightNode();
                }
            }

            if(current == null){
                System.out.println("Conteúdo não encontrado. Bloco try");
            }

            if (parent == null){
                if(current.getRightNode() == null){
                    this.root = current.getLeftNode();
                }else if(current.getLeftNode() == null){
                    this.root = current.getRightNode();
                }else{
                    for (
                            temp = current, child = current.getLeftNode();
                            child.getRightNode() != null;
                            temp = child, child = child.getLeftNode()
                    ){
                        if(child != current.getLeftNode()){
                            temp.setRightNode(child.getLeftNode());
                            child.setLeftNode(this.root.getLeftNode());
                        }
                    }
                    child.setRightNode(this.root.getRightNode());
                    this.root = child;
                }
            }else if(current.getRightNode() == null){
                if(parent.getLeftNode() == current){
                    parent.setLeftNode(current.getLeftNode());
                }else{
                    parent.setRightNode(current.getLeftNode());
                }
            }else if(current.getLeftNode() == null){
                if(parent.getLeftNode() == current){
                    parent.setLeftNode(current.getRightNode());
                }else{
                    parent.setRightNode(current.getRightNode());
                }
            }else{
                for (
                        temp = current, child = current.getLeftNode();
                        child.getRightNode() != null;
                        temp = child, child = child.getRightNode()
                ){
                    if(child != current.getLeftNode()){
                        temp.setRightNode(child.getLeftNode());
                        child.setLeftNode(current.getLeftNode());
                    }
                    child.setRightNode(current.getRightNode());
                    if(parent.getLeftNode() == current){
                        parent.setLeftNode(child);
                    }else{
                        parent.setRightNode(child);
                    }
                }
            }
        }catch (NullPointerException erro){
            System.out.println("Conteúdo não encontrado. Bloco catch");
        }
    }
}
