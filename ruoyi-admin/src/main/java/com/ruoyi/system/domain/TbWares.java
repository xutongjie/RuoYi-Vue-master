package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 tb_wares
 *
 * @author ruoyi
 * @date 2023-10-19
 */
@Data
public class TbWares
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long waresId;

    /** 商品名称 */
    private String name;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String picture;

    /** 商品积分价格 */
    private Integer value;

    /** 商品数量 */
    private Integer number;


}
