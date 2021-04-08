
package com.tess.futrash.model.pojo_order.post_order;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class PostOrderRespon {

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
    @SerializedName("customer_name")
    @Expose
    private String customerName;
    @SerializedName("customer_location")
    @Expose
    private String customerLocation;
    @SerializedName("customer_phone")
    @Expose
    private String customerPhone;
    @SerializedName("shipping_type")
    @Expose
    private String shippingType;
    @SerializedName("jenis_makanan")
    @Expose
    private String jenisMakanan;
    @SerializedName("tidak_dikonsumsi_sejak")
    @Expose
    private String tidakDikonsumsiSejak;
    @SerializedName("dijual_karena")
    @Expose
    private String dijualKarena;
    @SerializedName("berat_makanan")
    @Expose
    private String beratMakanan;
    @SerializedName("nama_toko")
    @Expose
    private String namaToko;
    @SerializedName("nama_penjual")
    @Expose
    private String namaPenjual;
    @SerializedName("lokasi_makanan")
    @Expose
    private String lokasiMakanan;
    @SerializedName("harga_makanan")
    @Expose
    private String hargaMakanan;
    @SerializedName("saran_penggunaan")
    @Expose
    private String saranPenggunaan;
    @SerializedName("kandungan_kimia")
    @Expose
    private String kandunganKimia;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("item_date")
    @Expose
    private String itemDate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PostOrderRespon() {
    }

    /**
     * 
     * @param kandunganKimia
     * @param customerLocation
     * @param hargaMakanan
     * @param shippingType
     * @param saranPenggunaan
     * @param itemDate
     * @param lokasiMakanan
     * @param dijualKarena
     * @param customerName
     * @param createdAt
     * @param beratMakanan
     * @param namaPenjual
     * @param customerPhone
     * @param jenisMakanan
     * @param phoneNumber
     * @param imageUrl
     * @param namaToko
     * @param id
     * @param tidakDikonsumsiSejak
     * @param updatedAt
     */
    public PostOrderRespon(String createdAt, String updatedAt, long id, String imageUrl, String customerName, String customerLocation, String customerPhone, String shippingType, String jenisMakanan, String tidakDikonsumsiSejak, String dijualKarena, String beratMakanan, String namaToko, String namaPenjual, String lokasiMakanan, String hargaMakanan, String saranPenggunaan, String kandunganKimia, String phoneNumber, String itemDate) {
        super();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.imageUrl = imageUrl;
        this.customerName = customerName;
        this.customerLocation = customerLocation;
        this.customerPhone = customerPhone;
        this.shippingType = shippingType;
        this.jenisMakanan = jenisMakanan;
        this.tidakDikonsumsiSejak = tidakDikonsumsiSejak;
        this.dijualKarena = dijualKarena;
        this.beratMakanan = beratMakanan;
        this.namaToko = namaToko;
        this.namaPenjual = namaPenjual;
        this.lokasiMakanan = lokasiMakanan;
        this.hargaMakanan = hargaMakanan;
        this.saranPenggunaan = saranPenggunaan;
        this.kandunganKimia = kandunganKimia;
        this.phoneNumber = phoneNumber;
        this.itemDate = itemDate;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLocation() {
        return customerLocation;
    }

    public void setCustomerLocation(String customerLocation) {
        this.customerLocation = customerLocation;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }

    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    public String getTidakDikonsumsiSejak() {
        return tidakDikonsumsiSejak;
    }

    public void setTidakDikonsumsiSejak(String tidakDikonsumsiSejak) {
        this.tidakDikonsumsiSejak = tidakDikonsumsiSejak;
    }

    public String getDijualKarena() {
        return dijualKarena;
    }

    public void setDijualKarena(String dijualKarena) {
        this.dijualKarena = dijualKarena;
    }

    public String getBeratMakanan() {
        return beratMakanan;
    }

    public void setBeratMakanan(String beratMakanan) {
        this.beratMakanan = beratMakanan;
    }

    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    public String getNamaPenjual() {
        return namaPenjual;
    }

    public void setNamaPenjual(String namaPenjual) {
        this.namaPenjual = namaPenjual;
    }

    public String getLokasiMakanan() {
        return lokasiMakanan;
    }

    public void setLokasiMakanan(String lokasiMakanan) {
        this.lokasiMakanan = lokasiMakanan;
    }

    public String getHargaMakanan() {
        return hargaMakanan;
    }

    public void setHargaMakanan(String hargaMakanan) {
        this.hargaMakanan = hargaMakanan;
    }

    public String getSaranPenggunaan() {
        return saranPenggunaan;
    }

    public void setSaranPenggunaan(String saranPenggunaan) {
        this.saranPenggunaan = saranPenggunaan;
    }

    public String getKandunganKimia() {
        return kandunganKimia;
    }

    public void setKandunganKimia(String kandunganKimia) {
        this.kandunganKimia = kandunganKimia;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getItemDate() {
        return itemDate;
    }

    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }

}
