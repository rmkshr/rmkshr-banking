package com.scb.banking.enums;

/**
 * @author ramkishore
 * The enum containing account types and respective codes
 */
public enum AccountTypeEnum {

    SAVINGS(1, "SAVINGS"),
    CURRENT(2, "CURRENT");

    AccountTypeEnum(Integer code, String accountType) {
        this.code = code;
        this.accountType = accountType;
    }

    private final Integer code;

    public Integer getCode() {
        return code;
    }

    public String getAccountType() {
        return accountType;
    }

    private final String accountType;

    @Override
    public String toString() {
        return "AccountTypeEnum{" +
                "code=" + code +
                ", accountType='" + accountType + '\'' +
                '}';
    }

    public static String getAccountType(Integer parameter) throws Exception {
        try {
            for (AccountTypeEnum enumValue : AccountTypeEnum.values()) {
                if (enumValue.getCode().equals(parameter)) {
                    return enumValue.getAccountType();
                }
            }
            throw new Exception("Invalid Account Type");
        } catch (Exception exception) {
            throw exception;
        }
    }
}
