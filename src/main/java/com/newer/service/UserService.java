package com.newer.service;

import com.github.pagehelper.PageInfo;
import com.newer.domain.User;
import com.newer.dto.UserDto;

public interface UserService {
	/**
	 * 登录
	 * @param uname
	 * @param upwd
	 * @return
	 */
  public User  login(String uname,String upwd);
  
  
  /**
   * 分页
   * @param userDto
   * @return
   */
  public PageInfo<User> findPages(UserDto userDto);
  
  
  public boolean save(User user);
  
  /**
   * 判断用户名是否存在
   * @param name
   * @return
   */
  public boolean isExists(String name);
}
