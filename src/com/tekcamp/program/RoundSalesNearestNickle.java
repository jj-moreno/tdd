package com.tekcamp.program;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundSalesNearestNickle implements ISalesRounder {

    @Override
    public double roundPrice(double price) {
        BigDecimal bigDecimal = new BigDecimal(price * 20 + 0.5);
        bigDecimal = bigDecimal.setScale(0, RoundingMode.HALF_EVEN);
        return bigDecimal.doubleValue() / 20;
    }
}
