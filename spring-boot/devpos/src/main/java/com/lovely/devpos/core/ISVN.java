package com.lovely.devpos.core;

import java.util.List;
import java.util.Map;

import org.tmatesoft.svn.core.SVNException;

public interface ISVN {

	/**
	 * 初始化信息
	 * 
	 * @author SimpleWu
	 * @throws SVNException
	 */
	public void init() throws SVNException;

	/**
	 * 检出文件
	 * 
	 * @author SimpleWu
	 * @return 版本号
	 * @throws SVNException
	 */
	public long checkOut() throws SVNException;

	/**
	 * 更新资源
	 * 
	 * @author SimpleWu
	 * @return 版本号
	 */
	public long update();

	/**
	 * 销毁连接
	 * 
	 * @author SimpleWu
	 */
	public void disable();

	/**
	 * 获取仓库根路径
	 * 
	 * @return
	 * @throws SVNException
	 */
	public String getRepositoryRoot() throws SVNException;

	/**
	 * 获取指定目录下的所有文件或目录
	 * 
	 * @param path
	 * @return
	 * @throws SVNException
	 */
	public List<Map<String, String>> getDir(String path) throws SVNException;
}
