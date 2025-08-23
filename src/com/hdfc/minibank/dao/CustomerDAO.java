package com.hdfc.minibank.dao;

import com.hdfc.minibank.Entities.Customer;
import com.hdfc.minibank.util.DBConnectionUtil;

import java.sql.*;

public class CustomerDAO {
    public void saveCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO CUSTOMER (customer_id, name, email, phone, dob) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getCustomerId());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhone());
            stmt.setDate(5, Date.valueOf(customer.getDateOfBirth()));

            stmt.executeUpdate();
        }
    }

    public Customer getCustomerById(String customerId) throws SQLException {
        String sql = "SELECT * FROM CUSTOMER WHERE customer_id = ?";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Customer(
                        rs.getString("customer_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getDate("dob").toLocalDate()
                );
            }
        }
        return null;
    }
}
