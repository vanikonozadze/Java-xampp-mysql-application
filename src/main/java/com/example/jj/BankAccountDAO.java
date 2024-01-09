package com.example.jj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDAO {

    public static List<BankAccount> getInfo(){
        try {
            Connection connection = DatabaseConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM bank");
            ResultSet resultSet = statement.executeQuery();

            List<BankAccount> banks = new ArrayList<>();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String user = resultSet.getString("user");
                double balance = resultSet.getDouble("balance");
                String bankname = resultSet.getString("bankname");
                BankAccount bankacc = new BankAccount(id, user, balance, bankname);
                banks.add(bankacc);
            }
            return banks;

        }
        catch (Exception e){
            return new ArrayList<BankAccount>();
        }
    }

    public static boolean addInfo(String user, Double balance, String bankname){
        try {
            Connection connection = DatabaseConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO bank(user, balance, bankname)" +
                    "VALUES(?, ?, ?)");
            statement.setString(1, user);
            statement.setDouble(2, balance);
            statement.setString(3, bankname);

            statement.executeUpdate();

            statement.close();
            connection.close();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
