package com.ruoyi.system.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbOrderDetailMapper;
import com.ruoyi.system.domain.TbOrderDetail;
import com.ruoyi.system.service.ITbOrderDetailService;

/**
 * 下单明细Service业务层处理
 *
 * @author ruoyi
 * @date 2023-10-19
 */
@Service
public class TbOrderDetailServiceImpl extends ServiceImpl<TbOrderDetailMapper,TbOrderDetail> implements ITbOrderDetailService
{
    @Autowired
    private TbOrderDetailMapper tbOrderDetailMapper;


}
