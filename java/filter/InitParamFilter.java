package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitParamFilter implements Filter {
	private FilterConfig filterConfig = null ;
	

	@Override
	public void destroy() {
		System.out.println("필터2 해제............");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("필터2 적용............");
		String id = request.getParameter("id");
		String psw = request.getParameter("psw");
		String param1 = filterConfig.getInitParameter("param1");
		String param2 = filterConfig.getInitParameter("param2");
		String message ;
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer =  response.getWriter(); // rsp를 getwriter해준다는 게 뭘까?
		
		if(id.equals(param1)|| psw.equals(param2)) {
			message = "로그인 성공";
			writer.print(message);
			chain.doFilter(request, response); // 필터끼리 연결해주는 것 a 필터 다음 b 필터 이렇게 겹겹히 수행하라고 
		} else {
			message = "로그인 실패";
			writer.print(message);
			chain.doFilter(request, response); // 필터끼리 연결해주는 것 a 필터 다음 b 필터 이렇게 겹겹히 수행하라고 
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException { // filterConfig = web.xml에서 filter에 관련된 정보
		System.out.println("필터2 초기화............");
		this.filterConfig = filterConfig;
	}

}
