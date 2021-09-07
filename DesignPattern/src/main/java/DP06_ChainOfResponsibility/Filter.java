package DP06_ChainOfResponsibility;

/**
 * 功能说明：过滤器
 * 开发人员：@author MaLi
 */
public interface Filter {
    /**
     * 模拟Servlet的请求与响应
     *
     * @param request  请求
     * @param response 响应
     * @return 过滤结果
     */
    boolean doFilter(Request request, Response response, FilterChain chain);
}
