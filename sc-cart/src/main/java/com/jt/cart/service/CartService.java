package com.jt.cart.service;

import com.jt.cart.pojo.Cart;
import com.jt.common.vo.SysResult;

public interface CartService {
	SysResult query(Long userId, Integer page, Integer rows);
	SysResult save(Cart cart);
	SysResult updateNum(Cart param);
	SysResult deleteItem(Cart param);
}
