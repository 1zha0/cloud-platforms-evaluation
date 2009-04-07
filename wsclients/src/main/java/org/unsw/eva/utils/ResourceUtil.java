package org.unsw.eva.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.cloudcomputingevaluation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.data.ResultGroupData;

/**
 *
 * @author shrimpy
 */
public class ResourceUtil {

    private static final Logger log = LoggerFactory.getLogger(ResourceUtil.class);

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

    public static synchronized List<ResultGroupData> aggreagateResultGroup(List<ResultGroupData> list) {
        List<ResultGroupData> result = new ArrayList<ResultGroupData>();

        Map<String, ResultGroupData> resultMap = new HashMap<String, ResultGroupData>();

        for (ResultGroupData rg : list) {
            rg.populateData();
            if (resultMap.get(rg.getDescription()) == null) {
                ResultGroupData newRGD = new ResultGroupData();
                newRGD.getResultDatas().addAll(rg.getResultDatas());
                newRGD.setDescription(rg.getDescription());
                newRGD.setTotalRunningTime(rg.getTotalRunningTime());
                newRGD.setThreadNumber(newRGD.getThreadNumber() + 1);

                resultMap.put(rg.getDescription(), newRGD);
            } else {
                ResultGroupData temp = resultMap.get(rg.getDescription());
                temp.setThreadNumber(temp.getThreadNumber() + 1);
                temp.setTotalRunningTime(temp.getTotalRunningTime() + rg.getTotalRunningTime());
                temp.getResultDatas().addAll(rg.getResultDatas());
                
                resultMap.put(rg.getDescription(), temp);
            }
        }
        for (String key : resultMap.keySet()) {
            result.add(resultMap.get(key));
        }

        return result;
    }
}
