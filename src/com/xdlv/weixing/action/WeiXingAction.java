package com.xdlv.weixing.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

public class WeiXingAction extends BaseAction {

	private String echostr;

	public String entry() {
		log.info("entry:" + echostr);
		if (StringUtils.isNotBlank(echostr)){
			returnXml(echostr);
			return XML;
		}
		//ReceiveXmlEntity msgEntity = getMsgEntity();
		return SUCCESS;
	}
	
	private void returnXml(String xml){
		ServletActionContext.getRequest().setAttribute(
				"xml", xml);
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}

	public String getEchostr() {
		return echostr;
	}

}
