package com.lovely.devpos.core;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.lovely.devpos.pojo.SVNPojo;

public class SVNBaseOption implements ISVN {

	private static final Logger LOG = LoggerFactory.getLogger(SVNBaseOption.class);

	private final Logger LOGGER = LoggerFactory.getLogger(SVNBaseOption.class);

	private SVNBaseOption() {

	}

	private ISVNOptions options;

	private SVNClientManager svnClientManager;

	private SVNUpdateClient svnUpdateClient;

	private SVNPojo SVNPojo;

	private SVNURL svnurl;

	private ISVNAuthenticationManager authManager;

	private SVNRepository repository;

	@Override
	public void init() throws SVNException {
		// 为了使用 http:// and https://
		DAVRepositoryFactory.setup();
		// 为了使用 svn:// and svn+xxx://
		SVNRepositoryFactoryImpl.setup();
		// 为了使用 file:///
		FSRepositoryFactory.setup();
		options = SVNWCUtil.createDefaultOptions(true);
		authManager = SVNWCUtil.createDefaultAuthenticationManager(SVNPojo.getUserName(),
				SVNPojo.getPassword().toCharArray());
		svnClientManager = SVNClientManager.newInstance((DefaultSVNOptions) options, authManager);
		svnUpdateClient = svnClientManager.getUpdateClient();
		svnurl = SVNURL.parseURIEncoded(this.SVNPojo.getOptinoalSvnUrl());
		repository = SVNRepositoryFactory.create(svnurl);
		repository.setAuthenticationManager(authManager);
	}

	@Override
	public long checkOut() {
		// DAVRepositoryFactory.setup();
		// SVNRepositoryFactoryImpl.setup();
		// FSRepositoryFactory.setup();
		svnUpdateClient.setIgnoreExternals(false);
		File save = new File(SVNPojo.getServiceFileUrl());
		if (!save.isDirectory()) {
			save.mkdir();
		}
		long version = -1;
		try {
			version = svnUpdateClient.doCheckout(svnurl, save, SVNRevision.HEAD, SVNRevision.HEAD, SVNDepth.INFINITY,
					false);
		} catch (SVNException e) {
			LOGGER.error("SVN Check Out Error :{}", e.getMessage());
		}
		return version;
	}

	@Override
	public long update() {
		svnUpdateClient.setIgnoreExternals(false);
		File save = new File(SVNPojo.getServiceFileUrl());
		if (!save.isDirectory()) {
			save.mkdir();
		}
		long version = -1;
		try {
			svnClientManager.getWCClient().doCleanup(save);
			version = svnUpdateClient.doCheckout(SVNURL.parseURIEncoded(this.SVNPojo.getOptinoalSvnUrl()), save,
					SVNRevision.HEAD, SVNRevision.HEAD, SVNDepth.INFINITY, false);
		} catch (SVNException e) {
			LOGGER.error("SVN Update :{}", e);
		}
		return version;
	}

	public static SVNBaseOption builer(@NotNull SVNPojo svnPojo) throws SVNException {
		SVNBaseOption svnBaseOption = new SVNBaseOption();
		svnBaseOption.SVNPojo = svnPojo;
		svnBaseOption.init();
		LOG.info("SVN Client init :{}", svnPojo);
		return svnBaseOption;
	}

	protected void setOptinoalSvnUrl(@NotNull String optionalSvnUrl) {
		this.SVNPojo.setOptinoalSvnUrl(optionalSvnUrl);
	}

	protected String getOptinoalSvnUrl() {
		return SVNPojo.getOptinoalSvnUrl();
	}

	protected void setServiceFileUrl(@NotNull String serviceFileUrl) {
		this.SVNPojo.setServiceFileUrl(serviceFileUrl);
	}

	protected String getServiceFileUrl() {
		return SVNPojo.getServiceFileUrl();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void disable() {
		svnClientManager.shutdownConnections(true);
	}

	@Override
	public String getRepositoryRoot() throws SVNException {
		return repository.getRepositoryRoot(true).toString();
	}

	@Override
	public List<Map<String, String>> getDir(String path) throws SVNException {
		return null;
	}

}
