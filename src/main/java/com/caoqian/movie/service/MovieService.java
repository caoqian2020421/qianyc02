package com.caoqian.movie.service;

import com.caoqian.movie.domain.Movie;
import com.caoqian.movie.vo.MovieVO;
import com.github.pagehelper.PageInfo;

public interface MovieService {

	PageInfo<Movie> list(MovieVO movieVO, Integer pageNum, Integer pageSize);

	int del(Integer[] ids);

	
}
