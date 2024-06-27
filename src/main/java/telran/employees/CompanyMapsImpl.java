package telran.employees;

import java.util.*;

//So far we do consider optimization
public class CompanyMapsImpl implements Company {
	TreeMap<Long, Employee> employees = new TreeMap<>();
	HashMap<String, List<Employee>> employeesDepartment = new HashMap<>();
	TreeMap<Float, List<Manager>> factorManagers = new TreeMap<>();

	@Override
	public Iterator<Employee> iterator() {
		return employees.values().iterator();
	}

	@Override
	public void addEmployee(Employee empl) {
		Employee newEmpl = employees.putIfAbsent(empl.getId(), empl);
		if (newEmpl != null) {
			throw new IllegalStateException();
		}
		addToDepartment(empl);
		addToManagers(empl);

	}

	private void addToManagers(Employee empl) {
		if (empl instanceof Manager) {
			factorManagers.computeIfAbsent(((Manager) empl).getFactor(), k -> new LinkedList<Manager>())
					.add((Manager) empl);
		}

	}

	private void addToDepartment(Employee empl) {
		employeesDepartment.computeIfAbsent(empl.getDepartment(), k -> new LinkedList<Employee>()).add(empl);

	}

	@Override
	public Employee getEmployee(long id) {
		return employees.get(id);
	}

	@Override
	public Employee removeEmployee(long id) {
		Employee removed = getEmployee(id);
		if(removed == null) {
			throw new NoSuchElementException();
		}
		employees.remove(id);
		if (removed instanceof Manager) {
			List<Manager> managerList = factorManagers.get(removed.getDepartment());
			managerList.remove(removed);
			removeFactor(((Manager) removed).getFactor());
		}
		return removed;
	}

	private void removeFactor(float factor) {
		if(factorManagers.get(factor) == null) {
			factorManagers.remove(factor);
		}
		
	}

	@Override
	public int getDepartmentBudget(String department) {
		int res = 0;
		if (employeesDepartment.get(department) != null) {
			res = employeesDepartment.get(department).stream().mapToInt(Employee::computeSalary).sum();
		}
		return res;
	}

	@Override
	public String[] getDepartments() {
		return employeesDepartment.keySet().stream().sorted().toArray(String[]::new);
	}

	@Override
	public Manager[] getManagersWithMostFactor() {
		Manager[] res = new Manager[0];
		if(!factorManagers.isEmpty()) {
			float mostFactor = factorManagers.lastKey(); 
			res = factorManagers.get(mostFactor).stream().toArray(Manager[]::new);
		}
		return res;
	}

}
