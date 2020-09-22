package com.demo.interviewdemo.springDemo.springStrategy;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:23 2020/5/21
 */
@Component
public class PosCustomerChangeProcessorImpl implements ICustomerChangeProcessor<String, Integer>   {

    public static final String PROCESS_NAME = "posCustomerChangeProcessorImpl";


    @Override
    public Integer process(String personExtBaseDTO) {
//        return invokePos(personExtBaseDTO);
        return null;
    }

    @Override
    public String getProcessName() {
        return PROCESS_NAME;
    }



}
