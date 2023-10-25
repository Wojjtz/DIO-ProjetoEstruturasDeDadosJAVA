package dio.pilhas;

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    public void push(No novoNo){
        No aux = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setRefNo(aux);
    }

    public No pop(){
        if(!isEmpty()){
            No noPopped = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
            return noPopped;
        }
        return null;
    }

    public No top(){
        return refNoEntradaPilha;
    }

    public boolean isEmpty(){
        return refNoEntradaPilha == null;
    }

    @Override
    public String toString() {
        String retorno = "------------------\nPilha:\n";
        No aux = refNoEntradaPilha;

        while(true){
            if(aux != null){
                retorno += "[No{dado=" + aux.getDado() +"}]\n";
                aux = aux.getRefNo();
            }else{
                break;
            }
        }
        retorno += "------------------";
        return retorno;
    }
}
