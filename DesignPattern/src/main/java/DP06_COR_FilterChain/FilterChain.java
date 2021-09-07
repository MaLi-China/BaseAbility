package DP06_COR_FilterChain;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<>();
    private int index = 0;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        for (Filter filter : filters) {
            if (filters.size() == index) {
                return false;
            }
            filters.get(index++).doFilter(request, response, chain);//在第二个开始, 依次调用Filter
        }
        return true;
    }
}
