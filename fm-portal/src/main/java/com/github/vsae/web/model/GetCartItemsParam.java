package com.github.vsae.web.model;

import com.github.vsae.api.resource.utils.ConstantSet;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class GetCartItemsParam {

    @NotNull
    @Pattern(regexp = ConstantSet.EMAIL_REGEXP)
    @ApiModelProperty(example = "userEmail", required = true)
    private String email;

    @NotNull
    @ApiModelProperty(example = "productSeqno", required = true)
    private List<Integer> productSeqnoList;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getProductSeqnoList() {
        return productSeqnoList;
    }

    public void setProductSeqnoList(List<Integer> productSeqnoList) {
        this.productSeqnoList = productSeqnoList;
    }
}
