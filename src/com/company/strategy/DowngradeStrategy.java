package com.company.strategy;

import com.company.interfaces.PositionStrategy;

public class DowngradeStrategy implements PositionStrategy {

    @Override
    public String setPosition() {
        return "Employee";
    }
}
