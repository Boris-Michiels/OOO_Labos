package domain;

public enum BankEvent {
    REKENING_OPENED ("Rekening geopend"),
    MONEY_DEPOSITED ("Geld gestort"),
    MONEY_WITHDRAWN ("Geld afgehaald");

    private String eventName;

    BankEvent(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return this.eventName;
    }
}
