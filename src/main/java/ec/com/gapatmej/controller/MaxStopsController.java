package ec.com.gapatmej.controller;

import ec.com.gapatmej.conditions.impl.MaximumStopsCondition;
import ec.com.gapatmej.entities.IGraph;
import ec.com.gapatmej.utils.Constants;
import org.apache.commons.lang3.ArrayUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxStopsController extends AbstractOption {

    public MaxStopsController(String input, IGraph graph) {
        super(input, graph);
    }

    @Override
    public String run() throws Exception {
        String[] input = validateInput(getInput());
        String start = String.valueOf(input[0]);
        String end = String.valueOf(input[1]);
        int maxStops = Integer.parseInt(input[2]);

        int numberOfTrips = getGraph().getTravelsByTowns(start, end, new MaximumStopsCondition<String>(maxStops)).size();
        return String.valueOf(numberOfTrips);

    }

    @Override
    public String[] validateInput(String input) throws Exception {
        Pattern pattern = Pattern.compile(Constants.PATTERN_TRAVELS_MAXIMUM_STOPS);
        Matcher matcher = pattern.matcher(input);
        if(!matcher.find()) {
            throw new Exception("Your input is wrong. Please consider the instructions given");
        }
        String[] towns = {String.valueOf(input.charAt(0)),String.valueOf(input.charAt(1))};
        getGraph().validateTowns(towns);

        return ArrayUtils.addAll(towns, new String[]{input.substring(2)});

    }

}
