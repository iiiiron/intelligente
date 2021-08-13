package com.mooc.controller;

/**
 * 杨祺晖
 * 2018.9.14
 * 591284209@qq.com
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mooc.biz.CourseBiz;
import com.mooc.biz.LogBiz;
import com.mooc.biz.MessageBiz;
import com.mooc.biz.UserBiz;
import com.mooc.entity.*;
import com.mooc.util.DateUtil;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	UserBiz userBiz;
	@Autowired
	CourseBiz courseBiz;
	@Autowired
	MessageBiz messageBiz;

	@Autowired
	LogBiz logBiz;

	/**
	 * 普通日志写入
	 * 
	 * @param loginUser
	 * @param ip
	 * @param type
	 */
	public void setlog(User loginUser, String ip, String type) {
		Log log = new Log();
		log.setUserid(loginUser.getId());
		log.setUsername(loginUser.getUsername());
		log.setIp(ip);
		log.setType(type);
		logBiz.insert(log);
	}

	@RequestMapping(value = "login")
	public String login(User user, HttpSession session, HttpServletRequest req) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("username", user.getUsername());
		paramMap.put("password", user.getPassword());
		User loginUser = userBiz.selectLoginUser(paramMap);
		if (loginUser == null) {
			return "login";
		}
		setlog(loginUser, req.getRemoteAddr(), "登录");
		if (loginUser.getVip()!=null&&loginUser.getVip().getTime()<new Date().getTime()){
			loginUser.setVip(null);
			userBiz.updateByPrimaryKeySelective(loginUser);
		}
		session.setAttribute("loginUser", loginUser);
		return "redirect:index";
	}

	@RequestMapping(value = "logout") // 注销登出
	public String logout(String type, User user, HttpSession session, HttpServletRequest req) {
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			return "login";
		} else {
			session.invalidate();
			if (type == "admin") {
				setlog(loginUser, req.getRemoteAddr(), "管理员注销");
				return "loginadmin";
			} else
				setlog(loginUser, req.getRemoteAddr(), "注销");
			return "redirect:index";
		}
	}

	/*
	 * ajax密码检查
	 */
	@RequestMapping(value = "passwordcheck")
	public void selectUser(User user, HttpServletResponse response, HttpServletRequest req)
			throws IOException {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("username", user.getUsername());
		paramMap.put("password", user.getPassword());
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if (userBiz.selectUser(paramMap) == 1) {
			user = userBiz.selectLoginUser(paramMap);
			if (!"admin".equals(user.getMission())&&!"showadmin".equals(user.getMission())) {
				if (user.getBuycase() != null) {
					if ("1".equals(user.getBuycase())) {
						out.println("3");// 屏蔽登录
					} else
						out.println("1");// 正常登录密码正确
				} else {
					out.println("1");
				}
			} else {
				out.println("2");// 管理员返回
			}
		} else {
			Log log = new Log();
			log.setIp(req.getRemoteAddr());
			log.setType("尝试登录账号:" + user.getUsername() + "，密码错误");
			logBiz.insert(log);
			out.println("0");//密码错误返回值
		}
	}

	@RequestMapping(value = "usercheck")
	// 注册检查
	public void Usercheck(String username, HttpSession session, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int i = userBiz.selectUser(username);
		out.println(i);
	}

	@RequestMapping(value = "quickregist")
	// 快速注册
	public ModelAndView insertUser(String varcode, User user, HttpSession session, HttpServletRequest req, ModelAndView mav) {
		String id = DateUtil.getId();
		String username = user.getUsername();
		mav.setViewName("redirect:course");
		if (varcode == null) {
			return mav;
		}
		if (userBiz.selectUser(username) == 1 || !CaptchaUtil.ver(varcode, req)) {
			return mav;
		}
		user.setId(id);
		user.setMission(null);
		user.setBuycase(null);
		user.setMycase(null);
		user.setVip(null);
		userBiz.insertSelective(user);
		session.setAttribute("loginUser", user);
		setlog(user, req.getRemoteAddr(), "快速注册");
		return mav;
	}

	@RequestMapping(value = "regist")
	// 注册
	public ModelAndView regist(ModelAndView mav, String varcode, User user, HttpSession session, HttpServletRequest req) {
		String id = DateUtil.getId();
		String username = user.getUsername();
		mav.setViewName("redirect:index");
		if (varcode == null) {
			return mav;
		}
		if (userBiz.selectUser(username) == 1 || !CaptchaUtil.ver(varcode, req)) {
			return mav;
		}
		user.setId(id);
		user.setMission(null);
		user.setBuycase(null);
		user.setMycase(null);
		user.setVip(null);
		userBiz.insertSelective(user);
		setlog(user, req.getRemoteAddr(), "普通注册");
		return mav;
	}

	@RequestMapping(value = "registerPage")
	// 注册
	public ModelAndView registerPage(ModelAndView mav, String varcode, User user, HttpSession session, HttpServletRequest req) {
		User loginUser = (User) session.getAttribute("loginUser");
		mav.setViewName("regist");
		if (loginUser == null) {
			return mav;
		}
		mav.setViewName("redirect:index");
		return mav;
	}




	@RequestMapping(value = "course")
	// 主页课程查询
	public String Course(HttpSession session, Map map) {
		List<Course> courses = courseBiz.selectAllCourse();
		map.put("courses", courses);
		return "courseindex";

	}

	@RequestMapping(value = "coursedetail")
	// 单课程主页
	public ModelAndView Courseindex(int id, HttpSession session,ModelAndView mav) {
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			mav.setViewName("login");
			return mav;
		}
		Message message = new Message();
		message.setCourseid(id);
		message.setUserid(loginUser.getId());
		Message me = messageBiz.select(message);
		if (me == null) {
			mav.addObject("isSelect", false);
		} else {
			mav.addObject("isSelect", true);
		}
		Course course = courseBiz.selectByPrimaryKey(id);
		mav.addObject("course", course);
		mav.setViewName("coursedetail");
		return mav;

	}



	@RequestMapping(value = "insertCourse")
	// 加入课程
	public void insertCourse(int courseid, String userid, HttpSession session, HttpServletRequest req,
							 HttpServletResponse response) throws IOException {
		String result = "订阅成功！";
		User user = (User) session.getAttribute("loginUser");
		Course c = courseBiz.selectByPrimaryKey(courseid);
		if (user.getVip() == null && "1".equals(c.getType())) {
			result = "此课程是会员课程，请购买会员！";
		} else {
			Message message = new Message();
			message.setCourseid(courseid);
			message.setUserid(userid);
			int i = messageBiz.insert(message);
			setlog(user, req.getRemoteAddr(), "订阅课程:" + c.getName());
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	@RequestMapping(value = "deleteCourse")
	// 删除课程
	public String deleteCourse(int courseid, String userid, HttpServletResponse response, HttpServletRequest req)
			throws IOException {
		Message message = new Message();
		message.setCourseid(courseid);
		message.setUserid(userid);
		PrintWriter out = response.getWriter();
		int i = messageBiz.delete(message);
		User loginUser = userBiz.selectByPrimaryKey(userid);
		Course c = courseBiz.selectByPrimaryKey(courseid);
		setlog(loginUser, req.getRemoteAddr(), "取消课程：" + c.getName());
		String result = i > 0 ? "true" : "false";
		return result;
	}


	
	@RequestMapping(value = "info")
	//个人信息页面
	public String Info(User user, HttpSession session) {
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			return "login";
		}
		return "infoset";
	}

	@RequestMapping(value = "infoset")
	// 个人信息设置
	public String Infoset(User user, HttpSession session, HttpServletRequest req) {
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			return "login";
		}
		user.setCollect(loginUser.getCollect());


		userBiz.updateByPrimaryKeySelective(user);
		Map map = new HashMap<String, String>();
		map.put("username", loginUser.getUsername());
		map.put("password", loginUser.getPassword());
		session.setAttribute("loginUser", userBiz.selectLoginUser(map));
		setlog(loginUser, req.getRemoteAddr(), "个人信息更改");
		return "redirect:index";

	}


}
