package dio.filas;

public class Fila <T>{
    private No<T> refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null;
    }

    public void enqueue(T obj){
        No novoNo = new No(obj);
        novoNo.setRefNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }

    public T dequeue(){
        if(!isEmpty()){
            No auxNo = refNoEntradaFila;
            No primeiroNo = refNoEntradaFila;
            for (; primeiroNo.getRefNo() != null; primeiroNo = primeiroNo.getRefNo())
                auxNo = primeiroNo;

            auxNo.setRefNo(null);
            return (T) primeiroNo.getObject(); // cast
        }
        return null;
    }

    public T first(){
        if(!isEmpty()){
            No primeiroNo = refNoEntradaFila;
            for (; primeiroNo.getRefNo() != null; primeiroNo = primeiroNo.getRefNo()){}
            return (T) primeiroNo.getObject(); //cast
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null;
    }

    public String toString(){
        String retorno = "";
        No auxNo = refNoEntradaFila;

        if(refNoEntradaFila != null){
            while (true){
                retorno += "[No{objet=" + auxNo.getObject() + "}]--->";
                if (auxNo.getRefNo() != null){
                    auxNo = auxNo.getRefNo();
                }else{
                    retorno += "null";
                    break;
                }
            }
        }else{
            retorno = "null";
        }
        return retorno;
    }
}
