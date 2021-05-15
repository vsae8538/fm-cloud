package com.github.vsae.web.model;

import com.github.vsae.api.resource.utils.ConstantSet;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class ProductsDetailParam {

    @NotNull
    @ApiModelProperty(example = "seqno", required = true)
    private Integer seqno;

    public Integer getSeqno() {
        return seqno;
    }

    public void setSeqno(Integer seqno) {
        this.seqno = seqno;
    }

}
