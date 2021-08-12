package dao.impl;

import context.DBContext;
import dao.DigitalDAO;
import entity.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DigitalDAOImpl extends DBContext implements DigitalDAO {

    /**
     * This method used to get digital news by id form digital table
     *
     * @param id is an <code>int</code>
     * @return dig is a <code>Digital</code> object
     * @throws Exception
     */
    /**
     * Find the News order by id. All theNews has id matches with
     * searched id will be returned the result contain a News of
     * <code>entity.News</code> objects with id, title, description, image,
     * author, timePost, shortDes
     *
     * @param id the id of a news. It is an int number
     * @return a News of <code>News</code> objects. It is an
     * <code>entity.News</code> object
     * @throws Exception
     */
    @Override
    public News getNewsById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = "select * from news where id = ?";
        try {
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                News news = new News(result.getInt("ID"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("image"),
                        result.getString("author"),
                        result.getDate("timePost"),
                        result.getString("shortDes"));
                return news;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(result);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return null;
    }

    /**
     * This method used to get few first digital news form digital table
     *
     * @param top is an <code>int</code>
     * @return digital is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    
      /**
     * Find the list News order by time post descending. News has time
     * post most recent will be returned The result contain a list of
     * <code>entity.News</code> objects with id, title, description, image,
     * author, timePost, shortDes
     *
     * @param top the number of News want get. It is an int number
     * @return a list of <code>News</code> objects. It is a
     * <code>java.util.ArrayList</code> 
     * @throws Exception
     */
    @Override
    public List<News> getTop(int top) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<News> list = new ArrayList<>();
        String query = "select top (?) * from news\n"
                + "order by timePost desc";
        try {
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setInt(1, top);
            result = statement.executeQuery();
            while (result.next()) {
                News news = new News(result.getInt("ID"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("image"),
                        result.getString("author"),
                        result.getDate("timePost"),
                        result.getString("shortDes"));
                list.add(news);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(result);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return list;
    }

    /**
     * This method used to get all digital news have title contain the search
     * text form digital table
     *
     * @param txt it is a <code>String</code>
     * @param pageIndex it is an <code>int</code>
     * @param pageSize it is an <code>int</code>
     * @return digital it is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    
    
     /**
     * Find the list News by ID and title. All the News matched with id
     * order ascending, title and between pageIndex*(pageSize-2) and
     * pageIndex*pageSize will be returned the result contain a list of
     * <code>entity.News</code> objects with id, title, description, image,
     * author, timePost, shortDes
     *
     * @param txt the text in search box. It is a <code>java.lang.String</code> object
     * @param pageIndex the index of page. It is an int number
     * @param pageSize the max number of news in each page. It is an int number
     * @return a list of <code>News</code> objects. It is a <code>java.util.ArrayList</code> object
     * @throws Exception
     */
    @Override
    public List<News> search(String txt, int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<News> list = new ArrayList<>();
        String query = "select * from("
                + "select ROW_NUMBER() over (order by ID ASC) as rn, *\n"
                + "from news where title \n"
                + "like ?"
                + ")as x\n"
                + "where rn between ?*?-2"
                + "and ?*?";
        try {
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, "%" + txt + "%");
            statement.setInt(2, pageIndex);
            statement.setInt(3, pageSize);
            statement.setInt(4, pageIndex);
            statement.setInt(5, pageSize);
            result = statement.executeQuery();
            while (result.next()) {
                News news = new News(result.getInt("ID"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("image"),
                        result.getString("author"),
                        result.getDate("timePost"),
                        result.getString("shortDes"));
                list.add(news);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(result);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return list;
    }

    /**
     * This method used to get number of digital news have title user want form
     * digital table
     *
     * @param txt is a <code>String</code>
     * @return count is an <code>int</code>
     * @throws Exception
     */
    
    /**
     * Find the number of news after user search. All news has title matched
     * with searched title will be returned The result contain an int number
     *
     * @param txt the text in search box. It is a
     * <code>java.lang.String</code> object
     * @return an int number
     * @throws Exception
     */  
    @Override
    public int count(String txt) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        int count = 0;
        try {
            String query = "select count(*) from news \n"
                    + "where title like ?";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, "%" + txt + "%");
            result = statement.executeQuery();
            while (result.next()) {
                count = result.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(result);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return count;
    }
}
