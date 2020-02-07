package com.taru.interceptor;

import com.alibaba.druid.sql.visitor.functions.Concat;
import com.google.gson.Gson;
import com.taru.util.Constants;
import com.taru.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 判断用户是否登陆
 */
public class AtuchInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate redisTemplate;
    /**
     * （先前预备） 拦截到之后 就执行  请求没有达到Controller
     * 此处省略过程 ， 请参考 上一次写的过滤器 代码逻辑一致   只是把doFiter部分 换成return true   不通过的部分 换成return false
     * @param request
     * @param response
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie [] cookies=request.getCookies();
        System.out.println(request.getRequestURI());
        if(cookies!=null && cookies.length>0){
            for(Cookie cookie:cookies){
                if("token".equals(cookie.getName())){
                    String token_jsessionId=cookie.getValue();
                    Object object=redisTemplate.opsForHash().get("loginUserKey",token_jsessionId);
                    if(object!=null){
                        return true;
                    }
                }
            }
        }
        JsonResult result=new JsonResult(Constants.STATUS_ERROR,"没有令牌，无法登陆");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(new Gson().toJson(result));
        return false;
    }

    /**
     * 回来的时候  刚刚执行完Controller  还没有视图渲染  逻辑视图  "main"
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 整个请求结束之后，视图已经渲染完毕   例如：逻辑视图 “main”  /WEB-INF/main.jsp
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
