package edu.unsw.evaluation.template;

import java.util.List;
import java.util.Map;

/**
 *
 * @author shrimpy
 */
public class SoapMessageUtils implements IMessageTemplate {

    /**
     *
     * @param map
     *      Action with its parames
     *
     * @return
     *      Soap 1.1 mesage
     */
    public static String getSoap11Message(Map<String, List<Pair<String, String>>> map) {
        StringBuilder sb = new StringBuilder();
        for (String action : map.keySet()) {
            sb.append(buildAction(action, map.get(action)));
        }
        return MESSAGE_11.replace(ACTION, sb.toString());
    }

    /**
     *
     * @param map
     *      Action with its parames
     *
     * @return
     *      Soap 1.2 mesage
     */
    public static String getSoap12Message(Map<String, List<Pair<String, String>>> map) {
        StringBuilder sb = new StringBuilder();
        for (String action : map.keySet()) {
            sb.append(buildAction(action, map.get(action)));
        }
        return MESSAGE_12.replace(ACTION, sb.toString());
    }

    private static String buildAction(String action, List<Pair<String, String>> params) {
        // build parameters
        StringBuilder sb = new StringBuilder();
        for (Pair<String, String> pair : params) {
            sb.append(PARAMETER_PART.replaceAll(PARAMETER_NAME, pair.getName()).replaceAll(VALUE, pair.getValue()));
        }
        // inject parameters into action
        return ACTION_PART.replaceAll(ACTION_NAME, action).replace(PARAMETER, sb.toString());
    }
}
