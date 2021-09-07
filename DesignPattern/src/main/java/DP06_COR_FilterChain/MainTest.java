package DP06_COR_FilterChain;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MainTest {
    public static void main(String[] args) {
        Request request = new Request();
        Response response = new Response();

        FilterChain chain = new FilterChain();
        Filter01 filter01 = new Filter01();
        Filter02 filter02 = new Filter02();
        chain.addFilter(filter01);
        chain.addFilter(filter02);

        chain.doFilter(request, response, chain);
    }
}
