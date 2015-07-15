package com.hubserver.controller;

import com.xiaomi.push.sdk.ErrorCode;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Sender;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Created by admin2 on 2015/7/15.
 */
public class XMPush {

    public static boolean send(String regid,String msg)
    {
        boolean re = false;
        com.xiaomi.xmpush.server.Constants.useOfficial();
        Sender sender = new Sender(Constants.APP_SECRET);
        Message message = new Message.Builder()
                .payload(msg)
                .passThrough(1)
                .timeToLive(1000)
                .restrictedPackageName(Constants.APP_PACKAGE)
                .build();

        try {
            com.xiaomi.xmpush.server.Result result = sender.send(message, regid,1);

            if(result.getErrorCode() == ErrorCode.Success)
            {
                re = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return re;
    }
}
