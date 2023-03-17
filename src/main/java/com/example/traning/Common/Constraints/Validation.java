package com.example.traning.Common.Constraints;

import com.example.traning.Common.Constant;
import com.example.traning.Common.StringPool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean isNull(String value) {
        if (value == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotNull(String value) {
        if (isNull(value)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isNull(Long value) {
        if (value == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotNull(Long value) {
        if (isNull(value)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isNull(Boolean value) {
        if (value == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotNull(Boolean value) {
        if (isNull(value)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPhoneVN(String value) {
        if (isNotNull(value)) {
            Pattern pattern = Pattern.compile(Constant.PhoneVN);
            Matcher matcher = pattern.matcher(value);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCode(String value) {
        if (isNotNull(value)) {
            Pattern pattern = Pattern.compile(Constant.Code);
            Matcher matcher = pattern.matcher(value);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCharVN(String value) {
        if (isNotNull(value)) {
            Pattern pattern = Pattern.compile(Constant.CharVN);
            Matcher matcher = pattern.matcher(value);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isComma(char value) {
        if (value == StringPool.COMMA) {
            return true;
        }
        return false;
    }
}
