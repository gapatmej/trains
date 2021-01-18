package ec.com.gapatmej.conditions.impl;

import ec.com.gapatmej.conditions.ITravelCondition;
import ec.com.gapatmej.entities.ITravel;

public class InfinitiveCycleCondition<T> implements ITravelCondition<T> {

    @Override
    public boolean meetCondition(ITravel<T> travel) {
        return !travel.repeatWays();
    }
}
