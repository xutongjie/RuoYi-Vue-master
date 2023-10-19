package com.ruoyi.system.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.TbUser;
import com.ruoyi.system.dto.BanDing;
import com.ruoyi.system.service.ITbUserService;
import com.ruoyi.system.tool.HttpClientSslUtils;
import com.ruoyi.system.tool.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TbZyh;
import com.ruoyi.system.service.ITbZyhService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 志愿汇图片Controller
 *
 * @author ruoyi
 * @date 2023-10-19
 */
@RestController
@RequestMapping("/system/zyh")
@Slf4j
public class TbZyhController extends BaseController
{
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private ITbUserService iTbUserService;
    @Autowired
    private ITbZyhService iTbZyhService;
    @Autowired
    private ITbZyhService tbZyhService;
    @Value("${appId}")
    private String appId;
    @Value("${secret}")
    private String secret;

    /**
     *微信的生成openId
     * @param code
     * @return
     */
    @GetMapping("/login")
    public AjaxResult OpenId(String code){

        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("appid=").append(appId);//appid设置
        url.append("&secret=").append(secret);//secret设置
        url.append("&js_code=").append(code);//code设置
        url.append("&grant_type=authorization_code");
        JSONObject res = null;
        try {
            res = JSONObject.parseObject(HttpUtil.get(url.toString()));    //构建一个GET请求
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.success(res);
    }

    /**
     *获取接口调用凭据
     * @return
     */
    @GetMapping("/accessToken")
    public AjaxResult getAccessToken(){

        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/cgi-bin/token?");
        url.append("appid=").append(appId);//appid设置
        url.append("&secret=").append(secret);//secret设置
        url.append("&grant_type=client_credential");
        JSONObject res = null;
        try {
            res = JSONObject.parseObject(HttpUtil.get(url.toString()));    //构建一个GET请求
        } catch (Exception e) {
            e.printStackTrace();
        }

        return AjaxResult.success(res);
    }
    /**
     * 获取手机号
     * @return
     */
    @PostMapping("/getPhoneNumber")
    public JSONObject  getPhoneNumber(String code) {
        JSONObject phone = null;
        String accessToken = null;

        ValueOperations valueOperations = redisTemplate.opsForValue();
        accessToken = String.valueOf(valueOperations.get("access_token"));

        if (StringUtils.isEmpty(accessToken) || "null".equals(accessToken)) {

            //获取token
            String token_url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appId, secret);
            try {
                JSONObject token = JSON.parseObject(HttpClientSslUtils.doGet(token_url));
                if (token == null) {
                    log.info("获取token失败");
                }
                accessToken = token.getString("access_token");
                Long expires_in = Long.valueOf(String.valueOf(token.get("expires_in")));
                if (StringUtils.isEmpty(accessToken)) {
                    log.info("获取token失败");
                }
                valueOperations.set("accessToken", accessToken, expires_in, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //获取phone
        String url = "https://api.weixin.qq.com/wxa/business/getuserphonenumber"
                + "?access_token=" + accessToken;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        String reqJsonStr = JsonUtil.objToString(jsonObject);
        try {
            phone = JSON.parseObject(HttpClientSslUtils.doPost(url, reqJsonStr));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (phone == null) {
            log.info("获取手机号失败");
            return null;
        }
        return phone;
    }


    /**
     * //绑定这个用户的openId
     * @param banDing
     * @return
     */
    @PostMapping("/Banding")
    public AjaxResult Banding(@RequestBody BanDing banDing){
        Map banding = iTbZyhService.Banding(banDing);
        if (banding != null){
            return AjaxResult.success("登录成功",banding);
        }else {
            return AjaxResult.error("绑定失败！");
        }

    }



}
