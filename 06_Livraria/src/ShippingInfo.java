public class ShippingInfo {
    private String address;

    private Shipper shipper;

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * @return Shipper return the shipper
     */
    public Shipper getShipper() {
        return shipper;
    }

    /**
     * @param shipper the shipper to set
     */
    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

}