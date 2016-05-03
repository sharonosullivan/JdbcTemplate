package com.zac.dao;

import com.zac.model.Contact;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Contact dao implementation
 * Created by zac on 5/3/16.
 */
public class ContactDAOImpl implements ContactDAO{

    private JdbcTemplate jdbcTemplate;

    public ContactDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(Contact contact) {
        if (contact.getId() > 0) {
            // update
            String sql = "UPDATE contact SET name=?,email=?,address=?,telephone=? " +
                    "WHERE contact_id=?";
            jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(),
                    contact.getTelephone(),contact.getId());
        } else {
            // insert
            String sql = "INSERT INTO contact (name, email, address, telephone)"
                    + "VALUES (?,?,?,?)";
            jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
                    contact.getAddress(), contact.getTelephone());
        }
    }

    public void delete(int contactId) {
        String sql = "DELETE FROM contact WHERE contact_id=?";
        jdbcTemplate.update(sql, contactId);
    }

    public Contact get(int contactId) {
        String sql = "SELECT * FROM contact WHERE contact_id=" + contactId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Contact>() {
            public Contact extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    Contact contact = new Contact();
                    contact.setId(resultSet.getInt("contact_id"));
                    contact.setName(resultSet.getString("name"));
                    contact.setEmail(resultSet.getString("email"));
                    contact.setAddress(resultSet.getString("address"));
                    contact.setTelephone(resultSet.getString("telephone"));
                    return contact;
                }
                return null;
            }
        });
    }

    public List<Contact> list() {
        String sql = "SELECT * FROM contact";
        List<Contact> contactList = jdbcTemplate.query(sql, new RowMapper<Contact>() {
            public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("contact_id"));
                contact.setName(resultSet.getString("name"));
                contact.setEmail(resultSet.getString("email"));
                contact.setAddress(resultSet.getString("address"));
                contact.setTelephone(resultSet.getString("telephone"));
                return contact;
            }
        });
        return contactList;
    }
}
