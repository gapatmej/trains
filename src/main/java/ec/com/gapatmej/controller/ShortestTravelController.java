package ec.com.gapatmej.controller;

import ec.com.gapatmej.conditions.impl.InfinitiveCycleCondition;
import ec.com.gapatmej.entities.IGraph;
import ec.com.gapatmej.entities.ITravel;
import ec.com.gapatmej.exceptions.NotFoundTravel;
import ec.com.gapatmej.utils.Constants;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShortestTravelController extends AbstractOption {

    public ShortestTravelController(String commandLine, IGraph graph) {
        super(commandLine, graph);
    }

    @Override
    public String run() throws Exception {
        String[] input = validateInput(getInput());
        String start = String.valueOf(input[0]);
        String end = String.valueOf(input[1]);

        return String.valueOf(shortestTravel(getGraph(), start, end));
    }

    @Override
    public String[] validateInput(String input) throws Exception {
        Pattern pattern = Pattern.compile(Constants.PATTERN_SHORTEST_DISTANCE);
        Matcher matcher = pattern.matcher(input);
        if(!matcher.find()) {
            throw new Exception("Your input is wrong. Please consider the instructions given");
        }

        String[] towns = {String.valueOf(input.charAt(0)),String.valueOf(input.charAt(1))};
        getGraph().validateTowns(towns);

        return towns;
    }

    public int shortestTravel(IGraph graph, String start, String end) throws NotFoundTravel {
        final List<ITravel<String>> travels = graph.getTravelsByTowns(start, end,
                new InfinitiveCycleCondition());
        return Collections.min(travels).getTotalTravelDistance();
    }
}
