package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 志愿汇图片对象 tb_zyh
 *
 * @author ruoyi
 * @date 2023-10-19
 */
@Data
public class TbZyh
{
    private static final long serialVersionUID = 1L;

    /** 志愿汇图片ID */
    private Long zyhId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 志愿会认证图片 */
    @Excel(name = "志愿会认证图片")
    private String zyhImage;

}
