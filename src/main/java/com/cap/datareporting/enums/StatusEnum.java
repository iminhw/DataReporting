package com.cap.datareporting.enums;

import lombok.Getter;

/**
 * 数据状态枚举-用于逻辑删除控制
 */
@Getter
public enum StatusEnum {

    /**
     * 正常的数据
     */
    OK(1, "启用"),
    /**
     * 被冻结的数据，不可用
     */
    FREEZED(2, "冻结"),
    /**
     * 数据已被删除
     */
    DELETE(0, "删除");

    private Integer code;

    private String message;

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

