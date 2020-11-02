package com.demo.interviewdemo.genericityDemo;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:  泛型 类型 使用
 * @Author: jiahuiyang
 * @Date: Created in 15:07 2020/9/24
 */
public class GenericityDemo {


    /**
     * 果汁类  定义一个T泛型 代表水果种类
     * 泛型类型在定义的时候 可以写成一个大写字母或则某一范围
     * 在使用的时候在输入具体的类型或则某一范围类型（某一类型的全部子类 或则 某一类型的全部父类 或则不写，不写就默认接收所有类型包括基本类型int等）
     *
     * 定义范围泛型：T extends Object
     *
     * 使用范围泛型：? extends Object    ? super Object    ?(?是通赔所有类型，一般不会单独使用，一般会使用extends super进行限定)
     *
     * @param <T>
     */
    @Data
    static class FruitJuice<T> {

        /**
         * 水果种类
         */
        private T t;
        /**
         * 果汁颜色
         */
        private String color;
        /**
         * 果汁容积
         */
        private String volume;


    }


    /**
     * 苹果
     */
    @Data
    static class Apple {
        /**
         * 水果重量
         */
        private String weight;
    }

    static class BigApple extends Apple {
        private String big;
    }


    /**
     * 喝饮料
     */
    public static void drink(FruitJuice fruitJuice) {

    }

    public static void main(String[] args) {
        FruitJuice fruitJuice = new FruitJuice();

        fruitJuice.setColor("red");
        fruitJuice.setVolume("100");
        fruitJuice.setT(1);
        System.out.println(fruitJuice);
        //  GenericityDemo.FruitJuice(t=1, color=red, volume=100)
        //



        List<?> list = null;
        List<Object> list1 = new ArrayList<Object>();
        List<String> list2 = new ArrayList<String>();
        list = list1;
        list = list2;
    }



    /**
     *  填充 phoneId EmailId
     * partyCustomerUpdateRequestDTO 遍历
     */
   /* private void fillPartyCustomer(PartyCustomerUpdateRequestDTO partyCustomerUpdateRequestDTO, PartyResponseDTO partyResponseDTO) {
        if (partyCustomerUpdateRequestDTO != null && partyResponseDTO != null) {
            if (partyResponseDTO.getPartyCustomer() != null) {
                fillEmailId(partyCustomerUpdateRequestDTO.getEmails(), partyResponseDTO.getPartyCustomer().getEmails());
                fillPhoneId(partyCustomerUpdateRequestDTO.getPhones(), partyResponseDTO.getPartyCustomer().getPhones());
                return;
            }
            if (partyResponseDTO.getPartyCompany() != null) {
                fillEmailId(partyCustomerUpdateRequestDTO.getEmails(), partyResponseDTO.getPartyCompany().getEmails());
                fillPhoneId(partyCustomerUpdateRequestDTO.getPhones(), partyResponseDTO.getPartyCompany().getPhones());
            }
        }
    }*/


    private void fillPhoneId(List<PhoneBaseDTO> source, List<? extends PhoneBaseDTO> target) {
        if (CollectionUtils.isNotEmpty(source) && CollectionUtils.isNotEmpty(target)) {
            source.forEach(u->
                    target.forEach(v->{
                        if (u.getPhoneNo().equals(v.getPhoneNo())) {
                            u.setPhoneId(v.getPhoneId());
                        }
                    })
            );
        }
    }

    private void fillEmailId(List<EmailBaseDTO> source, List<? extends EmailBaseDTO> target) {
        if (CollectionUtils.isNotEmpty(source) && CollectionUtils.isNotEmpty(target)) {
            source.forEach(u-> target.forEach(v->{
                if (u.getEmail().equals(v.getEmail())) {
                    u.setEmailId(v.getEmailId());
                }
            }));
        }
    }


    @Data
    static class PhoneBaseDTO {

        private String phoneNo;

        private Long phoneId;

    }

    @Data
    static class PhoneExBaseDTO extends PhoneBaseDTO {
        private Boolean defult;
    }


    @Data
    static class EmailBaseDTO {

        private String email;
        private Long emailId;
    }

    @Data
    static class EmailExtBaseDTO extends EmailBaseDTO {
        private Boolean defult;
    }




}
