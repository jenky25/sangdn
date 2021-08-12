package dao;

import entity.News;
import java.util.List;


public interface DigitalDAO {

    /**
     * Select top digital news from News table. All information of the News will be
     * return The result contains a list of <code>News</code> object with id,
     * title,description, image, author, short description and time post
     *
     * @param top the amount want to select. It is an <code>int</code> data type
     * @return a list of <code>News</code>. It is <code>java.util.List</code>
     * object
     * @throws Exception
     */
    public List<News> getTop(int top) throws Exception;

    /**
     * Select digital news from News table by id. All information of the News
     * will be return The result contains a <code>News</code> object with id,
     * title,description, image, author, short description and time post
     *
     * @param id the id of digital news. It is a code <code>int</code> data type
     * @return <code>News</code> object. It is a <code>entity.News</code> object
     * @throws Exception
     */
    public News getNewsById(int id) throws Exception;

    /**
     * Select digital news. All information of the News will be return the result
     * contains a list of <code>News</code> object
     *
     * @param txt the title of news. It is a <code>java.lang.String</code>
     * object
     * @param pageIndex the index of page. It is an <code>int</code> data type
     * @param pageSize the index of page. It is an <code>int</code> data type
     * @return a list of <code>News</code>. It is a <code>java.util.List</code>
     * object
     * @throws Exception
     */
    public List<News> search(String txt, int pageIndex, int pageSize) throws Exception;

    /**
     * Select amount of news by title. All information of the News will be
     * return The result contains a list of <code>News</code> object with id,
     * title,description, image, author, short description and time post
     *
     * @param txt the title of news.It is a <code>java.lang.String</code> object
     * @return a number. It is an <code>int</code> data type
     * @throws Exception
     */
    
    public int count(String txt) throws Exception;
    
}
