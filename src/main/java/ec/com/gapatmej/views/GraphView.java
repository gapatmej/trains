package ec.com.gapatmej.views;

import ec.com.gapatmej.controller.GraphController;
import ec.com.gapatmej.controller.IOption;
import ec.com.gapatmej.enums.ToolBarOptionEnum;
import ec.com.gapatmej.exceptions.ReturnException;
import ec.com.gapatmej.utils.Constants;

import java.util.Scanner;


public class GraphView extends AbstractView {

    @Override
    public void draw() {
        clearConsole();

        view.append("**********************************************" + "\n");
        view.append("**********    Graph Constructor   ************" + "\n");
        view.append(ToolBarView.generateOptions(ToolBarOptionEnum.QUIT, ToolBarOptionEnum.RETURN) + "\n\n");
        view.append("______________________________________________" + "\n");
        view.append("______________________________________________" + "\n");
        view.append("**********    Considerations     *************" + "\n");
        view.append("Please, enter the graph with the next considerations : " + "\n");
        view.append("1. The towns is represented by only onw letter from A-Z" + "\n");
        view.append("2. The format for each way must be : townFrom(A-Z)townUntil(A-Z)distance. Example: AC5" + "\n");
        view.append("3. Each way must be separated by :" + Constants.WAYS_SEPARATOR + "\n");
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
            System.out.println("Input your Graph");
            String input = myObj.nextLine().replaceAll("\\s+","");
            try {
                ToolBarView.validateInput(input);
                IOption option = new GraphController(input,graph);
                messageOutput = new StringBuilder();
                messageOutput.append("The the proccess was : ");
                messageOutput.append(option.run());
                return;
            } catch (ReturnException ex) {
                return;
            } catch (Exception ex) {
                messageOutput = new StringBuilder(ex.getMessage());
            }
        }
    }


}
