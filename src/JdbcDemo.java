import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {
        // 1. 准备连接参数 (协议:子协议://IP:端口/数据库名)
        String url = "jdbc:mysql://localhost:3306/db_test";
        String user = "root";
        String password = "lh828828"; // 换成你自己的数据库密码

        // 准备带“占位符”的 SQL 语句
        String sql = "SELECT emp_name FROM employee WHERE dept_id = ?";

        // 这里的 try-with-resources 语法会自动帮我们完成第 6 步的释放资源 (close)
        try (
                // 2. 获取连接
                Connection conn = DriverManager.getConnection(url, user, password);
                // 3. 创建预编译执行对象
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            // 填空题：把 SQL 里第一个问号 ? 替换成数字 1
            pstmt.setInt(1, 1);

            // 4. 执行查询，拿到结果集
            ResultSet rs = pstmt.executeQuery();

            // 5. 处理结果集：像一个光标一样往下按行读取
            while (rs.next()) {
                // 把当前这一行的 emp_name 这一列的数据拿出来
                String name = rs.getString("emp_name");
                System.out.println("查到研发部员工：" + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}