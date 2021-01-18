package ec.com.gapatmej.views;

import ec.com.gapatmej.enums.ToolBarOptionEnum;
import ec.com.gapatmej.exceptions.ReturnException;

public class ToolBarView {

    public static String generateOptions(ToolBarOptionEnum... args) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder = new StringBuilder();
        strBuilder.append("############   OPTIONS   ##############" + "\n");
        for (ToolBarOptionEnum t : args) {
            strBuilder.append(t.key() + " = " + t.description() + "\n");
        }
        strBuilder.append("#######################################");

        return strBuilder.toString();
    }

    public static void validateInput(String input ) throws ReturnException {
        if(ToolBarOptionEnum.QUIT.key().toString().equals(input.toUpperCase())){
            System.exit(0);
        }
        if(ToolBarOptionEnum.RETURN.key().toString().equals(input.toUpperCase())){
            throw new ReturnException();
        }
    }
}
