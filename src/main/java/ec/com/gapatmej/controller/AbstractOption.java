package ec.com.gapatmej.controller;


import ec.com.gapatmej.entities.IGraph;

abstract class AbstractOption implements IOption {

    private final String input;
    private final IGraph graph;

    protected AbstractOption(String input, IGraph graph) {
        this.input = input;
        this.graph = graph;
    }

    protected final String getInput() {
        return input;
    }

    protected final IGraph getGraph() {
        return graph;
    }

}
