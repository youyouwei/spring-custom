package com.demo.interviewdemo.springDemo.springStrategy;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:25 2020/5/21
 */
@Component
public class ClaimCustomerChangeProcessorImpl implements ICustomerChangeProcessor<Object, Void> {

    public static final String PROCESS_NAME = "claimCustomerChangeProcessorImpl";


    @Override
    public Void process(Object personExtBaseDTO) {
//        invokeClaim(personExtBaseDTO);
        return null;
    }

    @Override
    public String getProcessName() {
        return PROCESS_NAME;
    }


}
