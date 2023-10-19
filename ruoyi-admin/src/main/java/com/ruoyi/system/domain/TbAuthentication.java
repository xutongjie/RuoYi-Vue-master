package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 认证记录对象 tb_authentication
 *
 * @author ruoyi
 * @date 2023-10-19
 */
@Data
public class TbAuthentication
{
    private static final long serialVersionUID = 1L;

    /** 认证ID */
    private Long authenticationId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 状态（0审核/1通过/2驳回） */
    @Excel(name = "状态", readConverterExp = "0=审核/1通过/2驳回")
    private String state;

    /** 驳回理由 */
    @Excel(name = "驳回理由")
    private String reject;


}
