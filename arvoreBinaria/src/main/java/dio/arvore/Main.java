package dio.arvore;

import dio.arvore.model.Obj;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Obj> arvore = new BinaryTree<Obj>();

        arvore.insert(new Obj(13));
        arvore.insert(new Obj(10));
        arvore.insert(new Obj(25));
        arvore.insert(new Obj(2));
        arvore.insert(new Obj(12));
        arvore.insert(new Obj(20));
        arvore.insert(new Obj(31));
        arvore.insert(new Obj(29));
        arvore.showInOrder();

        arvore.remove(new Obj(20));
        arvore.showInOrder();


    }
}
