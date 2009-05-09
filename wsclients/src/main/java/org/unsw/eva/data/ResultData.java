package org.unsw.eva.data;

import java.io.Serializable;
import org.unsw.eva.ErrorCode;

/**
 *
 * @author shrimpy
 */
public class ResultData implements Serializable {

    public enum Field {

        DESCRIPTION("Description"),
        CONNECTION_TIME("Connection Time"),
        COMPUTATION_TIME("Computation Time"),
        ERROR("Error"),
        STARTING_TIME("Starting Time"),
        ENDING_TIME("Ending Time"),
        SERVER_ENDING_TIME("Server Ending Time"),
        ROUND_BELONG_TO("Round");
        private String value;

        private Field(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    private String description;
    private Long connectionTime;
    private Long computationTime;
    private ErrorCode error = ErrorCode.NONE;
    private Long startingTime;
    private Long EndingTime;
    private Long ServerSideEndingTime;
    private Integer round;

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Long getServerSideEndingTime() {
        return ServerSideEndingTime;
    }

    public void setServerSideEndingTime(Long ServerSideEndingTime) {
        this.ServerSideEndingTime = ServerSideEndingTime;
    }

    public Long getEndingTime() {
        return EndingTime;
    }

    public void setEndingTime(Long EndingTime) {
        this.EndingTime = EndingTime;
    }

    public Long getComputationTime() {
        return computationTime;
    }

    public void setComputationTime(Long computationTime) {
        this.computationTime = computationTime;
    }

    public Long getConnectionTime() {
        return connectionTime;
    }

    public void setConnectionTime(Long connectionTime) {
        this.connectionTime = connectionTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Long startingTime) {
        this.startingTime = startingTime;
    }

    public ErrorCode getError() {
        return error;
    }

    public void setError(ErrorCode error) {
        this.error = error;
    }
}
