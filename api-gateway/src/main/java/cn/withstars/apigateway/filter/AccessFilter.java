package cn.withstars.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: withstars
 * Date: 2018-06-03
 * Time: 9:08
 * Mail: withstars@126.com
 */
public class AccessFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 过滤器的类型 决定过滤器在请求的哪个生命周期执行
     * @return pre:在请求在路由之前执行
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行
     * @return true:执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("Send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessoken");
        if (accessToken == null){
            logger.warn("Access token is null");
            // 过滤该请求，不对请求做出路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        logger.info("Access token ok");
        return null;
    }
}
