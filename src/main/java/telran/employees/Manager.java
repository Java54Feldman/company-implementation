package telran.employees;

import org.json.JSONObject;

public class Manager extends Employee {
	protected float factor;
	//Constructor of class Manager must take factor (see UML schema)
	public Manager() {
		
	};
	public Manager(long id, int basicSalary, String department, float factor) {
		super(id, basicSalary, department);
		this.factor = factor;
	}
	
	@Override
	public int computeSalary() {
		return Math.round(super.computeSalary() * this.factor);
	}
	
	@Override
	protected void fillJSONObject(JSONObject jsonObject) {
		fillClassName(jsonObject);
		super.fillJSONObject(jsonObject);
		jsonObject.put("factor", factor);
	}
	@Override
	protected void fillEmployee(JSONObject jsonObject) {
		super.fillEmployee(jsonObject);
		factor = jsonObject.getFloat("factor");
	}

	public float getFactor() {
		return factor;
	}

	public void setFactor(float factor) {
		this.factor = factor;
	}

}
