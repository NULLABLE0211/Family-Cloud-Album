package com.FCA.controller;

import com.alibaba.fastjson.JSONObject;
import com.FCA.domain.User;

import com.FCA.domain.VO.VisualDataVO;
import com.FCA.service.VisualDataService;
import com.FCA.utils.TokenUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/visual")
@RestController
public class VisualDataController {
    @Resource
    VisualDataService visualDataService;
    @Resource
    TokenUtil tokenUtil;

    @RequestMapping("/selectTypeSite")
    public JSONObject selectTypeSite(String token) {
        JSONObject jsonObject = new JSONObject();
        User user = tokenUtil.jwtParser(token);
        Integer userId;
        if(user!=null) {
            userId = user.getUserId();
        }
        else{
            jsonObject.put("status","fail");
            return jsonObject;
        }

        VisualDataVO visualDataVO = visualDataService.selectTypeSite(userId);
        jsonObject.put("status","success");
        jsonObject.put("data", visualDataVO);
        return jsonObject;
    }

    @RequestMapping("/selectImageInfo")
    public JSONObject selectUserInfo(String token) {
        JSONObject jsonObject = new JSONObject();
        User user = tokenUtil.jwtParser(token);
        Integer userId;
        if(user!=null) {
            userId = user.getUserId();
        }
        else{
            jsonObject.put("status","fail");
            return jsonObject;
        }

        jsonObject.put("status","success");
        JSONObject res = visualDataService.selectUserInfo(userId);
        jsonObject.put("data", res);
        return jsonObject;
    }

}
