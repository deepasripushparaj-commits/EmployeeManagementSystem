import java.sql.*;

public class EmployeeDAO {

    public void addEmployee(Employee emp) {

        String sql =
                "INSERT INTO employee(id,name,department,salary) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, emp.getId());
            pst.setString(2, emp.getName());
            pst.setString(3, emp.getDepartment());
            pst.setDouble(4, emp.getSalary());

            pst.executeUpdate();

            System.out.println("Employee Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchEmployee(int id) {

        String sql =
                "SELECT * FROM employee WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                System.out.println("\nEmployee Found");
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Department : " +
                        rs.getString("department"));
                System.out.println("Salary : " +
                        rs.getDouble("salary"));

            } else {
                System.out.println("Employee Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(int id, double salary) {

        String sql =
                "UPDATE employee SET salary=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setDouble(1, salary);
            pst.setInt(2, id);

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("Employee Updated Successfully!");
            else
                System.out.println("Employee Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {

        String sql =
                "DELETE FROM employee WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("Employee Deleted Successfully!");
            else
                System.out.println("Employee Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAllEmployees() {

        String sql = "SELECT * FROM employee";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n===== Employees =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("department") + " | " +
                        rs.getDouble("salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchEmployeeByName(String name) {

    String sql = "SELECT * FROM employee WHERE name=?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, name);

        ResultSet rs = pst.executeQuery();

        boolean found = false;

        while (rs.next()) {

            found = true;

            System.out.println("\nEmployee Found");
            System.out.println("ID : " + rs.getInt("id"));
            System.out.println("Name : " + rs.getString("name"));
            System.out.println("Department : " + rs.getString("department"));
            System.out.println("Salary : " + rs.getDouble("salary"));
            System.out.println("---------------------------");
        }

        if (!found) {
            System.out.println("Employee Not Found");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void countEmployees() {

    String sql = "SELECT COUNT(*) FROM employee";

    try (Connection con = DBConnection.getConnection();
         Statement st = con.createStatement()) {

        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {
            System.out.println("Total Employees: " + rs.getInt(1));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void sortEmployeesBySalary() {

    String sql = "SELECT * FROM employee ORDER BY salary DESC";

    try (Connection con = DBConnection.getConnection();
         Statement st = con.createStatement()) {

        ResultSet rs = st.executeQuery(sql);

        System.out.println("\n===== Employees Sorted By Salary =====");

        while (rs.next()) {

            System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("salary"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}   
}
