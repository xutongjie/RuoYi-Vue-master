package com.ruoyi.system.controller;

import com.ruoyi.system.service.ITbWaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;

/**
 * 商品Controller
 *
 * @author ruoyi
 * @date 2023-10-19
 */
@RestController
@RequestMapping("/system/wares")
public class TbWaresController extends BaseController
{
    @Autowired
    private ITbWaresService tbWaresService;


}
