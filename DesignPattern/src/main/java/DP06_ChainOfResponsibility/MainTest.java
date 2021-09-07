package DP06_ChainOfResponsibility;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MainTest {
    public static void main(String[] args) {
        Request request = new Request();
        Response response = new Response();
        request.msg = "request";
        response.msg = "response";
        FilterChain chain = new FilterChain();
        MT01_Filter filter1 = new MT01_Filter();
        MT02_Filter filter2 = new MT02_Filter();
        chain.addFilter(filter1);
        chain.addFilter(filter2);
        chain.doFilter(request, response, chain);
    }
}
