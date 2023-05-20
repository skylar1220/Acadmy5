package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("필터해제.....");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("필터수행.....");
		String name =  request.getParameter("name");
		if(name== null || name.equals("")) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer =  response.getWriter(); // rsp를 getwriter해준다는 게 뭘까?
			String message = "입력된 name은 null입니다.";
			writer.println(message);
			return;
		}
		chain.doFilter(request, response); // 연결시켜 주는 것
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("필터초기화.....");
	}
	
}
