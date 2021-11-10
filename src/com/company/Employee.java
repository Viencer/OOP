package com.company;

import java.util.List;
import java.util.Map;

public interface Employee {

    void buildHierarchyTree(Employee emp);

    List<Employee> getSubsById(int managerId);

    String getBoss();

    int getId();

    int getManagerId();

    String getName();

    List<Employee> getSubordinates();

    void setSubordinates(List<Employee> subordinates);

    Map<Integer, Employee> getDataBase();

    void setDataBase(Map<Integer, Employee> dataBase);

    String getPosition();

    String report();

    void setTask(Task task);

    Task getTask();

    void setManagerId(int managerId);
}
