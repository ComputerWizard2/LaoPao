package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor  implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation action) throws Exception {
		if (action.getInvocationContext().getSession().get("users") !=null||action.getInvocationContext().getName().equals("logindo")||action.getInvocationContext().getName().equals("registerdo")||action.getInvocationContext().getName().equals("registedo")) {
			action.invoke();
		}
		
		
		return "error";
		
	}

}
