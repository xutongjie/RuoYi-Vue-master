package com.ruoyi.system.dto;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

@Data
public class BanDing {
    /**
     * 账号
     */
    @Excel(name = "账号")
    private String phonenumber;

    /**
     * openId
     */
    private String openId;
}
