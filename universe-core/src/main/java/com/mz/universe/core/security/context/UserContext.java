package com.mz.universe.core.security.context;

import com.mz.universe.constant.ApplicationConstants;
import com.mz.universe.core.security.entity.User;

/**
 * @author mz
 * @version V1.0
 * @Title UserContext
 * @Package com.mz.universe.core.security.context
 * @Description 当前登陆用户上下文
 * @date 2020/7/20 7:21 下午
 */
public class UserContext {
    /**
     * 用threadLocal存储当前登陆的用户
     */
    private static final ThreadLocal<User> USER_HOLDER = new ThreadLocal();

    /**
     * 获取当前登陆用户
     *
     * @return
     */
    public static User getCurrentUser() {
        User user = USER_HOLDER.get();
        return user;
    }

    /**
     * 设置当前登陆用户 绑定到当前线程
     *
     * @param user
     */
    public static void setCurrentUser(User user) {
        USER_HOLDER.set(user);
    }

    /**
     * 清除当前用户
     */
    public static void removeCurrentUser() {
        USER_HOLDER.remove();
    }

    /**
     * 获取当前登陆用户code
     *
     * @return
     */
    public static String getCurrentUserCode() {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            return ApplicationConstants.SYSTEM_OPERATOR;
        }
        return currentUser.getUserCode();
    }
}