package com.flipkart.constant;

public enum BankEnum {

    SBI,ICICI,AXIS,CASH;

    public static BankEnum getBankName(int value)
    {
        switch(value)
        {
            case 1:
                return BankEnum.SBI;
            case 2:
                return BankEnum.ICICI;
            case 3:
                return BankEnum.AXIS;
            default:
                return null;

        }

    }
}
