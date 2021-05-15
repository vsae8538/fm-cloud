package com.github.vsae.api.resource.model;


import java.util.List;

public class UriSetting {
    private String id;

    private String uri;

    private List<Integer> authCodes;

    private String explain;

    private Boolean open;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Integer> getAuthCodes() {
        return authCodes;
    }

    public void setAuthCodes(List<Integer> authCodes) {
        this.authCodes = authCodes;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
