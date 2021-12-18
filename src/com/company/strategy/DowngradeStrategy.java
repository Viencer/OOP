package com.company.strategy;

import com.company.enums.Positions;

public class DowngradeStrategy implements PositionStrategy {

    @Override
    public Positions setPosition() {
        return Positions.EMPLOYEE;
    }
}
