package com.demo.interviewdemo.httpAndHttpsAPIDemo;

import java.security.cert.X509Extension;
import java.util.Set;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-25 20:49
 **/
public class MyX509TrustManager implements X509Extension {

    @Override
    public boolean hasUnsupportedCriticalExtension() {
        return false;
    }

    @Override
    public Set<String> getCriticalExtensionOIDs() {
        return null;
    }

    @Override
    public Set<String> getNonCriticalExtensionOIDs() {
        return null;
    }

    @Override
    public byte[] getExtensionValue(String oid) {
        return new byte[0];
    }
}
