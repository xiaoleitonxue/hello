import java.util.ArrayList;
import java.util.List;

public class manager {
    private static List<Employee> employees = new ArrayList<>();

    static {
        for (int i = 1; i <= 20; i++) {
            employees.add(new Employee("E" + i, "员工" + i, 20 + i, "部门" + i, 5000 + i * 100));
        }
    }

    public static List<Employee> getAllEmployees() {
        return employees;
    }

    public static Employee searchEmployee(String keyword) {
        for (Employee emp : employees) {
            if (emp.getId().equals(keyword) || emp.getName().contains(keyword)) {
                return emp;
            }
        }
        return null;
    }

    public static void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public static void updateEmployee(Employee emp) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(emp.getId())) {
                employees.set(i, emp);
                break;
            }
        }
    }

    public static void deleteEmployee(String id) {
        employees.removeIf(emp -> emp.getId().equals(id));
    }

    public static class Employee {
        private String id;
        private String name;
        private int age;
        private String department;
        private double salary;

        public Employee(String id, String name, int age, String department, double salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        public void setName(String name) { this.name = name; }
        public void setAge(int age) { this.age = age; }
        public void setDepartment(String department) { this.department = department; }
        public void setSalary(double salary) { this.salary = salary; }
    }
}
