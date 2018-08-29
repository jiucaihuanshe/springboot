package com.jt.cart.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jt.cart.mapper.CartMapper;
import com.jt.cart.pojo.Cart;
import com.jt.cart.service.CartService;
import com.jt.common.vo.SysResult;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartMapper cartMapper;
	//查询购物车数据
	@Override
	public SysResult query(Long userId, Integer page, Integer rows) {
		Cart param = new Cart();
		param.setUserId(userId);
		//EntityWrapper实体包装器，用于处理 sql 拼接，排序，实体参数查询等，注意其使用的是数据库字段而不是java属性。
		EntityWrapper<Cart> wrapper = new EntityWrapper<>();
		wrapper.setEntity(param);
		PageHelper.startPage(page, rows);
		List<Cart> cartList=cartMapper.selectList(wrapper);
		PageInfo<Cart> info = new PageInfo<>(cartList);
		return SysResult.oK(info);
	}
	//将商品加入购物车
	@Override
	public SysResult save(Cart cart) {
		try {
			//判断，货物是否存在于购物车中，必须按itemId+userId
			Map<String, Long> map = new HashMap<>();
			map.put("userId", cart.getUserId());
			map.put("itemId", cart.getItemId());
			Integer count = cartMapper.queryByUserIdItemId(map);
			if(count > 0){
				//查询购物车
				EntityWrapper<Cart> wrapper = new EntityWrapper<>();
				wrapper.eq("user_id", cart.getUserId());
				List<Cart> cartList=cartMapper.selectList(wrapper);
				if(cartList!=null && cartList.size()>0){
					Cart oCart = cartList.get(0);
					oCart.setNum(oCart.getNum()+cart.getNum());
					this.updateNum(oCart);
				}
				return SysResult.build(201, "该商品已经存在购物车中");
			}else {
				cart.setCreated(new Date());
				cart.setUpdated(cart.getCreated());
				cartMapper.insert(cart);
				return SysResult.oK();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.build(201, "商品添加到购物车失败");
		}
	}
	//更新数量
	public SysResult updateNum(Cart cart) {
		try {
			cartMapper.updateNum(cart);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.build(201, "更新商品数量错误！"+cart.getItemId());
		}
	}
	@Override
	public SysResult deleteItem(Cart cart) {
		try {
			cartMapper.deleteItem(cart);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.build(201, "删除商品失败");
		}
	}
}
