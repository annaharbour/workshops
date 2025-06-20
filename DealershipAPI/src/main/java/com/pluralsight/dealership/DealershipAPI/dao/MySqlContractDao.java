package com.pluralsight.dealership.DealershipAPI.dao;

import com.pluralsight.dealership.DealershipAPI.model.Lease;
import com.pluralsight.dealership.DealershipAPI.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlContractDao implements ContractDao {

    private DataSource dataSource;

    @Autowired
    public MySqlContractDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Sale> getAllSales() {
        String query = "SELECT * FROM sales_contracts";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Sale> contracts = new ArrayList<>();
                while (resultSet.next()) {
                    int saleId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    boolean isFinanced = resultSet.getBoolean("financed");
                    String vin = resultSet.getString("VIN");
                    Sale sale = new Sale(saleId, name, email, phone, vin, isFinanced);
                    contracts.add(sale);
                }
                return contracts;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: Failed to fetch all sales contracts.");
        }
        System.err.println("Error: Failed to fetch all sales contracts.");
        return null;
    }

    @Override
    public List<Lease> getAllLeases() {
        String query = "SELECT * FROM sales_contracts";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Lease> contracts = new ArrayList<>();
                while (resultSet.next()) {
                    int leaseId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    String vin = resultSet.getString("VIN");
                    Lease lease = new Lease(leaseId, name, email, phone, vin);
                    contracts.add(lease);
                }
                return contracts;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: Failed to fetch all sales contracts.");
        }
        System.err.println("Error: Failed to fetch all sales contracts.");
        return null;
    }
    @Override
    public Lease updateSale(int id, Lease lease) {
        String query = "UPDATE sales_contracts SET name = ?, email = ?, phone = ?, VIN = ? WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, lease.getCustomer());
            preparedStatement.setString(2, lease.getEmail());
            preparedStatement.setString(3, lease.getPhone());
            preparedStatement.setString(4, lease.getVin());
            preparedStatement.setInt(5, id);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                lease.setId(id);
                return lease;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Lease updateLease(int id, Sale sale) {
        // Probably a logic error: updating a lease using a Sale object? But assuming typo:
        String query = "UPDATE sales_contracts SET name = ?, email = ?, phone = ?, VIN = ?, financed = ? WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sale.getCustomer());
            preparedStatement.setString(2, sale.getEmail());
            preparedStatement.setString(3, sale.getPhone());
            preparedStatement.setString(4, sale.getVin());
            preparedStatement.setBoolean(5, sale.isFinanced());
            preparedStatement.setInt(6, id);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                return new Lease(id, sale.getCustomer(), sale.getEmail(), sale.getPhone(), sale.getVin());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteSale(int id) {
        String query = "DELETE FROM sales_contracts WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLease(int id) {
        String query = "DELETE FROM lease_contracts WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sale addSale(Sale sale) {
        String query = "INSERT INTO sales_contracts (name, email, phone, VIN, financed) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, sale.getCustomer());
            preparedStatement.setString(2, sale.getEmail());
            preparedStatement.setString(3, sale.getPhone());
            preparedStatement.setString(4, sale.getVin());
            preparedStatement.setBoolean(5, sale.isFinanced());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        sale.setId(generatedKeys.getInt(1));
                        return sale;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Lease addLease(Lease lease) {
        String query = "INSERT INTO lease_contracts (name, email, phone, VIN) VALUES (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, lease.getCustomer());
            preparedStatement.setString(2, lease.getEmail());
            preparedStatement.setString(3, lease.getPhone());
            preparedStatement.setString(4, lease.getVin());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        lease.setId(generatedKeys.getInt(1));
                        return lease;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Lease getLease(int id) {
        String query = "SELECT * FROM lease_contracts WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Lease(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("phone"),
                            resultSet.getString("VIN")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Sale getSale(int id) {
        String query = "SELECT * FROM sales_contracts WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Sale(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("phone"),
                            resultSet.getString("VIN"),
                            resultSet.getBoolean("financed")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
