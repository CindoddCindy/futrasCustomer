
package com.tess.futrash.model.pojo_chart.get_chart;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Sort {

    @SerializedName("sorted")
    @Expose
    private boolean sorted;
    @SerializedName("unsorted")
    @Expose
    private boolean unsorted;
    @SerializedName("empty")
    @Expose
    private boolean empty;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sort() {
    }

    /**
     * 
     * @param unsorted
     * @param sorted
     * @param empty
     */
    public Sort(boolean sorted, boolean unsorted, boolean empty) {
        super();
        this.sorted = sorted;
        this.unsorted = unsorted;
        this.empty = empty;
    }

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

    public boolean isUnsorted() {
        return unsorted;
    }

    public void setUnsorted(boolean unsorted) {
        this.unsorted = unsorted;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

}
