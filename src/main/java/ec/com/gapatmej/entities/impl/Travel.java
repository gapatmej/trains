package ec.com.gapatmej.entities.impl;

import ec.com.gapatmej.entities.ITravel;
import ec.com.gapatmej.entities.IWay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Travel<T> implements ITravel<T> {

    private final List<IWay<T>> ways = new ArrayList<>();
    private int totalDistance = 0;

    private boolean wayIsAfter(IWay<T> way) {
        T lastTown = getLastTown();
        if (lastTown != null && !lastTown.equals(way.getStartTown())) {
            return false;
        }
        return true;
    }

    public Travel() {
    }

    private Travel(ITravel<T> travelToCopy) {
        ways.addAll(travelToCopy.getWays());
        this.totalDistance = travelToCopy.getTotalTravelDistance();
    }

    public static <T> ITravel<T> cloneTravel(ITravel<T> travelToCopy) {
        return new Travel<>(travelToCopy);
    }

    @Override
    public void addWay(IWay<T> way) {
        ways.add(way);
        totalDistance += way.getDistance();
    }

    @Override
    public T getLastTown() {
        T town = null;
        if (!ways.isEmpty()) {
            town = ways.get(ways.size() - 1).getEndTown();
        }
        return town;
    }

    @Override
    public void removeLastTown() {
        if (!ways.isEmpty()) {
            IWay<T> lastWay = ways.get(ways.size() - 1);
            this.totalDistance -= lastWay.getDistance();
            ways.remove(ways.size() - 1);
        }
    }

    @Override
    public List<IWay<T>> getWays() {
        return Collections.unmodifiableList(ways);
    }

    @Override
    public boolean repeatWays() {
        for (int i = 0; i < ways.size(); i++) {
            for (int j = i + 1; j < ways.size(); j++) {
                if (ways.get(i).equals(ways.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean startsWith(ITravel<T> travel) {
        List<IWay<T>> ways = travel.getWays();
        List<IWay<T>> totalWays = getWays();
        for (int i = 0; i < ways.size(); i++) {
            if (i >= totalWays.size() || !ways.get(i).equals(totalWays.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int getTotalTravelDistance() {
        return totalDistance;
    }

    @Override
    public int getNumberOfTowns() {
        return ways.size();
    }

    @Override
    public int compareTo(ITravel<T> travel) {
        return this.getTotalTravelDistance() - travel.getTotalTravelDistance();
    }
}
