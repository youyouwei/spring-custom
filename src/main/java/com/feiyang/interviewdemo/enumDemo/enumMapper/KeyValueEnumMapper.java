package com.feiyang.interviewdemo.enumDemo.enumMapper;

import org.mapstruct.Mapper;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

/**
 * @Description:  KeyValueEnumMapper就是用来转换code和Enum的 mapstruct mapper 可以直接通过 Mappers.getMapper( KeyValueEnumMapper.class );使用 或则是通过@Mapper(uses = KeyValueEnumMapper.class) 包含在其他mapper中
 * @Author: jiahuiyang
 * @Date: Created in 14:17 2020/7/8
 */
@Mapper
public interface KeyValueEnumMapper {

    KeyValueEnumMapper INSTANCE = Mappers.getMapper(KeyValueEnumMapper.class);

    /**
     * Mapper 转换 枚举转Code 值
     * @param keyValueEnum
     * @return
     */
    default Integer getCodeAsInt(KeyValueEnum keyValueEnum) {
        return keyValueEnum == null ? null : (Integer) keyValueEnum.getCode();
    }

    /**
     *
     * @param keyValueEnum
     * @return
     */
    default Long getCodeAsLong(KeyValueEnum keyValueEnum) {
        Integer intResult = getCodeAsInt(keyValueEnum);
        return intResult == null ? null : Long.valueOf(intResult);
    }

    /**
     *
     * @param keyValueEnum
     * @return
     */
    default String getCodeAsString(KeyValueEnum keyValueEnum) {
        return keyValueEnum == null ? null : (String) keyValueEnum.getCode();
    }

    /**
     * 通过code转枚举 当code是Integer时
     * @param tClass 通过 mapstruct 获取目标类型的Class
     * @param code
     * @param <T>
     * @return
     */
    default <T extends Enum<T> & KeyValueEnum> T getKeyValueEnum(@TargetType Class<T> tClass, Integer code) {
        return EnumUtil.getEnumByCode(tClass, code);
    }

    default <T extends Enum<T> & KeyValueEnum> T getKeyValueEnum(@TargetType Class<T> tClass, Long code) {
        return EnumUtil.getEnumByCode(tClass, code.intValue());
    }

    default <T extends Enum<T> & KeyValueEnum> T getKeyValueEnum(@TargetType Class<T> tClass, String code) {
        return EnumUtil.getEnumByCode(tClass, code);
    }



}
