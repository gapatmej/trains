package ec.com.gapatmej.views;

import ec.com.gapatmej.controller.ExactStopsController;
import ec.com.gapatmej.controller.IOption;
import ec.com.gapatmej.controller.MaxStopsController;
import ec.com.gapatmej.enums.ToolBarOptionEnum;
import ec.com.gapatmej.exceptions.ReturnException;

import java.util.Scanner;

public class TravelsExactlyStopsView extends AbstractView {

    @Override
    public void draw() {
        clearConsole();

        view.append("**********************************************" + "\n");
        view.append("********    Travels Exactly Stops   **********" + "\n");
        view.append(ToolBarView.generateOptions(ToolBarOptionEnum.QUIT, ToolBarOptionEnum.RETURN) + "\n\n");
        view.append("______________________________________________" + "\n");
        view.append("______________________________________________" + "\n");
        view.append("**********    Considerations     *************" + "\n");
        view.append("Please, enter the towns with the next considerations : " + "\n");
        view.append("1. The towns is represented by only one letter from A-Z" + "\n");
        view.append("2. You must enter two towns " + "\n");
        view.append("3. The format must be : townFrom(A-Z)townUntil(A-Z)exactlyStops(0-9). Example: AC5 " + "\n");
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
                IOption option = new ExactStopsController(input,graph);
                messageOutput = new StringBuilder();
                messageOutput.append("The numbers of travels with your exactly stops are : ");
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
