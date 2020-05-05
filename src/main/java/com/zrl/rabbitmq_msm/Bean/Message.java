package com.zrl.rabbitmq_msm.Bean;

/*
 *@autho  zhengruilong
 *@date 2020-03-16
 */
public class Message {


    private static final String  SUCCESS="SUCCESS";
    private static final String  ERROR="ERROR";

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public static String getERROR() {
        return ERROR;
    }
}
