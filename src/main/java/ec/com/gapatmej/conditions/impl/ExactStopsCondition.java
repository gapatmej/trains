package ec.com.gapatmej.conditions.impl;

import ec.com.gapatmej.conditions.ITravelCondition;
import ec.com.gapatmej.entities.ITravel;

public class ExactStopsCondition<T> implements ITravelCondition<T> {

    private final int exactStops;

    public ExactStopsCondition(final int exactStops) {
        this.exactStops = exactStops;
    }

    @Override
    public boolean meetCondition(ITravel<T> travel) {
        return travel.getNumberOfTowns() == exactStops;
    }

}
