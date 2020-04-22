package com.caoqian.movie.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caoqian.movie.domain.Movie;
import com.caoqian.movie.service.MovieService;
import com.caoqian.movie.vo.MovieVO;
import com.github.pagehelper.PageInfo;


@Controller
public class MovieController {

	@Resource
	private MovieService service;
	
	
	@RequestMapping("list")
	public String list(Model model,MovieVO movieVO,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "3")Integer pageSize) {
		
		PageInfo<Movie> info = service.list(movieVO, pageNum, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("movieVO", movieVO);
		return "list";
		
	}
	
	@RequestMapping("/deleteBatch")
	@ResponseBody
	public boolean del(@RequestParam("ids[]")Integer[] ids) {
		return service.del(ids)>0;
		
	}
}
