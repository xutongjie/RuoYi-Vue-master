package com.ruoyi.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.domain.TbUser;
import com.ruoyi.system.dto.BanDing;
import com.ruoyi.system.service.ITbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbZyhMapper;
import com.ruoyi.system.domain.TbZyh;
import com.ruoyi.system.service.ITbZyhService;

/**
 * 志愿汇图片Service业务层处理
 *
 * @author ruoyi
 * @date 2023-10-19
 */
@Service
public class TbZyhServiceImpl extends ServiceImpl<TbZyhMapper,TbZyh> implements ITbZyhService
{
    @Autowired
    private TbZyhMapper tbZyhMapper;

    @Autowired
    private ITbUserService iTbUserService;
    /**
     * 绑定账号
     * @param banDing
     * @return
     */
    @Override
    public Map Banding(BanDing banDing) {
        String openId = banDing.getOpenId();
        String phonenumber = banDing.getPhonenumber();
        LambdaQueryWrapper<TbUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(TbUser::getPhoneNumber,phonenumber);
        List<TbUser> list = iTbUserService.list(lambdaQueryWrapper);
        if (list.size() == 0){
            TbUser tbUser = new TbUser();
            tbUser.setPhoneNumber(phonenumber);
            tbUser.setOpenId(openId);
            iTbUserService.save(tbUser);
        }
        TbUser one = iTbUserService.getOne(lambdaQueryWrapper);
        Long userId = one.getUserId();
        HashMap<String, Long> map = new HashMap<>();
        map.put("userId",userId);
        return map;
    }
}
