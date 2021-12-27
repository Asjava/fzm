package com.fxs.fzm.autoWireList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarList {
    @Autowired
    private List<ICarService> carlist;

    public void getCarList(){
        for (ICarService iCarService : carlist) {
            if (iCarService instanceof BenzCar) {
                System.out.println(iCarService.getName());
            }
        }
        // 注入集合排序
        AnnotationAwareOrderComparator.sort(carlist);
    }
}
