package org.unsw.eva.data;

import java.io.Serializable;

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
        ENDING_TIME("Ending Time");
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
    private Boolean isError = Boolean.FALSE;
    private Long EndingTime;

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

    public Boolean getIsError() {
        return isError;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
    }
}
