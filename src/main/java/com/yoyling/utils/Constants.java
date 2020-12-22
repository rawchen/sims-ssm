package com.yoyling.utils;

import java.util.Arrays;
import java.util.List;

/**
 * 存放一些常量
 */
public class Constants {

    public static final String CHARACTER_ENCODING = "UTF-8";

    public static final boolean TEMPLATE_CACHEABLE = false;

    public static final String TEMPLATE_PREFIX = "/WEB-INF/templates/";

    public static final String TEMPLATE_SUFFIX = "/WEB-INF/templates/";

    public final static String TEMPLATE_MODE = "HTML5";

    public final static Integer TEMPLATE_ORDER = 1;

    public static final String USER_DEFAULT_ICON_DIR = "/static/custom/img/uploadUserIcon";

    public static final String USER_DEFAULT_ICON_NAME = "user_default_icon.jpg";

    public static final String USER_DEFAULT_ICON_PATH = USER_DEFAULT_ICON_DIR + "/" + USER_DEFAULT_ICON_NAME;

    public static final String EMAILVERIFYCODE_SESSION = "emailVerifyCode";

    public static final String USEREMAIL_SESSION = "userEmail";

    public static final String USER_MODEL = "userInfo";

    public static final String USERINFO_SESSION = "userSessionInfo";

    public static final String USER_ELSEINDENTITY_MODEL = "elseIdentity";

    public static final String TEACHER_ALL_INFO_MODEL = "teaAllInfo";

    public static final String TEACHER_MODEL = "teaInfo";

    public static final String STUDENT_ALL_INFO_MODEL = "stuAllInfo";

    public static final String STUDENT_MODEL = "stuInfo";

    public static final String CLASS_ALL_INFO_MODEL = "classAllInfo";

    public static final String MAJOR_ALL_INFO_MODEL = "majorAllInfo";

    public static final String COLLEGE_ALL_INFO_MODEL = "collegeAllInfo";

    public static final String STUDENT_PERCENT_BY_SEX = "studentPercent";

    public static final List<String> stuDegrees= Arrays.asList("本科","硕士","博士");
}
