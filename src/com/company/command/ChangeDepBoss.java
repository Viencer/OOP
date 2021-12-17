package com.company.command;

import com.company.interfaces.Command;

public class ChangeDepBoss implements Command {

    private Receiver receiver;

    public ChangeDepBoss(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(int id, int option) {
        receiver.changeDepBoss(id, option);
    }
}
