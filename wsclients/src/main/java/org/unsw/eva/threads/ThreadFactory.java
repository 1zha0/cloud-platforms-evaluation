package org.unsw.eva.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
@Deprecated
public class ThreadFactory {

    private static final Logger log = LoggerFactory.getLogger(ThreadFactory.class);

    public static EvaluationThread coloneThreadInstance(EvaluationThread e, Integer round) {
        EvaluationThread t = null;
        try {
            t = e.getClass().newInstance();
            t.setName(e.getName());
            t.setRepeatNumberOfTime(e.getRepeatNumberOfTime());
            t.setServerType(e.getServerType());
            t.setStrageyTest(e.getStrageyTest());
            t.setVersion(e.getVersion());
            t.setRound(round);

            /**
             * i know it is a hack, but cannot think of a better way to do it so far...
             * forgive me.
             */
            t.initiate(t.getRepeatNumberOfTime());
        } catch (Exception ex) {
            log.error("Failed to create new instance of thread.", ex);
        }
        return t;
    }
}
