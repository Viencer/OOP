package com.company.command;

public class Invoker {

    private Command getSubordinates;
    private Command changeDepProject;
    private Command changeDepBoss;

    public Invoker(Command getSubordinates, Command changeDepProject, Command changeDepBoss) {
        this.getSubordinates = getSubordinates;
        this.changeDepProject = changeDepProject;
        this.changeDepBoss = changeDepBoss;
    }

    public void changeDepProject(int id, int option) {
        changeDepProject.execute(id, option);
    }

    public void getSubordinates(int id, int option) {
        getSubordinates.execute(id, option);
    }

    public void changeDepBoss(int id, int option) {
        changeDepBoss.execute(id, option);
    }
}
