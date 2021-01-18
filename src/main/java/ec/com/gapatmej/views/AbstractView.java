package ec.com.gapatmej.views;

import ec.com.gapatmej.entities.impl.Graph;

abstract class AbstractView implements IView {

    protected static Graph graph = new Graph();
    protected StringBuilder view =  new StringBuilder();
    protected static StringBuilder messageOutput = null;

    AbstractView(){
        getInput();
    }

    protected void clearConsole() {
        try {
            if(System.getProperty("os.name").equals("Mac OS X")){
                Runtime.getRuntime().exec("clear");
            }else{
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (Exception E) {
            System.out.println(E);
        }
    }
}
