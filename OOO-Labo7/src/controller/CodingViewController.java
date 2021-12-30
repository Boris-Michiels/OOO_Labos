package controller;

import model.CodingFacade;
import model.CodingObserver;
import view.CodingView;

public class CodingViewController implements CodingObserver {
    CodingView codingView;
    CodingFacade codingFacade;

    public CodingViewController(CodingView codingView, CodingFacade codingFacade) {
        this.codingView = codingView;
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
