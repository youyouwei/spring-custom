package com.feiyang.interviewdemo.java8Demo.collectionStreamDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description: 集合 stream 操作
 * @Author: jiahuiyang
 * @Date: Created in 10:34 2019/11/8
 */
public class StreamDemo {

    public static void main(String[] args) {

    }


    /*集合stream流处理 返回optional处理 并且判断*/
   /* private Date getAgreementStatusByEs(BriefPolicyRequestDTO briefPolicyRequestDTO) {
        List<String> list = Arrays.asList();

        List<Date> list = new ArrayList<>(1);
        ResultBase<EsPageResponseDTO<BriefPolicyResponseDTO>> resultBase = cdcShareService
                .searchPolicyList(briefPolicyRequestDTO);
        if (null != resultBase && resultBase.isSuccess() && null != resultBase.getValue()
                && resultBase.getValue().isSuccess()
                && CollectionUtils.isNotEmpty(resultBase.getValue().getHitData())) {

            resultBase.getValue().getHitData().stream().filter(u -> u.getPolicyAgreementResponseDTO().getAgreementStatus() == 0).findAny().ifPresent(v->{
                if (CollectionUtils.isNotEmpty(v.getPolicyProducts())) {
                    list.add(v.getPolicyProducts().get(0).getStatusChangeDate());
                }
            });
        }
        return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;

    }*/

}
