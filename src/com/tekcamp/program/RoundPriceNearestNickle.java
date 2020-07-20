package com.tekcamp.program;

public class RoundPriceNearestNickle implements IPriceRounder {

    @Override
    public double roundPrice(double price) {
        return ((int) (price * 20 + 0.5)) / 20.0;
    }
}
