
package com.tess.futrash.model.pojo_chart.get_chart;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class ChartGetRespon {

    @SerializedName("content")
    @Expose
    private List<Content> content = new ArrayList<Content>();
    @SerializedName("pageable")
    @Expose
    private Pageable pageable;
    @SerializedName("totalElements")
    @Expose
    private long totalElements;
    @SerializedName("totalPages")
    @Expose
    private long totalPages;
    @SerializedName("last")
    @Expose
    private boolean last;
    @SerializedName("size")
    @Expose
    private long size;
    @SerializedName("number")
    @Expose
    private long number;
    @SerializedName("sort")
    @Expose
    private Sort__1 sort;
    @SerializedName("numberOfElements")
    @Expose
    private long numberOfElements;
    @SerializedName("first")
    @Expose
    private boolean first;
    @SerializedName("empty")
    @Expose
    private boolean empty;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ChartGetRespon() {
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
    public ChartGetRespon(List<Content> content, Pageable pageable, long totalElements, long totalPages, boolean last, long size, long number, Sort__1 sort, long numberOfElements, boolean first, boolean empty) {
        super();
        this.content = content;
        this.pageable = pageable;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.last = last;
        this.size = size;
        this.number = number;
        this.sort = sort;
        this.numberOfElements = numberOfElements;
        this.first = first;
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

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
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

    public long getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(long numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

}
