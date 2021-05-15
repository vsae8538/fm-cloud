package com.github.vsae.web.model;

import com.github.vsae.api.resource.utils.ConstantSet;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddCartParam {

    @NotNull
    @Pattern(regexp = ConstantSet.EMAIL_REGEXP)
    @ApiModelProperty(example = "userEmail", required = true)
    private String email;

    @NotNull
    @ApiModelProperty(example = "productSeqno", required = true)
    private Integer productSeqno;

    @NotNull
    @Max(99)
    @Min(1)
    @ApiModelProperty(example = "amount", required = true)
    private Integer count;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProductSeqno() {
        return productSeqno;
    }

    public void setProductSeqno(Integer productSeqno) {
        this.productSeqno = productSeqno;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
