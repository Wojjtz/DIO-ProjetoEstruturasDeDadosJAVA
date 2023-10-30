package dio.arvore.model;

import java.util.Objects;

public class Obj extends ObjTree<Obj>{
    Integer value;

    public Obj(Integer value){
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Obj obj = (Obj) object;
        return Objects.equals(value, obj.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Obj other) {
        int i = 0;
        if(this.value > other.value){
            i = 1;
        }else if(this.value < other.value){
            i = -1;
        }
        return i;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
