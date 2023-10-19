package com.ruoyi.system.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbWaresMapper;
import com.ruoyi.system.domain.TbWares;
import com.ruoyi.system.service.ITbWaresService;

/**
 * 商品Service业务层处理
 *
 * @author ruoyi
 * @date 2023-10-19
 */
@Service
public class TbWaresServiceImpl extends ServiceImpl<TbWaresMapper,TbWares> implements ITbWaresService
{
    @Autowired
    private TbWaresMapper tbWaresMapper;


}
