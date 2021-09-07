package DP06_COR_FilterChain;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Filter01 implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("Filter01 output: " + request.msg);
        chain.doFilter(request, response, chain);
        System.out.println("Filter01 output: " + response.msg);
        return true;
    }
}
