package DP06_ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public FilterChain doFilter(Request request, Response response, FilterChain chain) {
        for (Filter filter : filters) {
            filter.doFilter(request, response, chain);
        }
        return this;
    }
}
