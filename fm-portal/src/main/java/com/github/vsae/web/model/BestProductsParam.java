package com.github.vsae.web.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BestProductsParam {

    @NotNull
    @ApiModelProperty(example = "top", required = true)
    @Min(1)
    @Max(10)
    private int top;

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
