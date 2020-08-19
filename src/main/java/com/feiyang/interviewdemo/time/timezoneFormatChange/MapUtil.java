package com.feiyang.interviewdemo.time.timezoneFormatChange;


import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.*;

public class MapUtil {
    public MapUtil() {
    }

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) {
        Object obj = null;
        if (map == null) {
            return null;
        } else {
            try {
                obj = beanClass.newInstance();
                Field[] fields = obj.getClass().getDeclaredFields();
                Field[] var4 = fields;
                int var5 = fields.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    Field field = var4[var6];
                    int mod = field.getModifiers();
                    if (!Modifier.isStatic(mod) && !Modifier.isFinal(mod)) {
                        field.setAccessible(true);
                        field.set(obj, map.get(field.getName()));
                    }
                }
            } catch (Exception var9) {
                var9.printStackTrace();
            }

            return obj;
        }
    }

    public static Map<String, Object> objectToMap(Object obj) {
        HashMap map = new HashMap();

        try {
            if (obj == null) {
                return null;
            }

            Field[] declaredFields = obj.getClass().getDeclaredFields();
            Field[] var3 = declaredFields;
            int var4 = declaredFields.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Field field = var3[var5];
                field.setAccessible(true);
                if (field.get(obj) instanceof String) {
                    if (field.get(obj) != null && !field.get(obj).equals("")) {
                        map.put(field.getName(), field.get(obj));
                    }
                } else if (field.get(obj) instanceof Long) {
                    if (field.get(obj) != null) {
                        map.put(field.getName(), String.valueOf(field.get(obj)));
                    }
                } else if (field.get(obj) instanceof Integer) {
                    if (field.get(obj) != null) {
                        map.put(field.getName(), String.valueOf(field.get(obj)));
                    }
                } else if (!(field.get(obj) instanceof Date)) {
                    if (field.get(obj) instanceof Double) {
                        if (field.get(obj) != null) {
                            map.put(field.getName(), String.valueOf(field.get(obj)));
                        }
                    } else if (field.get(obj) instanceof Float) {
                        if (field.get(obj) != null) {
                            map.put(field.getName(), String.valueOf(field.get(obj)));
                        }
                    } else if (field.get(obj) instanceof BigInteger) {
                        if (field.get(obj) != null) {
                            map.put(field.getName(), String.valueOf(field.get(obj)));
                        }
                    } else if (field.get(obj) instanceof Short) {
                        if (field.get(obj) != null) {
                            map.put(field.getName(), String.valueOf(field.get(obj)));
                        }
                    } else if (field.get(obj) instanceof BigInteger) {
                        if (field.get(obj) != null) {
                            map.put(field.getName(), String.valueOf(field.get(obj)));
                        }
                    } else if (field.get(obj) != null) {
                        map.put(field.getName(), field.get(obj));
                    }
                }
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return map;
    }

    public static List<Map> listObj2MapList(Object... obj) {
        List<Map> list = new ArrayList();
        Object[] var2 = obj;
        int var3 = obj.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object var10000 = var2[var4];
            list.add(objectToMap(obj));
        }

        return list;
    }

    public static <K, V> Map removeEntries(Map<K, V> map, K[] excludeKeys) {
        Iterator iterator = map.keySet().iterator();

        while(iterator.hasNext()) {
            K k = (K) iterator.next();
            if (ArrayUtils.contains(excludeKeys, k)) {
                iterator.remove();
                map.remove(k);
            }
        }

        return map;
    }
}

