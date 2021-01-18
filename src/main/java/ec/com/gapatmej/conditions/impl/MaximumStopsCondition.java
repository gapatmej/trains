package ec.com.gapatmej.conditions.impl;

import ec.com.gapatmej.conditions.ITravelCondition;
import ec.com.gapatmej.entities.ITravel;

public class MaximumStopsCondition<T> implements ITravelCondition<T> {

    private final int maximumStops;

    public MaximumStopsCondition(final int maximumStops) {
        this.maximumStops = maximumStops;
    }

    @Override
    public boolean meetCondition(final ITravel<T> travel) {
        return travel.getNumberOfTowns() <= maximumStops;
    }
}
