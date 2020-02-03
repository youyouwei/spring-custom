package com.feiyang.interviewdemo.springcontext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:50 2019/11/19
 */
@Service
public class MedicineService {
    public void eatMedicine() {
        System.out.println("eat medicine");
    }
}
