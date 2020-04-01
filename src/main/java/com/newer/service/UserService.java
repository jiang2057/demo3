package com.newer.service;

import com.github.pagehelper.PageInfo;
import com.newer.domain.User;
import com.newer.dto.UserDto;

public interface UserService {
	/**
	 * ��¼
	 * @param uname
	 * @param upwd
	 * @return
	 */
  public User  login(String uname,String upwd);
  
  
  /**
   * ��ҳ
   * @param userDto
   * @return
   */
  public PageInfo<User> findPages(UserDto userDto);
  
  
  public boolean save(User user);
  
  /**
   * �ж��û����Ƿ����
   * @param name
   * @return
   */
  public boolean isExists(String name);
  public boolean delete();
}
