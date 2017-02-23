package cl.keanzato.app.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltroSeguridad
 */
@WebFilter({ "/mobile/*" })
public class FiltroSeguridad implements Filter {

	/**
	 * Default constructor.
	 */
	public FiltroSeguridad() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		FilterConfig filtro = new FilterConfig() {

			public ServletContext getServletContext() {
				// TODO Auto-generated method stub
				return null;
			}

			public Enumeration<String> getInitParameterNames() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getInitParameter(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public String getFilterName() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		HttpServletRequest requestHttp = (HttpServletRequest) request;
		if (null == requestHttp.getSession(false) || null == requestHttp.getSession(false).getAttribute("USUARIO")) {
			try {
				((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				((HttpServletResponse) response)
						.sendRedirect(filtro.getServletContext().getContextPath() + "/index.html");
			} catch (NullPointerException ex) {
				((HttpServletResponse) response).sendRedirect("/SpringAngular/");
			}

		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
