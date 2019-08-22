package com.feiyang.service;

import java.math.BigDecimal;

public interface Bank {

    BigDecimal consume(BigDecimal amount);

    BigDecimal income(BigDecimal amount);

    BigDecimal balance();
}
