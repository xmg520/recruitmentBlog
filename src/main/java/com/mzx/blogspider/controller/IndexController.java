package com.mzx.blogspider.controller;

import com.mzx.blogspider.mapper.PositionMapper;
import com.mzx.blogspider.pojo.PositionInfo;
import com.mzx.blogspider.utils.Base64Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController
{

    @Autowired
    PositionMapper positionMapper;

    @RequestMapping({"/page/{curr}/{size}/{cityCode}"})
    public String index(Model model, @PathVariable String curr, @PathVariable int size, @PathVariable String cityCode)
    {
        byte[] decode = Base64Tools.decode(curr);
        String s = new String(decode);

        int i = Integer.parseInt(s.split("-")[0]);
        int startPage = (i - 1) * 12;

        List data = this.positionMapper.getDataByCity(startPage, 12, cityCode);
        int dataCount = this.positionMapper.getDataCount();
        int totalPage = (int)Math.ceil(dataCount * 1.0D / 12.0D);

        model.addAttribute("dataList", data);
        model.addAttribute("totalPage", Integer.valueOf(totalPage));
        model.addAttribute("currentPage", Integer.valueOf(i));
        model.addAttribute("cityCode", cityCode);
        return "index";
    }

    @RequestMapping({"/index","/"})
    public String index() {
        return "redirect:/page/MS1hbGljZQ==/12/749";
    }

    @RequestMapping({"/getPosition"})
    public String getPositionInfo(String id, Model model) {
        byte[] decode = Base64Tools.decode(id);
        String s = new String(decode);
        PositionInfo info = this.positionMapper.getPositionById(s);
        model.addAttribute("info", info);
        return "positionInfo";
    }
}