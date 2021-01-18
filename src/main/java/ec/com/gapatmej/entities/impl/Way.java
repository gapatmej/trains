package ec.com.gapatmej.entities.impl;

import ec.com.gapatmej.entities.IWay;

public class Way<T> implements IWay<T> {

    private final T startTown;
    private final T endTown;
    private final int distance;

    public Way(T start, T end) {
        this.startTown = start;
        this.endTown = end;
        this.distance = 0;
    }

    public Way(T start, T end, int distance) {
        this.startTown = start;
        this.endTown = end;
        this.distance = distance;
    }

    @Override
    public T getStartTown() {
        return this.startTown;
    }

    @Override
    public T getEndTown() {
        return this.endTown;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (endTown == null ? 0 : endTown.hashCode());
        result = prime * result + (startTown == null ? 0 : startTown.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Way way = (Way) obj;
        if (endTown == null) {
            if (way.endTown != null) {
                return false;
            }
        } else if (!endTown.equals(way.endTown)) {
            return false;
        }
        if (startTown == null) {
            if (way.startTown != null) {
                return false;
            }
        } else if (!startTown.equals(way.startTown)) {
            return false;
        }
        return true;
    }
}
