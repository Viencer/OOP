package com.company.interfaces;

import com.company.company_structure.Department;
import com.company.pojo.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BusinessStructure {

    void createDataBase(String[] data);

    void getHierarchyOfCompany();

    Human getBoss();

    Human getEmployeeById(int id);

    Map<Integer, Human> getDataBase();

    List<Task> getTasks();

    void addTasks(Task task);

    void setTasks(List<Task> tasks);

    Map<Integer, Department> getDepartments();

}
