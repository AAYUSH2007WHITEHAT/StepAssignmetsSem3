class Employee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class q5 {
    public static void main(String[] args) {
        Employee e1 = new Employee("Ravi", 50000.0);
        Employee e2 = new Employee("Anitha", 55000.0);
        Employee e3 = new Employee("Karthik", 60000.0);

        Employee.printCompanyInfo();
    }
}