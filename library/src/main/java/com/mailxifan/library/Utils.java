package com.mailxifan.library;

import android.text.TextUtils;

/**
 * Created by zhangqilin
 * email:mailxifan@126.com
 * date:2017/8/23
 * 验证工具类大全
 */

public class Utils {
    /**
     * 验证手机格式
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobile(String mobiles) {
        /*
         * 移动：134、135、136、137、138、139、145、147、150、151、157(TD)、158、159、187、188等等
		 * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
		 * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		 */
        String telRegex = "[1][34578]\\d{9}";// "[1]"代表第1位为数字1，"[34578]"代表第二位可以为3、4、5、7、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles))
            return false;
        else
            return mobiles.matches(telRegex);
    }

    /**
     * 邮箱验证
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        String s = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$";
        return email.matches(s);
    }

    /**
     * 防止按钮被快速点击
     */
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 1000) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
