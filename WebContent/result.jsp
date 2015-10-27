<%@ page contentType="text/json;charset=UTF-8" language="java" %>
<%@ page import="net.sf.json.*"%>
<% 
    Throwable e = (Throwable)request.getAttribute("exception");
    Throwable temp = e;
    int deep = 10;
    while (temp != null && temp.getCause() != null && deep-- > 0){
    	temp = temp.getCause();
    }
    String errorMsg = "操作成功";
    boolean success = true;
    
    if (temp != null){
    	errorMsg = temp.getMessage();
    	success = false;
    	e.printStackTrace();
    }
    JSONObject json = new JSONObject();
	json.put("success", success);
	json.put("msg", errorMsg);
%>
<%=json%>