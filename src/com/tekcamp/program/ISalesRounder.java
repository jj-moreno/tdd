package com.tekcamp.program;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface ISalesRounder {

    double roundPrice(double price);

    default double roundTwoDecimalPlaces(double decimal) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(decimal));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_EVEN);
        return bigDecimal.doubleValue();
    }
}
