package DP06_COR_FilterChain;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public interface Filter {
    boolean doFilter(Request request, Response response, FilterChain chain);
}
