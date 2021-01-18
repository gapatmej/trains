package ec.com.gapatmej.entities;


import ec.com.gapatmej.conditions.ITravelCondition;
import ec.com.gapatmej.exceptions.NotFoundTownException;
import ec.com.gapatmej.exceptions.NotFoundTravel;

import java.util.List;
import java.util.Set;

public interface IGraph<T> {

    void addTown(T town);

    void addWay(T from, T to, int weight);

    IWay<T> getWay(T from, T to);

    Set<T> getAllTowns();

    List<ITravel<T>> getTravelsByTowns(T from, T to, ITravelCondition<T> filter) throws NotFoundTravel;

    void validateTowns(T[] townsToValidate) throws NotFoundTownException;
}
