package com.boyi.hospital.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ObjectUtils;

/**
 * 支付方式枚举类
 *
 * @author <a href="https://github.com/JavaBo14">Bo</a>
 *
 */
public enum PayTypeEnum {

    WEIXIN("微信", "WX"),
    MEDICAL_INSURANCE("医保", "INSUR");

    private final String text;
    private final String value;

    PayTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取所有支付方式值的列表
     *
     * @return String 类型的支付方式值列表
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(PayTypeEnum::getValue).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value String 类型的支付方式值
     * @return 对应的枚举
     */
    public static PayTypeEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (PayTypeEnum anEnum : PayTypeEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    /**
     * 根据 text 获取枚举
     *
     * @param text String 类型的支付方式文本
     * @return 对应的枚举
     */
    public static PayTypeEnum getEnumByText(String text) {
        if (ObjectUtils.isEmpty(text)) {
            return null;
        }
        for (PayTypeEnum anEnum : PayTypeEnum.values()) {
            if (anEnum.text.equals(text)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}