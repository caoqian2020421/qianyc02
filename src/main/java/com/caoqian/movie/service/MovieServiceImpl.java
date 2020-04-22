package com.caoqian.movie.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caoqian.movie.dao.MovieMapperDao;
import com.caoqian.movie.domain.Movie;
import com.caoqian.movie.vo.MovieVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class MovieServiceImpl implements MovieService{

	@Resource
	private MovieMapperDao dao;

	@Override
	public PageInfo<Movie> list(MovieVO movieVO, Integer pageNum, Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<Movie> list = dao.list(movieVO);
		return new PageInfo<Movie>(list);
	}

	@Override
	public int del(Integer[] ids) {
		// TODO Auto-generated method stub
		return dao.del(ids);
	}

	

	
}
