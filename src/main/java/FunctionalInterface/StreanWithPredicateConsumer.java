package FunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Employee{
	double salary;
	String name;
	public double getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee(String name, double salary) {
		super();
		this.salary = salary;
		this.name = name;
	}
		
}

public class StreanWithPredicateConsumer {
	
	public static void main(String[] args) {
		
		//http://java.boot.by/ocpjp8-upgrade-guide/ch03s04.html
		
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("John", 120000.0));
		emps.add(new Employee("Daniel", 112000.0));
		emps.add(new Employee("Dzmitry", 36000.0));
		emps.add(new Employee("Steven", 150000.0));
		
		Predicate<Employee> p = emp -> emp.salary > 100000.0;
		Consumer<Employee> c = emp -> System.out.println(emp);
		
		emps.stream().filter(p).forEach(c);
		
		
		Predicate<Employee> p1 = emp -> emp.salary > 100000.0;
		Predicate<Employee> p2 = emp -> emp.salary < 150000.0;
		//Consumer<Employee> c = emp -> System.out.println(emp);
		
		emps.stream().filter(p1).filter(p2).forEach(c);


		int i = 10;
		System.out.println(11+"ee");


	}

}
