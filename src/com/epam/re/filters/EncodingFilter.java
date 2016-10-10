package com.epam.re.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author A.Tymchenko
 * @version 1.0, 24.12.2015
 */

/**
 * Simple filter-class to set appropriate encoding.
 * If nothing other mentioned in {@code FilterConfig} set to "UTF-8"
 */
public class EncodingFilter implements Filter {
    private String encoding;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        resp.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
        encoding = (encoding == null) ? "UTF-8" : encoding;
    }

}
