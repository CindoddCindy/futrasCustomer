
package com.tess.futrash.model.pojo_order.get_order;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class FoodTrashCustomerGetOrderRespon {

    @SerializedName("content")
    @Expose
    private List<Content> content = new ArrayList<Content>();
    @SerializedName("pageable")
    @Expose
    private Pageable pageable;
    @SerializedName("last")
    @Expose
    private boolean last;
    @SerializedName("totalPages")
    @Expose
    private long totalPages;
    @SerializedName("totalElements")
    @Expose
    private long totalElements;
    @SerializedName("size")
    @Expose
    private long size;
    @SerializedName("number")
    @Expose
    private long number;
    @SerializedName("sort")
    @Expose
    private Sort__1 sort;
    @SerializedName("first")
    @Expose
    private boolean first;
    @SerializedName("numberOfElements")
    @Expose
    private long numberOfElements;
    @SerializedName("empty")
    @Expose
    private boolean empty;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FoodTrashCustomerGetOrderRespon() {
    }

    /**
     * 
     * @param number
     * @param last
     * @param size
     * @param numberOfElements
     * @param totalPages
     * @param pageable
     * @param sort
     * @param content
     * @param first
     * @param totalElements
     * @param empty
     */
    public FoodTrashCustomerGetOrderRespon(List<Content> content, Pageable pageable, boolean last, long totalPages, long totalElements, long size, long number, Sort__1 sort, boolean first, long numberOfElements, boolean empty) {
        super();
        this.content = content;
        this.pageable = pageable;
        this.last = last;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.size = size;
        this.number = number;
        this.sort = sort;
        this.first = first;
        this.numberOfElements = numberOfElements;
        this.empty = empty;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Sort__1 getSort() {
        return sort;
    }

    public void setSort(Sort__1 sort) {
        this.sort = sort;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public long getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(long numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

}
