package ec.com.gapatmej.entities;

public interface IWay<T> {

    T getStartTown();

    T getEndTown();

    int getDistance();
}
