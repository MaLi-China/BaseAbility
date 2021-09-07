package DP06_ChainOfResponsibility;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MT01_Filter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        // 处理request
        System.out.println("处理MT01_Filter.Request: " + request.msg);
        // 处理chain的下一个filter
        chain.doFilter(request, response, chain);
        System.out.println("处理MT01_Filter.Response: " + response.msg);
        return false;
    }
}
