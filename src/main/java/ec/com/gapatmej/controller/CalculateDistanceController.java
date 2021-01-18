package ec.com.gapatmej.controller;

import ec.com.gapatmej.conditions.impl.StartWithCondition;
import ec.com.gapatmej.entities.IGraph;
import ec.com.gapatmej.entities.ITravel;
import ec.com.gapatmej.entities.impl.Travel;
import ec.com.gapatmej.entities.impl.Way;
import ec.com.gapatmej.utils.Constants;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateDistanceController extends AbstractOption{

    public CalculateDistanceController(String input, IGraph graph) {
        super(input, graph);
    }

    @Override
    public String run() throws Exception {
        String[] towns = (String[]) validateInput(getInput());
        String start = String.valueOf(towns[0]);
        String end = String.valueOf(towns[towns.length - 1]);
        String[] middleTowns = towns.length>2?ArrayUtils.subarray(towns,1,towns.length -1 ):null;

        final ITravel<String> totalTravel = createTravel(start, end, middleTowns);
        final List<ITravel<String>> travelsByTowns = getGraph().getTravelsByTowns(start, end, new StartWithCondition(
                totalTravel));

        return String.valueOf(travelsByTowns.get(0).getTotalTravelDistance());

    }

    @Override
    public Object validateInput(String input) throws Exception {
        Pattern pattern = Pattern.compile(Constants.PATTERN_CALCULATE_DISTANCE);
        Matcher matcher = pattern.matcher(input);
        if(!matcher.find()) {
            throw new Exception("Your Input is wrong. Please consider the instructions given");
        }
        String[] towns = input.split("");
        getGraph().validateTowns(towns);

        return towns;
    }

    protected ITravel<String> createTravel(String from, String to, String[] middleTowns) {
        final ITravel<String> travel = new Travel<>();
        String currentTown = from;
        if (middleTowns != null) {
            for (final String town : middleTowns) {
                travel.addWay(new Way<>(currentTown, town));
                currentTown = town;
            }
        }
        travel.addWay(new Way<>(currentTown, to));
        return travel;
    }
}
