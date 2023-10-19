package com.ruoyi.system.domain;

import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 tb_user
 *
 * @author ruoyi
 * @date 2023-10-19
 */
@Data
public class TbUser
{
    private static final long serialVersionUID = 1L;

    /** 用户Id */
    private Long userId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNumber;

    /** 学号 */
    @Excel(name = "学号")
    private Long sno;

    /** 学院 */
    @Excel(name = "学院")
    private String college;

    /** 班级 */
    @Excel(name = "班级")
    private String classnumber;

    /** 暖心超市盖章图片 */
    @Excel(name = "暖心超市盖章图片")
    private String gzImage;

    /** 贫困生图片 */
    @Excel(name = "贫困生图片")
    private String poorImage;

    /** 认证时数 */
    @Excel(name = "认证时数")
    private BigDecimal rzNumber;

    /** 总积分 */
    @Excel(name = "总积分")
    private Integer totalScore;

    /** 剩余积分 */
    @Excel(name = "剩余积分")
    private Integer surplusScore;

    /** 审批人1 */
    @Excel(name = "审批人1")
    private String firstExamine;

    /** 审批人2 */
    @Excel(name = "审批人2")
    private String secondExamine;

    /** 身份100学生,200次管,主管300 */
    @Excel(name = "身份100学生,200次管,主管300")
    private String status;

    /** 状态(0可用/1禁用) */
    @Excel(name = "状态(0可用/1禁用)")
    private String state;

    /** openID */
    @Excel(name = "openID")
    private String openId;
}
