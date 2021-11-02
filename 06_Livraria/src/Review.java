public class Review {
    private String text;
    private Reviewer reviewer;
    

    /**
     * @return String return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return Reviewer return the reviewer
     */
    public Reviewer getReviewer() {
        return reviewer;
    }

    /**
     * @param reviewer the reviewer to set
     */
    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

}
