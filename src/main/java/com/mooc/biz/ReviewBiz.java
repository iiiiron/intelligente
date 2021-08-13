package com.mooc.biz;

import com.mooc.entity.Review;

import java.util.List;

public interface ReviewBiz {
	List<Review> select(int courseid);
	 int delete(Review review);
	 int insert(Review review);
	 String avglable(int courseid);
	 List<Review> selectbyuserid(String username);
	 int updateByPrimaryKeySelective(List<Review> reviews);
}
