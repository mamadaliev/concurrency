package concurrency_in_practice.chapter02;

import concurrency_in_practice.annotations.NotThreadSafe;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet {

    private long count = 0;

    public long getCount() {
        return count;
    }

    @Override
    public void init(ServletConfig servletConfig) {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws IOException {
        BigInteger i = extractFromRequest(request);
        BigInteger[] factors = factor(i);
        ++count;
        encodeIntoResponse(response, factors);
    }

    private void encodeIntoResponse(ServletResponse response, BigInteger[] factors) throws IOException {
        response.getWriter().write(Arrays.toString(factors));
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[0];
    }

    private BigInteger extractFromRequest(ServletRequest request) {
        return BigInteger.valueOf(Long.parseLong(request.getParameter("number")));
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
