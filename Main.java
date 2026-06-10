import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee By ID");
            System.out.println("3. Search Employee By Name");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. View All Employees");
            System.out.println("7. Count Employees");
            System.out.println("8. Sort Employees By Salary");
            System.out.println("9. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    Employee emp =
                            new Employee(id, name, dept, salary);

                    dao.addEmployee(emp);

                    break;

                case 2:

                    System.out.print("Enter Employee ID: ");
                    dao.searchEmployee(sc.nextInt());

                    break;
                
                case 3:
                        sc.nextLine();

                        System.out.print("Enter Employee Name: ");
                        String searchName = sc.nextLine();

                        dao.searchEmployeeByName(searchName);

                        break;

                case 4:

                    System.out.print("Enter Employee ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();

                    dao.updateEmployee(updateId, newSalary);

                    break;

                case 5:

                    System.out.print("Enter Employee ID: ");
                    dao.deleteEmployee(sc.nextInt());

                    break;

                case 6:

                    dao.viewAllEmployees();

                    break;
                case 7:

                    dao.countEmployees();

                    break;

                case 8:
                    dao.sortEmployeesBySalary();
                    break;      
                case 9:         
                
                    System.out.println("Thank You!");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}