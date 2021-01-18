package ec.com.gapatmej.conditions.impl;

import ec.com.gapatmej.conditions.ITravelCondition;
import ec.com.gapatmej.entities.ITravel;

public class MaximumDistanceCondition<T> implements ITravelCondition<T> {

    private final int maxDistance;

    public MaximumDistanceCondition(final int maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public boolean meetCondition(final ITravel<T> travel) {
        return travel.getTotalTravelDistance() < maxDistance;
    }
}
