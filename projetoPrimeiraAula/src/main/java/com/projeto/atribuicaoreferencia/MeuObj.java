package com.projeto.atribuicaoreferencia;

public class MeuObj {

    Integer num;

    public MeuObj(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String toString(){
        return this.num.toString();
    }
}
