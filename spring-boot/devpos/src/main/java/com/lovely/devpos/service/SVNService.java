package com.lovely.devpos.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/svn/")
public class SVNService {

	/**
	 * 工程检出
	 */
	@PostMapping("/checkout")
	public void checkOut() {
	}

	/**
	 * 工程更新
	 */
	@PostMapping("/update")
	public void update() {
	}

}
