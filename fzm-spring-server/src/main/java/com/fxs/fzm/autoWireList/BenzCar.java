package com.fxs.fzm.autoWireList;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order()
public class BenzCar implements ICarService{
    @Override
    public String getName() {
        return "奔驰车";
    }
}
