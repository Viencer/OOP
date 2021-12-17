package com.company.employees;

import com.company.employees.HumanImpl;
import com.company.enums.Positions;
import com.company.strategy.DowngradeStrategy;

public class DepBoss extends HumanImpl {

    public DepBoss(int id, String name, int managerId, Positions position) {
        super(id, name, managerId, position);
        this.positionStrategy = new DowngradeStrategy();
    }

    public DepBoss() {
    }
}
