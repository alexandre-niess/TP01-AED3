package aed3;

public interface RegistroArvoreBMais<T> {
    public int compareTo(T obj);
    public T clone();
    public byte[] toByteArray() throws java.io.IOException;
    public void fromByteArray(byte[] ba) throws java.io.IOException;
    public int size();
}
