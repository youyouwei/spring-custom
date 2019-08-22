package com.feiyang.service.imp;

import com.feiyang.annotation.Pay;
import com.feiyang.service.Bank;

import java.math.BigDecimal;

//TODO 在非spring容器中的bean中注入spring bean  如注入mapper

@Pay("ABC")
public class ABCBankImp implements Bank {
    @Override
    public BigDecimal consume(BigDecimal amount) {
        return null;
    }

    @Override
    public BigDecimal income(BigDecimal amount) {
        return null;
    }

    @Override
    public BigDecimal balance() {
        return null;
    }
}
