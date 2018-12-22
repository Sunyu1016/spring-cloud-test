package com.sunyu.zuul_filter.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SunYu
 * @date 2018/12/18 9:27
 */
public class PreRequestLogFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(PreRequestLogFilter.class);
    @Override
    public String filterType() {
        //PRE类型过滤器
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {

        return FilterConstants.PRE_DECORATION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        PreRequestLogFilter.logger.info(String.format("send %s request to %s", request.getMethod(),request.getRequestURL().toString()));
        return null;
    }
}
