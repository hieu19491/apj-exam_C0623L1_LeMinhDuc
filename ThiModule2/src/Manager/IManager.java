package Manager;

import java.util.ArrayList;

public interface IManager<T> {
    boolean add(T t);
    boolean edit(int index, T t);
    boolean delete(int index);
    ArrayList<T> findAll();
}
