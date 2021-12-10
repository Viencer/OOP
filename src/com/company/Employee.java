package com.company;

import com.company.enums.Positions;
import com.company.interfaces.Human;
import com.company.strategy.DowngradeStrategy;
import com.company.strategy.UpgradeStrategy;

import java.util.List;

public class Employee extends HumanImpl {

    public Employee(int id, String name, int managerId, Positions position) {
        super(id, name, managerId, position);
        this.positionStrategy = new UpgradeStrategy();
    }

    public Employee() {
    }
}
