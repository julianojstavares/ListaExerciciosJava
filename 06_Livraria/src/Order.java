public class Order {
    private Book book;
    private ShippingInfo shippingInfo;
    private BillingInfo billingInfo;
    private User user;

    /**
     * @return Book return the book
     */
    public Book getBook() {
        return book;
    }

    /**
     * @param book the book to set
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * @return ShippingInfo return the shippingInfo
     */
    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    /**
     * @param shippingInfo the shippingInfo to set
     */
    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    /**
     * @return BillingInfo return the billingInfo
     */
    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    /**
     * @param billingInfo the billingInfo to set
     */
    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    /**
     * @return User return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    public boolean isFullfilled()
    {
        if(
            book != null &&
            shippingInfo != null &&
            billingInfo != null &&
            user != null
        )
        {
            return true;
        }
        return false;
    }


}
