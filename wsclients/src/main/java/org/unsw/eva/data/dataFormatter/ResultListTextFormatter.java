package org.unsw.eva.data.dataFormatter;

import org.unsw.eva.data.Pair;
import org.unsw.eva.data.ResultData;

import java.util.List;

/**
 *
 * @author shrimpy
 */
public class ResultListTextFormatter implements ResultListFormatter {

    public String formatResultData(List<ResultData> dataList) {
        StringBuilder sb = new StringBuilder();
        StringBuilder subSB;
        for (ResultData resultData : dataList) {
            // print the name of the data
            sb.append(resultData.getDescription());
            sb.append("\n");

            /**
             * print connection time
             */
            subSB = new StringBuilder();
            for (int i = 0; i < resultData.getConnectionTimers().size(); i++) {
                Pair<Long, Long> pair = resultData.getConnectionTimers().get(i);

                /**
                 * x axis
                 * 
                 * the time difference with the starting time that we get the connection time
                 */
                sb.append((pair.getA() - resultData.getStartingTime()) / 1000);

                /**
                 * y axis
                 *
                 * the connection time
                 */
                subSB.append(pair.getB());

                if (i != (resultData.getConnectionTimers().size() - 1)) {
                    sb.append(",");
                    subSB.append(",");
                }
            }
            sb.append("\n");
            sb.append(subSB.toString());
            sb.append("\n");

            /**
             * print computation time
             */
            subSB = new StringBuilder();
            for (int i = 0; i < resultData.getConnectionTimers().size(); i++) {
                Pair<Long, Long> pair = resultData.getConnectionTimers().get(i);

                /**
                 * x axis
                 *
                 * the time difference with the starting time that we get the computation time
                 */
                sb.append((pair.getA() - resultData.getStartingTime()) / 1000);

                /**
                 * y axis
                 *
                 * the computation time
                 */
                subSB.append(pair.getB());

                if (i != (resultData.getConnectionTimers().size() - 1)) {
                    sb.append(",");
                    subSB.append(",");
                }
            }
            sb.append("\n");
            sb.append(subSB.toString());
            sb.append("\n");

        }
        return sb.toString();
    }
}
