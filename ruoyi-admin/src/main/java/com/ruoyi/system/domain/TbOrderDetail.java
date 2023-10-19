package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 下单明细对象 tb_order_detail
 *
 * @author ruoyi
 * @date 2023-10-19
 */
@Data
public class TbOrderDetail
{
    private static final long serialVersionUID = 1L;

    /** 订单明细ID */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String image;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 同商品兑换数量 */
    @Excel(name = "同商品兑换数量")
    private Long number;

    /** 商品积分 */
    @Excel(name = "商品积分")
    private Long value;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationTime;


}
