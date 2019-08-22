package com.feiyang.interviewdemo.designMode.prototypeMode;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-08-12 14:49
 **/
public class CookieMachine {
    private Cookie cookie;

    public CookieMachine(Cookie cookie) {
        this.cookie = cookie;
    }

    public Cookie makeCookie() {
        try {
            return (Cookie) cookie.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //待创建 临时cookie
        Cookie tempCookie = null;
        //cookie 原型
        Cookie prot = new CoconutCookie();
        //加入原型 开始克隆
        CookieMachine cookieMachine = new CookieMachine(prot);

        for (int i = 0; i < 100; i++) {
            tempCookie = cookieMachine.makeCookie();
        }

    }

}
