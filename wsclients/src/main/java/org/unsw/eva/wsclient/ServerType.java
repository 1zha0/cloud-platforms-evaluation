package org.unsw.eva.wsclient;

/**
 *
 * @author shrimpy
 */
public enum ServerType {

    AZURE("azure"),
    AMAZONE("amazone"),
    APP_ENGINE_INSTANCE_RESPONSE("appEngine_instanceResponse"),
    APP_ENGINE_CREATE("appEngine_create"),
    APP_ENGINE_READ("appEngine_read"),
    APP_ENGINE_CREATE_DATA_BY_NUMBER("appEngine_createDataByNumber"),
    APP_ENGINE_READ_DATA_BY_NUMBER("appEngine_readDataByNumber");
    private String name;

    private ServerType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}