package com.wsn.conference.submission.entity.enums;

public enum PatternEnum {
    /**
     * 类似于初始化类，调用下方的构造器
     */
    ACCOUNT_PATTERN(1, "用户名合法性匹配正则表达式", "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$"),
    /**
     * ^ 匹配一行的开头位置
     * (?![0-9]+$) 预测该位置后面不全是数字，不能以全是数字结尾
     * (?![a-zA-Z]+$) 预测该位置后面不全是字母，不能以全是字母结尾
     * [0-9A-Za-z]{8,16} 由8-16位数字及字母组成，两者必须同时兼备
     * $ 匹配行结尾位置
     */
    PASSWORD_PATTERN(2, "密码合法性匹配正则表达式", "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$"),
    EMAIL_PATTERN(3, "邮箱合法性匹配正则表达式", "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");

    private int index;
    private String name;
    private String value;

    PatternEnum(int index, String name, String value) {
        this.index = index;
        this.name = name;
        this.value = value;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
