package controller;

import model.CodingFacade;
import model.CodingObserver;
import view.LogView;

public class LogViewController implements CodingObserver {
    LogView logView;
    CodingFacade codingFacade;

    public LogViewController(LogView logView, CodingFacade codingFacade) {
        this.logView = logView;
        this.codingFacade = codingFacade;
        this.codingFacade.addObserver(this);
    }

    @Override
    public void update() {
        display();
    }

    private void display() {

    }
}
