package telran.employees;

import java.util.*;
//So far we do consider optimization
public class CompanyMapsImpl implements Company {
	TreeMap<Long, Employee> employeees = new TreeMap<>();;
	HashMap<String, List<Employee>> employeesDepartment = new HashMap<>();
	TreeMap<Float, List<Manager>> factorManagers = new TreeMap<>();
	
	@Override
	public Iterator<Employee> iterator() {
		// TODO Auto-generated method stub
		//не нужен никакой класс
		//одна строка
		//мы писали такие методы
		return null;
	}

	@Override
	public void addEmployee(Employee empl) {
		// TODO Auto-generated method stub
		//как в linkedhashset
		//делает емплоя и помещает к тримэпы

	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee removeEmployee(long id) {
		// TODO Auto-generated method stub
		//
		return null;
	}

	@Override
	public int getDepartmentBudget(String department) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manager[] getManagersWithMostFactor() {
		// TODO Auto-generated method stub
		return null;
	}

}
