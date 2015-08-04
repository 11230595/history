package com.notepad.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.notepad.entity.Favorite;
import com.notepad.entity.User;
import com.notepad.service.FavoriteService;
import com.notepad.service.UserService;

@Controller
@RequestMapping("favorite")
public class FavoriteController {

	@Resource
	private FavoriteService favoriteService;
	@Resource
	private UserService userService;
	
	/**
	 * 保存
	 * @return
	 */
	@RequestMapping(value="save",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String,Object> save(Favorite favorite,HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			User user = (User) request.getSession().getAttribute("user");
			favorite.setId(UUID.randomUUID().toString());
			favorite.setUserCode(user.getUserCode());
			favoriteService.insert(favorite);
			map.put("respCode", 0);
			map.put("respMsg", "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("respCode", 1);
			map.put("respMsg", "保存失败");
		}
		return map;
	}
	
	/**
	 * 根据用户ID查询全部收藏夹
	 * @return
	 */
	@RequestMapping(value="list/{userId}",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String,Object> list(HttpServletRequest request,@PathVariable String userId) {
		Map<String,Object> map = new HashMap<String, Object>();
		
		User user = userService.selectByPrimaryKey(userId);
		String userCode = "";
		if(user != null){
			userCode = user.getUserCode();
		}
		List<Favorite> favroites = favoriteService.findFavroites(userCode);
		map.put("result", favroites);
		return map;
	}
	
	/**
	 * 删除收藏夹
	 * @return
	 */
	@RequestMapping(value="delete/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String,Object> delete(@PathVariable String id,HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			favoriteService.deleteByPrimaryKey(id);
			map.put("respCode", 0);
			map.put("respMsg", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("respCode", 1);
			map.put("respMsg", "删除失败");
		}
		return map;
	}
}
