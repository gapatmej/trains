package ec.com.gapatmej.views;

import ec.com.gapatmej.entities.impl.Graph;
import ec.com.gapatmej.entities.IGraph;
import ec.com.gapatmej.enums.OptionMenuEnum;
import ec.com.gapatmej.enums.ToolBarOptionEnum;
import ec.com.gapatmej.exceptions.InputWrongException;

import java.util.Arrays;
import java.util.Scanner;

public class MenuView extends AbstractView {

    @Override
    public void draw() {
        clearConsole();
        view.append("**********************************************" + "\n");
        view.append("***** Welcome to Trains System *******" + "\n\n");
        view.append(ToolBarView.generateOptions(ToolBarOptionEnum.QUIT) + "\n\n");
        for (OptionMenuEnum o : OptionMenuEnum.values()) {
            view.append(o.key() + ". " + o.description() + "\n");
        }
        if (messageOutput != null)
            view.append("Message :" + messageOutput);
        System.out.println(view.toString());
    }

    public void getInput() {
        IGraph graph = new Graph();
        boolean test = true;
        while (true) {
            test=false;
            draw();
            Scanner scan = new Scanner(System.in);
            System.out.println("Input an option");
            String input = scan.nextLine();
           // String input = "aassa";
            OptionMenuEnum optionSelected = null;
            try {
                ToolBarView.validateInput(input);
                optionSelected = Arrays.stream(OptionMenuEnum.values())
                        .filter(optionMenuEnum -> optionMenuEnum.key().equalsIgnoreCase(input))
                        .findFirst()
                        .orElseThrow(()-> new InputWrongException("Option not Found"));

                switch (optionSelected) {
                    case ADD_GRAPH:
                        new GraphView();
                        break;
                    case CALCULATE_DISTANCE:
                        new CalculateDistanceView();
                        break;
                    case TRAVELS_MAXIMUM_STOPS:
                        new TravelsMaximumStopsView();
                        break;
                    case TRAVELS_EXACTLY_STOPS:
                        new TravelsExactlyStopsView();
                        break;
                    case TRAVEL_SHORTEST:
                        new TravelShortestView();
                        break;
                    case TRAVELS_MAXIMUM_DISTANCE:
                        new TravelsMaximumDistanceView();
                        break;
                    default:
                }
            } catch (Exception ex) {
                messageOutput = new StringBuilder(ex.getMessage());
            }
        }
    }


}
