package ec.com.gapatmej.entities.impl;

import ec.com.gapatmej.conditions.ITravelCondition;
import ec.com.gapatmej.entities.IGraph;
import ec.com.gapatmej.entities.ITravel;
import ec.com.gapatmej.entities.IWay;
import ec.com.gapatmej.exceptions.NotFoundTownException;
import ec.com.gapatmej.exceptions.NotFoundTravel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T> implements IGraph<T> {

    private final Map<T, Set<IWay<T>>> towns = new HashMap<T, Set<IWay<T>>>();

    @Override
    public void addTown(T town) {
        if (!towns.containsKey(town)) {
            towns.put(town, new LinkedHashSet<IWay<T>>());
        }
    }

    @Override
    public void addWay(T from, T to, int weight) {

        final IWay<T> way = new Way(from,to,weight);

        final Set<IWay<T>> ways = towns.get(from);

        if (ways.contains(way)) {
            ways.remove(way);
        }

        ways.add(way);
    }

    @Override
    public IWay<T> getWay(T from, T to) {

        final Set<IWay<T>> ways = towns.get(from);
        for (final IWay<T> way : ways) {
            if (way.getEndTown().equals(to)) {
                return way;
            }
        }
        return null;
    }

    @Override
    public Set<T> getAllTowns() {
        return Collections.unmodifiableSet(towns.keySet());
    }

    @Override
    public void validateTowns(T[] townsToValidate) throws NotFoundTownException {
        for(T town : townsToValidate){
            if (!towns.containsKey(town)) {
                throw new NotFoundTownException("The Town " + town.toString() + " doesn't exist");
            }
        }
    }

    @Override
    public List<ITravel<T>> getTravelsByTowns(T from, T to, ITravelCondition<T> condition) throws NotFoundTravel {
        final List<ITravel<T>> travels = new ArrayList<ITravel<T>>();
        Set<IWay<T>> ways = towns.get(from);
        for (IWay<T> way : ways) {
            ITravel<T> travel = new Travel<T>();
            travel.addWay(way);
            travels.addAll(search(travel, condition, to));
        }

        if (travels.isEmpty()) {
            throw new NotFoundTravel();
        }
        return travels;
    }

    private List<ITravel<T>> search(final ITravel<T> travel, final ITravelCondition<T> condition, final T to) {
        final List<ITravel<T>> travels = new ArrayList<ITravel<T>>();
        if (condition.meetCondition(travel)) {
            if (hasEndDestination(travel, to)) {
                travels.add(Travel.cloneTravel(travel));
            }
            Set<IWay<T>> ways = towns.get(travel.getLastTown());
            for (final IWay<T> way : ways) {
                travel.addWay(way);
                travels.addAll(search(travel, condition, to));
            }

        }
        travel.removeLastTown();
        return travels;
    }

    private boolean hasEndDestination(final ITravel<T> travel, final T end) {
        return travel.getLastTown().equals(end);
    }

}
