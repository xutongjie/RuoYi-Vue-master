package com.ruoyi.system.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbAuthenticationMapper;
import com.ruoyi.system.domain.TbAuthentication;
import com.ruoyi.system.service.ITbAuthenticationService;

/**
 * 认证记录Service业务层处理
 *
 * @author ruoyi
 * @date 2023-10-19
 */
@Service
public class TbAuthenticationServiceImpl extends ServiceImpl<TbAuthenticationMapper,TbAuthentication> implements ITbAuthenticationService
{
    @Autowired
    private TbAuthenticationMapper tbAuthenticationMapper;


}
