package ec.com.gapatmej.controller;

import ec.com.gapatmej.entities.IGraph;
import ec.com.gapatmej.entities.impl.Graph;
import ec.com.gapatmej.utils.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphController extends AbstractOption {

    public GraphController(String input, Graph graph) {
        super(input, graph);
    }

    @Override
    public String run() throws Exception {
        String[] ways = validateInput(getInput());

        for (String way : ways) {
            proccessWay(getGraph(), way);
        }
        return "Successfull";
    }

    @Override
    public String[] validateInput(String input) throws Exception {
        Pattern pattern = Pattern.compile(Constants.PATTERN_GRAPH);
        Matcher matcher = pattern.matcher(input);
        if(!matcher.find()) {
            throw new Exception("Your Graph is wrong. Please consider the instructions given");
        }
        return input.split(Constants.WAYS_SEPARATOR);

    }

    private void proccessWay(IGraph<String> graph, String way) {
        final String from = String.valueOf(way.trim().charAt(0));
        final String to = String.valueOf(way.trim().charAt(1));
        final int weight = Integer.valueOf(way.trim().substring(2));
        graph.addTown(from);
        graph.addTown(to);
        graph.addWay(from, to, weight);
    }
}
