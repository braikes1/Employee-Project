public class Employee {
    private int employeeID;
    private String name;
    private String department;
    private double salary;
    private String designation;

    // Constructor
    public Employee(int employeeID, String name, String department, double salary, String designation) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.designation = designation;
    }

    // Accessor and mutator methods
    public int getEmployeeID() { return employeeID; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String getDesignation() { return designation; }

    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setDesignation(String designation) { this.designation = designation; }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return designation.equals(employee.designation);
    }

    // addBonus method
    public double addBonus() {
        return salary + 200; // Default bonus
    }

    // display method
    public void display() {
        System.out.println("Employee ID: " + employeeID + "\nName: " + name +
                "\nDepartment: " + department + "\nSalary: $" + salary +
                "\nDesignation: " + designation);
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String name, String department, double salary, String designation) {
        super(employeeID, name, department, salary, designation);
    }

    @Override
    public double addBonus() {
        return getSalary() + 300; // Manager bonus
    }
}

class Clerk extends Employee {
    public Clerk(int employeeID, String name, String department, double salary, String designation) {
        super(employeeID, name, department, salary, designation);
    }

    @Override
    public double addBonus() {
        return getSalary() + 100; // Clerk bonus
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "John", "HR", 3000.0, "Employee");
        Manager manager = new Manager(2, "Alice", "Finance", 4000.0, "Manager");
        Clerk clerk = new Clerk(3, "Bob", "Admin", 2500.0, "Clerk");

        Employee[] employees = {employee, manager, clerk};

        for (Employee emp : employees) {
            emp.display();
            System.out.println("Salary with Bonus: $" + emp.addBonus() + "\n");
        }

        double totalDeductions = 0;
        double deductionPerDay = 150.0;
        int[] absences = {2, 3, 4};

        for (int i = 0; i < employees.length; i++) {
            double deductions = absences[i] * deductionPerDay;
            System.out.println(employees[i].getName() + " Deductions was absent for " + absences[i] + " days: $" + deductions);
            totalDeductions += deductions;
        }
        System.out.println("Total Deductions: $" + totalDeductions);
    }
}