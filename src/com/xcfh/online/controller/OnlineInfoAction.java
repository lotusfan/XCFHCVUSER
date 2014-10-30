package com.xcfh.online.controller;

import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xcfh.comm.onlineinfo.service.OnlineInfoService;
import com.xcfh.util.IpNum;

public class OnlineInfoAction extends ActionSupport {
	private OnlineInfoService onlineinfoService;

	//private Logger logger = Logger.getLogger(OnlineInfoAction.class);

	public OnlineInfoService getOnlineinfoService() {

		return onlineinfoService;
	}

	@ Resource(name = "OnlineInfoService")
	public void setOnlineinfoService(OnlineInfoService onlineinfoService) {

		this.onlineinfoService = onlineinfoService;
	}

	public void addOnlineInfo() {

		try {
			InputStream in = ServletActionContext.getRequest().getInputStream(); // ��ȡ������
			OutputStream out = ServletActionContext.getResponse().getOutputStream(); // ��ȡ�����
			String ip = IpNum.getIpAddr(ServletActionContext.getRequest());
			onlineinfoService.addOnlineInfo(in, out, ip);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
