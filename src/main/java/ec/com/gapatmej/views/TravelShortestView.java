package ec.com.gapatmej.views;

import ec.com.gapatmej.controller.ExactStopsController;
import ec.com.gapatmej.controller.IOption;
import ec.com.gapatmej.controller.ShortestTravelController;
import ec.com.gapatmej.enums.ToolBarOptionEnum;
import ec.com.gapatmej.exceptions.ReturnException;

import java.util.Scanner;

public class TravelShortestView extends AbstractView{

    @Override
    public void draw() {
        clearConsole();

        view.append("**********************************************" + "\n");
        view.append("**********     Travel Shortest   *************" + "\n");
        view.append(ToolBarView.generateOptions(ToolBarOptionEnum.QUIT, ToolBarOptionEnum.RETURN) + "\n\n");
        view.append("______________________________________________" + "\n");
        view.append("______________________________________________" + "\n");
        view.append("**********    Considerations     *************" + "\n");
        view.append("Please, enter the towns with the next considerations : " + "\n");
        view.append("1. The towns is represented by only one letter from A-Z" + "\n");
        view.append("2. The format must be : townFrom(A-Z)townUntil(A-Z). Example: AC " + "\n");
        view.append("3. You must enter two towns to calculate the shortest distance between these towns " + "\n");
        view.append("______________________________________________" + "\n");
        view.append("______________________________________________" + "\n");

        if (messageOutput != null)
            view.append("Message :" + messageOutput);

        System.out.println(view.toString());
    }

    @Override
    public void getInput() {
        while (true) {
            draw();
            Scanner myObj = new Scanner(System.in);
            System.out.println("Input your Towns");
            String input = myObj.nextLine().replaceAll("\\s+","");
            try {
                ToolBarView.validateInput(input);
                IOption option = new ShortestTravelController(input,graph);
                messageOutput = new StringBuilder();
                messageOutput.append("The distance shortest is : ");
                messageOutput.append(option.run());
                return;
            } catch (ReturnException ex) {
                messageOutput = null;
                return;
            } catch (Exception ex) {
                messageOutput = new StringBuilder(ex.getMessage());
            }
        }
    }
}
