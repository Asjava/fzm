package com.fxs.fzm;

import com.fxs.fzm.autoWireList.CarList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FzmApplicationTests {
    @Autowired
    private CarList carList;

    @Test
    void contextLoads() {
        carList.getCarList();
    }

}
