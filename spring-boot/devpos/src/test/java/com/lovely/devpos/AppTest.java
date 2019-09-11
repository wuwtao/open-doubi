package com.lovely.devpos;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import com.lovely.devpos.core.ISVN;
import com.lovely.devpos.core.SVNBaseOption;
import com.lovely.devpos.pojo.SVNPojo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { App.class }) // 指定启动类
public class AppTest {

	public static void main(String args[]) throws SVNException {
		SVNPojo svnPojo = new SVNPojo();
		svnPojo.setOptinoalSvnUrl("https://zitao/svn/test");
		svnPojo.setUserName("xtadmin");
		svnPojo.setPassword("abc123!!");
		svnPojo.setServiceFileUrl("E:/dvepos");


		ISVN isvn = SVNBaseOption.builer(svnPojo);
		isvn.checkOut();
		//isvn.getDir(null);
	}
	

	@Test
	public void check() throws SVNException {
		SVNPojo svnPojo = new SVNPojo();
		svnPojo.setOptinoalSvnUrl("https://zitao/svn/test");
		svnPojo.setUserName("xtadmin");
		svnPojo.setPassword("abc123!!");
		svnPojo.setServiceFileUrl("E:/dvepos");


		ISVN isvn = SVNBaseOption.builer(svnPojo);
		isvn.checkOut();
		//isvn.getDir(null);
	}
}
