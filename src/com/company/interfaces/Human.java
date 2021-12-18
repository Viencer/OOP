package com.company.interfaces;

import com.company.enums.Projects;
import com.company.pojo.Task;
import com.company.enums.Positions;
import com.company.strategy.PositionStrategy;

import java.util.List;
import java.util.Map;

public interface Human {

    void buildHierarchyTree(Human emp);

    List<Human> getSubsById(int managerId);

    String getBoss();

    int getId();

    int getManagerId();

    String getName();

    List<Human> getSubordinates();

    void setSubordinates(List<Human> subordinates);

    Map<Integer, Human> getDataBase();

    void setDataBase(Map<Integer, Human> dataBase);

    Positions getPosition();

    String report();

    void setTask(Task task);

    Task getTask();

    void setManagerId(int managerId);

    void changePosition();

    void setPositionStrategy(PositionStrategy positionStrategy);

    void updateProject(Projects project);

    void updateProjectSilent(Projects project);
}
