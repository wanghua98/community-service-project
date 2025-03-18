package com.oceanstar.mapper;

import com.oceanstar.Pojo.User1;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Mapper
public interface usermapper {
    public static void main(String[] args) {
        // 数据库连接信息
        String url = "jdbc:mysql://localhost:3306/test"; // 替换为你的数据库URL
        String username = "root"; // 替换为你的数据库用户名
        String password = "123456"; // 替换为你的数据库密码

        // SQL 插入语句
        String sql = "INSERT INTO users (name, gender, id_card, date_of_birth, phone, emergency_contact1, emergency_contact2, address, identity, password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                // 1. 获取数据库连接
                Connection connection = DriverManager.getConnection(url, username, password);
                // 2. 创建 PreparedStatement 对象
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            // 3. 设置 SQL 参数
            statement.setString(1, "张三"); // name
            statement.setString(2, "男"); // gender
            statement.setString(3, "1234567890"); // id_card
            statement.setString(4, "1970-08-15"); // date_of_birth
            statement.setString(5, "1111"); // phone
            statement.setString(6, "2222"); // emergency_contact1
            statement.setString(7, "3333"); // emergency_contact2
            statement.setString(8, "北京"); // address
            statement.setString(9, "老年人"); // identity
            statement.setString(10, "A123456"); // password

            // 4. 执行 SQL 语句
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("数据插入成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insert(User1 user1);
}