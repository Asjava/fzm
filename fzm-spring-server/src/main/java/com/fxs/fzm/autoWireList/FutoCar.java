package com.fxs.fzm.autoWireList;

import org.springframework.stereotype.Component;

@Component
public class FutoCar implements ICarService{


    @Override
    public String getName() {
        return "福特car";
    }
}
