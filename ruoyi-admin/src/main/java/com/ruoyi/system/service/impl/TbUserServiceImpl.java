package com.ruoyi.system.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.dto.BanDing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbUserMapper;
import com.ruoyi.system.domain.TbUser;
import com.ruoyi.system.service.ITbUserService;

/**
 * 用户Service业务层处理
 *
 * @author ruoyi
 * @date 2023-10-19
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper,TbUser> implements ITbUserService
{
    @Autowired
    private TbUserMapper tbUserMapper;




}
