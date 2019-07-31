package com.tauk.datarule.exception;

public enum RuleExceptionMessage {

	INVALID_VARCHAR_LENGTH_SIZE(40001, "数据规则中不包含length属性,无法进行VarcharTypeRule验证"),
	INVALID_NUMBER_RANGE_SIZE(40002, "数据规则中不包含minvalue或者maxvalue属性,无法进行DataRangeRule验证");
	
	private final int code;
    private final String message;

    RuleExceptionMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public static RuleExceptionMessage valueOf(int code) {
    	RuleExceptionMessage[] messages = values();
        int len = values().length;
        for (int i = 0; i < len; i++) {
        	RuleExceptionMessage message = messages[i];
            if (message.code == code) {
                return message;
            }
        }
        throw new IllegalArgumentException("不存在的常量值 ["
                + code + "]");
    }


    
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    
}
