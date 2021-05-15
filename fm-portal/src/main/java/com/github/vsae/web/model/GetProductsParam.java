package com.github.vsae.web.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Date;

public class GetProductsParam {

    @Min(1)
    @Max(100)
    @ApiModelProperty(example = "10", dataType = "int", notes = "show count", required = true)
    private Integer limit;

    @ApiModelProperty(example = "0", dataType = "int", notes = "offset", required = true)
    private Integer offset;

    @ApiModelProperty(example = "1", dataType = "int", notes = "brand Seqno")
    private Integer brandSeqno;

    @ApiModelProperty(example = "1", dataType = "int", notes = "category Seqno")
    private Integer productCategorySeqno;

    @ApiModelProperty(example = "100.00", dataType = "BigDecimal", notes = "price")
    private BigDecimal price;

    @ApiModelProperty(example = "yellow", dataType = "String", notes = "color")
    private String color;

    @ApiModelProperty(example = "yellow", dataType = "String", notes = "size")
    private String size;

    @ApiModelProperty(example = "1", dataType = "Integer", notes = "sortTag")
    private Integer sortTag;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getBrandSeqno() {
        return brandSeqno;
    }

    public void setBrandSeqno(Integer brandSeqno) {
        this.brandSeqno = brandSeqno;
    }

    public Integer getProductCategorySeqno() {
        return productCategorySeqno;
    }

    public void setProductCategorySeqno(Integer productCategorySeqno) {
        this.productCategorySeqno = productCategorySeqno;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getSortTag() {
        return sortTag;
    }

    public void setSortTag(Integer sortTag) {
        this.sortTag = sortTag;
    }
}
