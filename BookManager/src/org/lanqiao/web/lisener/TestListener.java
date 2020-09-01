package org.lanqiao.web.lisener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class TestListener implements HttpSessionBindingListener {

    public void valueBound(HttpSessionBindingEvent event)  { 
    	//System.out.println("HttpSessionBindingEvent °ó¶¨...");
    }

    public void valueUnbound(HttpSessionBindingEvent event)  { 
    	//System.out.println("HttpSessionBindingEvent ½â°ó...");
    }
	
}
