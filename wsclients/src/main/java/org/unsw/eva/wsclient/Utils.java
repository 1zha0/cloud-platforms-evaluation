package org.unsw.eva.wsclient;

import org.cloudcomputingevaluation.Result;

/**
 *
 * @author shrimpy
 */
public class Utils {

    public static synchronized String convertResultToString(Result result) {

        StringBuilder sb = new StringBuilder(result.getClass().getName());
        sb.append("( id : ");
        sb.append(result.getId());
        sb.append(" | value : ");
        sb.append(result.getValue());
        sb.append(" | timer : ");
        sb.append(result.getTimer());
        sb.append(" )");
//        sb.append(result.toString());

        return sb.toString();
    }
}
