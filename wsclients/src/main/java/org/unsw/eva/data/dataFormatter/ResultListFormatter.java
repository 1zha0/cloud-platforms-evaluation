package org.unsw.eva.data.dataFormatter;

import java.util.List;
import org.unsw.eva.data.ResultData;

/**
 *
 * @author shrimpy
 */
public interface ResultListFormatter {

    String formatResultData(List<ResultData> dataList);
}
