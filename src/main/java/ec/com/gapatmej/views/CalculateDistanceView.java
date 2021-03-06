package ec.com.gapatmej.views;

import ec.com.gapatmej.controller.CalculateDistanceController;
import ec.com.gapatmej.controller.IOption;
import ec.com.gapatmej.enums.ToolBarOptionEnum;
import ec.com.gapatmej.exceptions.ReturnException;

import java.util.Scanner;

public class CalculateDistanceView extends AbstractView {

    @Override
    public void draw() {
        clearConsole();

        view.append("**********************************************" + "\n");
        view.append("*********    Calculate Distance   ************" + "\n");
        view.append(ToolBarView.generateOptions(ToolBarOptionEnum.QUIT, ToolBarOptionEnum.RETURN) + "\n\n");
        view.append("______________________________________________" + "\n");
        view.append("______________________________________________" + "\n");
        view.append("**********    Considerations     *************" + "\n");
        view.append("Please, enter the towns with the next considerations : " + "\n");
        view.append("1. The towns is represented by only one letter from A-Z" + "\n");
        view.append("2. The format must be : town(A-Z)town(A-Z)... . Example: AC... " + "\n");
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
                IOption option = new CalculateDistanceController(input,graph);
                messageOutput = new StringBuilder();
                messageOutput.append("The Distance calculated is : ");
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
