package DP06_COR_FilterChain;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Filter02 implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("Filter02 output: " + request.msg);
        chain.doFilter(request, response, chain);
        System.out.println("Filter02 output: " + response.msg + "xxx");
        return true;
    }
}
