package jp.co.aforce.tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//webアプリケーション全体に適用するには/*使用
@WebFilter(urlPatterns = {"/*"})
public class EncodingFilter implements Filter {

	//次のフィルタを呼び出す。
	public void doFilter(
		//リクエストを取得するために使う引数、レスポンスを生成するために使う引数
		ServletRequest request, ServletResponse response, FilterChain chain
	) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");


		//
		chain.doFilter(request, response);

	}
	    //フィルタ開始時に呼ばれる
		public void init(FilterConfig FilterConfig) {}
		//フィルタ終了時に呼ばれる
		public void destroy() {}

}