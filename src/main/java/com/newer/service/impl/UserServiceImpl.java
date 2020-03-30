package com.newer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.dao.UserDao;
import com.newer.domain.User;
import com.newer.dto.UserDto;
import com.newer.service.UserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User login(String uname, String upwd) {
		// 设置查询条件
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("uname", uname);
		criteria.andEqualTo("upwd", upwd);
		// 查询
		User user = this.userDao.selectOneByExample(example);
		return user;
	}

	@Override
	public PageInfo<User> findPages(UserDto userDto) {
		// 1.设置当前页和每页显示的条数
		PageHelper.startPage(userDto.getPage(), userDto.getPageSize());
		// 2.执行查询
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		if (userDto.getName() != null && !"".equals(userDto.getName())) {
			criteria.andLike("uname", "%" + userDto.getName() + "%");
		}
		if (userDto.getSex() != null) {
			criteria.andEqualTo("sex", userDto.getSex());
		}
		List list = this.userDao.selectByExample(example);
		// 3. 实例化PageInfo对象
		PageInfo pageInfo=new PageInfo(list);
		return pageInfo;
	}

	@Override
	public boolean save(User user) { 
		return this.userDao.insert(user)>0?true:false;
	}
	/**
	 * 用户名已经存在，返回true，否则返回false
	 */

	@Override
	public boolean isExists(String name) {
		Example example=new Example(User.class);
		Criteria criteria=example.createCriteria();
		criteria.andEqualTo("uname", name);
		User user=this.userDao.selectOneByExample(example);
		return user!=null?true:false;
	}

}
