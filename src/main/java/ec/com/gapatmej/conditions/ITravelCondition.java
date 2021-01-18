package ec.com.gapatmej.conditions;

import ec.com.gapatmej.entities.ITravel;

public interface ITravelCondition<T> {
    boolean meetCondition(final ITravel<T> travel);
}
