package com.company;

public class Task {

    private static int count = 1;
    private int id;
    private final int departmentId;
    private final String name;

    public Task(int departmentId, String name) {
        this.id = count++;
        this.departmentId = departmentId;
        this.name = name + "" + id;
    }

    public String getName() {
        return name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                " departmentId=" + departmentId +
                ", name='" + name + '\'' +
                '}';
    }
}
