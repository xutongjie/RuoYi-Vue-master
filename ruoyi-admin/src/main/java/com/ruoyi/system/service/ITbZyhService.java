package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.TbZyh;
import com.ruoyi.system.dto.BanDing;

/**
 * 志愿汇图片Service接口
 *
 * @author ruoyi
 * @date 2023-10-19
 */
public interface ITbZyhService extends IService<TbZyh>
{
    /**
     * 绑定账号
     * @return
     */
    Map Banding(BanDing banDing);
}
