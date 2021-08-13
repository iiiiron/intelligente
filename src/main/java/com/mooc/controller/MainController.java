package com.mooc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mooc.biz.*;
import com.mooc.entity.Course;
import com.mooc.entity.Log;
import com.mooc.entity.User;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	UserBiz userBiz;
	@Autowired
	CourseBiz courseBiz;

	@Autowired
	MessageBiz messageBiz;
	@Autowired
	LogBiz logBiz;
	public void setlog(User loginUser, String ip, String type) {
		Log log = new Log();
		log.setUserid(loginUser.getId());
		log.setUsername(loginUser.getUsername());
		log.setIp(ip);
		log.setType(type);
		logBiz.insert(log);
	}

	

	@RequestMapping(value = "admin")//管理员登录入口
	public String admin(HttpSession session) {
		return "loginadmin";
	}
	
	

	@RequestMapping(value = {"index",""})
	public ModelAndView index(ModelAndView mav) {
		List<Course> freecourses = courseBiz.freeCourse();
		List<Course> vipcourses = courseBiz.vipCourse();
		mav.addObject("freecourses", freecourses);
		mav.addObject("vipcourses", vipcourses);
		mav.setViewName("index");
		return mav;
	}




	@RequestMapping(value = "coursesearch")
	// 查找课程
	public String coursesearch(String search, Map map) {
		List<Course> courses = courseBiz.coursesearch(search);
		map.remove(courses);
		map.put("courses", courses);
		map.put("search", search);
		return "courseindex";
	}
	
	@RequestMapping("/error/{errorcode}")
	public String error(@PathVariable int errorcode) {
		String pager = "404";
		switch (errorcode) {
        case 404:
            pager = "404";
            break;
        case 500:
            pager = "500";
            break;
    }
		return pager;
	}
	

  
}
