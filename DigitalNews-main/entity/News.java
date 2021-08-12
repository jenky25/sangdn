package entity;

import java.util.Date;


public class News {

    private int id;
    private String title;
    private String description;
    private String image;
    private String author;
    private Date timePost;
    private String shortDes;

    /**
     * Constructor with no parameter
     */
    public News() {
    }

    /**
     * Constructor with parameter
     *
     * @param id it is an <code>int</code>
     * @param title it is a <code>String</code>
     * @param description it is a <code>String</code>
     * @param image it is a <code>String</code>
     * @param author it is a <code>String</code>
     * @param timePost it is a <code>Date</code>
     * @param shortDes it is a <code>string</code>
     */
    public News(int id, String title, String description, String image, String author, Date timePost, String shortDes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.timePost = timePost;
        this.shortDes = shortDes;
    }

    /**
     * Get value of id attribute of <code>New</code> object
     *
     * @return id of News.
     */
    public int getId() {
        return id;
    }

    /**
     * Set value of id attribute of <code>New</code>object
     *
     * @param id of <code>News</code>. It is an <code>int</code> data type
     *
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value of title attribute of <code>News</code> object
     *
     *
     * @return title of <code>News</code>. 
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set value of title attribute of <code>News</code> object
     *
     * @param title of <code>News</code>. It is a <code>java.lang.String</code> object
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get value of description attribute of <code>News</code>object
     *
     *
     * @return description of News. 
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set value of description attribute of <code>News</code> object
     *
     * @param description of <code>News</code>. It is a <code>java.lang.String</code> object
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get value of image attribute of object
     *
     * @return image of News. 
     */
    public String getImage() {
        return image;
    }

    /**
     * Set value of image attribute of <code>News</code> object
     *
     * @param image of <code>News</code>. It is a <code>java.lang.String</code> object
     *
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get value of author attribute of <code>News</code> object
     *
     * @return author of News. 
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set value of author attribute of <code>News</code> object
     *
     * @param author of <code>News</code>. It is a <code>java.lang.String</code> object
     *
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get value of timePost attribute of <code>News</code> object
     *
     * @return timePost of News.
     */
    public Date getTimePost() {
        return timePost;
    }

    /**
     * Set value of timePost attribute of <code>News</code> object
     *
     * @param timePost of <code>News</code>. It is a <code>date</code> object
     *
     */
    public void setTimePost(Date timePost) {
        this.timePost = timePost;
    }

    /**
     * Get value of shortDes attribute of <code>News</code> object
     *
     * @return shortDes of News. 
     */
    public String getShortDes() {
        return shortDes;
    }

    /**
     * Set value of shortDes attribute of <code>News</code> object
     *
     * @param shortDes of <code>News</code>. It is a <code>java.lang.String</code> object
     */
    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }


}
