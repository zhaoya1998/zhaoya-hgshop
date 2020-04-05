package com.zhaoya.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.dubbo.config.annotation.Reference;

import com.github.pagehelper.PageInfo;
import com.zhaoya.pojo.Brand;
import com.zhaoya.pojo.Sku;
import com.zhaoya.pojo.SkuVo;
import com.zhaoya.service.SkuService;

@Controller
@RequestMapping("sku")
public class SkuController {

	@Reference
	SkuService skuService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request, SkuVo skuVo, @RequestParam(defaultValue = "1") int page) {
		PageInfo<Sku> pageInfo = skuService.list(page, skuVo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("skuVo", skuVo);
		return "sku/list";
	}
	
	// 跳转到添加页面
		@RequestMapping("toadd")
		public String toAdd(HttpServletRequest request) {
			return "sku/add";
		}
}
