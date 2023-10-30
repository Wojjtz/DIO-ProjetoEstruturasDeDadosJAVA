package dio.arvore.model;

import dio.arvore.Comparable;

public abstract class ObjTree <T> implements Comparable<T> {

    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract int compareTo(T other);
    public abstract String toString();
}
