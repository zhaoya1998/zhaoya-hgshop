package com.zhaoya.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zhaoya.common.FileUtils;
import com.zhaoya.pojo.Brand;
import com.zhaoya.pojo.Spu;
import com.zhaoya.pojo.SpuVo;
import com.zhaoya.service.BrandService;
import com.zhaoya.service.SpuService;


//��Ʒ����
@Controller
@RequestMapping("spu")
public class SpuController {

	@Reference
	SpuService spuService;

	@Reference
	BrandService brandService;

	@RequestMapping("list")
	public String list(HttpServletRequest request, SpuVo spuVo, @RequestParam(defaultValue = "1") int page) {
		PageInfo<Spu> pageInfo = spuService.list(page, spuVo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("spuVo", spuVo);
		return "spu/list";
	}

	// ��ת�����ҳ��
	@RequestMapping("toadd")
	public String toAdd(HttpServletRequest request) {
		List<Brand> brandList = brandService.listByFirst("");
		request.setAttribute("brandList", brandList);
		return "spu/add";
	}

	// ���
	@ResponseBody
	@RequestMapping("add")
	public String add(HttpServletRequest request, Spu spu, @RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		// �ϴ��ļ�
		String filePath = FileUtils.processFile(file);
		// ����ͼƬ·��
		spu.setSmallPic(filePath);
		int result = spuService.add(spu);
		return result > 0 ? "success" : "failed";
	}

	// ɾ��
	@ResponseBody
	@RequestMapping("delBatch")
	public String delBatch(@RequestParam("ids[]") int ids[]) {
		int result = spuService.deleteBatch(ids);
		return result > 0 ? "success" : "failed";
	}

	// ��ת���޸�ҳ��
	@RequestMapping("toupdate")
	public String toupdate(HttpServletRequest request, int id) {
		Spu spu = spuService.getById(id);
		request.setAttribute("spu", spu);
		return "spu/update";
	}

	// �޸�ҳ��
	@ResponseBody
	@RequestMapping("update")
	public String update(HttpServletRequest request, Spu spu, @RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		// �ϴ��ļ�
		String filePath = FileUtils.processFile(file);
		// ����ͼƬ·��
		spu.setSmallPic(filePath);
		int result = spuService.add(spu);
		return result > 0 ? "success" : "failed";
	}
}
