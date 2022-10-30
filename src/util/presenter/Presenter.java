package util.presenter;

import java.util.ArrayList;

public interface Presenter<T> {
    void print(T t);

    void printAll(ArrayList<T> list);
}
