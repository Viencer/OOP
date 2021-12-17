package com.company.interfaces;

import com.company.enums.Projects;

public interface ProjectObserver {
    void setProject(Projects project);
    void addEmployee(Human human);
    void notifyEmployees();
}
