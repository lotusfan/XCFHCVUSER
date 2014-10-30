package com.xcfh.online.service;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xcfh.comm.onlineinfo.controller.OnlineInfoAction;
import com.xcfh.comm.onlineinfo.dao.OnlineInfoDAO;
import com.xcfh.comm.onlineinfo.domain.OnlineInfo;
import com.xcfh.util.Input_to_JSON;

@ Service("OnlineInfoService")
public class OnlineInfoService {
	private OnlineInfoDAO onlineinfoDao;
	private Logger logger = Logger.getLogger(OnlineInfoAction.class);

	public OnlineInfoDAO getOnlineinfoDao() {

		return onlineinfoDao;
	}

	@ Resource(name = "OnlineInfoDAO")
	public void setOnlineinfoDao(OnlineInfoDAO onlineinfoDao) {

		this.onlineinfoDao = onlineinfoDao;
	}

	public void addOnlineInfo(InputStream in, OutputStream out, String ip) {

		JSONObject jso = null;
		Class onlineInfo = OnlineInfo.class;
		Object o = null;
		DataOutputStream dos = null;
		String uid = null;
		List li = null;
		Method jsometh = null;
		try {
			DateFormat datef = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.CHINA);
			jso = Input_to_JSON.getJSON(in);
			o = onlineInfo.newInstance();
			//����jso
			Set jsoset = jso.entrySet();
			Iterator jsoit = jsoset.iterator();
			while (jsoit.hasNext()) {
				Entry jsoen = (Entry) jsoit.next();
				jsometh = onlineInfo.getMethod("setCom_" + jsoen.getKey(), String.class);
				jsometh.invoke(o, jsoen.getValue());
			}
			//	jsometh = onlineInfo.getMethod("setCom_onl_time", String.class);
			//	jsometh.invoke(o, datef.format(new Date()));
			onlineinfoDao.addOlineInfo(o);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				if (dos != null) dos.close();
				if (out != null) out.close();
				if (in != null) in.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
