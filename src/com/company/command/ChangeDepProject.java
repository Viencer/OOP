package com.company.command;

import com.company.interfaces.Command;

public class ChangeDepProject implements Command {

    private Receiver receiver;

    public ChangeDepProject(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(int id, int option) {
        receiver.changeDepProject(id, option);
    }
}
