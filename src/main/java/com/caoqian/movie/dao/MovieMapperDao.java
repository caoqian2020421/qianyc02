package com.caoqian.movie.dao;

import java.util.List;

import com.caoqian.movie.domain.Movie;
import com.caoqian.movie.vo.MovieVO;


public interface MovieMapperDao {

	List<Movie> list(MovieVO movieVO);

	int del(Integer[] ids);

}
