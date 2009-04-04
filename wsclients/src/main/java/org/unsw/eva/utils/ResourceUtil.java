package org.unsw.eva.utils;

import org.cloudcomputingevaluation.Result;

/**
 *
 * @author shrimpy
 */
public class ResourceUtil {

    public static synchronized String convertResultToString(Result result) {

        StringBuilder sb = new StringBuilder(result.getClass().getSimpleName());
        sb.append("( id : ");
        sb.append(result.getId());
        sb.append(" | value : ");
        sb.append(result.getValue().getValue().length() > 10
                ? result.getValue().getValue().substring(0, 8) + "..."
                : result.getValue().getValue());
        sb.append(" | timer : ");
        sb.append(result.getTimer());
        sb.append(" )");
//        sb.append(result.toString());

        return sb.toString();
    }

    public static synchronized String getSendString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append("0123456789");
        }
        return sb.toString();
    }

    
}
