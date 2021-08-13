package com.mooc.mapper;


import com.mooc.entity.Review;

import java.util.List;

public interface ReviewMapper {
 List<Review> select(int courseid);
 int delete(Review review);
 int insert(Review review);
 List<Review> selectbyuserid(String username);
 int updateByPrimaryKeySelective(Review review);
}
