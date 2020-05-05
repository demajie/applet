package com.applet.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  预约时间段枚举类,8个时间段
 */
@Getter
@AllArgsConstructor
public enum TimeRangeEnum {

    Time_RANGR_1(1,"9.00-9.30"),
    Time_RANGR_2(2,"9.30-10.00"),
    Time_RANGR_3(3,"10.00-10.30"),
    Time_RANGR_4(4,"10.30-11.00"),
    Time_RANGR_5(5,"14.30-15.00"),
    Time_RANGR_6(6,"15.00-15.30"),
    Time_RANGR_7(7,"15.30-16.00"),
    Time_RANGR_8(8,"16.00-16.30");

    private Integer id;
    private String range;
}
