
package com.tess.futrash.model.pojo_confirmation.get_confirm;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Content {

    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("terima_tolak")
    @Expose
    private String terimaTolak;
    @SerializedName("catatan_alasan")
    @Expose
    private String catatanAlasan;
    @SerializedName("jenis_makanan")
    @Expose
    private String jenisMakanan;
    @SerializedName("lokasi_customer")
    @Expose
    private String lokasiCustomer;
    @SerializedName("nama_customer")
    @Expose
    private String namaCustomer;
    @SerializedName("phone_customer")
    @Expose
    private String phoneCustomer;
    @SerializedName("lokasi_mitra")
    @Expose
    private String lokasiMitra;
    @SerializedName("nama_mitra")
    @Expose
    private String namaMitra;
    @SerializedName("phone_mitra")
    @Expose
    private String phoneMitra;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Content() {
    }

    /**
     * 
     * @param namaCustomer
     * @param terimaTolak
     * @param createdAt
     * @param jenisMakanan
     * @param namaMitra
     * @param imageUrl
     * @param id
     * @param catatanAlasan
     * @param phoneCustomer
     * @param lokasiCustomer
     * @param updatedAt
     * @param lokasiMitra
     * @param phoneMitra
     */
    public Content(String createdAt, String updatedAt, long id, String imageUrl, String terimaTolak, String catatanAlasan, String jenisMakanan, String lokasiCustomer, String namaCustomer, String phoneCustomer, String lokasiMitra, String namaMitra, String phoneMitra) {
        super();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.imageUrl = imageUrl;
        this.terimaTolak = terimaTolak;
        this.catatanAlasan = catatanAlasan;
        this.jenisMakanan = jenisMakanan;
        this.lokasiCustomer = lokasiCustomer;
        this.namaCustomer = namaCustomer;
        this.phoneCustomer = phoneCustomer;
        this.lokasiMitra = lokasiMitra;
        this.namaMitra = namaMitra;
        this.phoneMitra = phoneMitra;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTerimaTolak() {
        return terimaTolak;
    }

    public void setTerimaTolak(String terimaTolak) {
        this.terimaTolak = terimaTolak;
    }

    public String getCatatanAlasan() {
        return catatanAlasan;
    }

    public void setCatatanAlasan(String catatanAlasan) {
        this.catatanAlasan = catatanAlasan;
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }

    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    public String getLokasiCustomer() {
        return lokasiCustomer;
    }

    public void setLokasiCustomer(String lokasiCustomer) {
        this.lokasiCustomer = lokasiCustomer;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getLokasiMitra() {
        return lokasiMitra;
    }

    public void setLokasiMitra(String lokasiMitra) {
        this.lokasiMitra = lokasiMitra;
    }

    public String getNamaMitra() {
        return namaMitra;
    }

    public void setNamaMitra(String namaMitra) {
        this.namaMitra = namaMitra;
    }

    public String getPhoneMitra() {
        return phoneMitra;
    }

    public void setPhoneMitra(String phoneMitra) {
        this.phoneMitra = phoneMitra;
    }

}
