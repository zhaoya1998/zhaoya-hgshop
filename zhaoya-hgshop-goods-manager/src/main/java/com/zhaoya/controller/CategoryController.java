package com.zhaoya.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaoya.pojo.Category;
import com.zhaoya.service.CategoryService;

@Controller
@RequestMapping("cat")
public class CategoryController {

	@Reference
	CategoryService categoryService;
	
	@RequestMapping("tree")
	public String tree() {
		return "category/tree";
	}
	
	@ResponseBody
	@RequestMapping("treeData")
	public List<Category> treeData() {
		List<Category> catTree = categoryService.getTree();
		return catTree;
	}
	
	@ResponseBody
	@RequestMapping("add")
	public String add(Category cat) {
		int re = categoryService.add(cat);
		return re>0?"success":"failed";
	}
	
	@ResponseBody
	@RequestMapping("update")
	public String update(Category cat) {
		int re = categoryService.update(cat);
		return re>0?"success":"failed";
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public String delete(int id) {
		int re = categoryService.delete(id);
		return re>0?"success":"failed";
	}
}
