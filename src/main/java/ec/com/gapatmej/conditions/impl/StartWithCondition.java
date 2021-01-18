package ec.com.gapatmej.conditions.impl;

import ec.com.gapatmej.conditions.ITravelCondition;
import ec.com.gapatmej.entities.ITravel;

public class StartWithCondition<T> implements ITravelCondition<T> {

    private final ITravel<T> totalTravel;

    public StartWithCondition(final ITravel<T> totalTravel) {
        this.totalTravel = totalTravel;
    }

    @Override
    public boolean meetCondition(ITravel<T> travel) {
        return totalTravel.startsWith(travel);
    }
}
