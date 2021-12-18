package com.company.command;

public class GetSubordinates implements Command {

    private Receiver receiver;

    public GetSubordinates(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(int id, int option) {
        receiver.getSubordinates(id, option);
    }
}
