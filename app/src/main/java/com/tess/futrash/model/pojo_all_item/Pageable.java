
package com.tess.futrash.model.pojo_all_item;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Pageable {

    @SerializedName("sort")
    @Expose
    private Sort sort;
    @SerializedName("offset")
    @Expose
    private long offset;
    @SerializedName("pageNumber")
    @Expose
    private long pageNumber;
    @SerializedName("pageSize")
    @Expose
    private long pageSize;
    @SerializedName("paged")
    @Expose
    private boolean paged;
    @SerializedName("unpaged")
    @Expose
    private boolean unpaged;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pageable() {
    }

    /**
     * 
     * @param paged
     * @param pageNumber
     * @param offset
     * @param pageSize
     * @param unpaged
     * @param sort
     */
    public Pageable(Sort sort, long offset, long pageNumber, long pageSize, boolean paged, boolean unpaged) {
        super();
        this.sort = sort;
        this.offset = offset;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.paged = paged;
        this.unpaged = unpaged;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isPaged() {
        return paged;
    }

    public void setPaged(boolean paged) {
        this.paged = paged;
    }

    public boolean isUnpaged() {
        return unpaged;
    }

    public void setUnpaged(boolean unpaged) {
        this.unpaged = unpaged;
    }

}
