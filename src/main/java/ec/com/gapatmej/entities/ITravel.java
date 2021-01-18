package ec.com.gapatmej.entities;

import java.util.List;

public interface ITravel<T> extends Comparable<ITravel<T>> {

    void addWay(IWay<T> way);

    T getLastTown();

    void removeLastTown();

    List<IWay<T>> getWays();

    boolean repeatWays();

    boolean startsWith(ITravel<T> travel);

    int getTotalTravelDistance();

    int getNumberOfTowns();
}
