package org.unsw.eva.wsclient;

/**
 *
 * @author shrimpy
 */
public enum ServerType {

    AZURE("azure"),
    AMAZOnE("amazone"),
    APP_ENGINE_INSTANCE_RESPONSE("appEngine")
            ;
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
