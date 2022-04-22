package com.zensar;

import javax.persistence.EntityManager;

import com.zensar.bean.Address;
import com.zensar.bean.BankAccount;
import com.zensar.bean.Employee;
import com.zensar.bean.Skill;
import com.zensar.util.JPAUtil;

public class App {
	
	public static void loadTesting()
	{
	
		
		EntityManager em=JPAUtil.createEntityManager("PU");
		Employee employee=em.find(Employee.class, 1);
		System.out.println(employee);
		
		
		JPAUtil.shutDown();
	}
	public static void insertTesting()
	{
		//persist to employee object
		
		Employee employee=new Employee("Suma", 25000, null, null, null);
		Address address=new Address("Bangalore", "581205", employee);
		BankAccount account=new BankAccount("88790");
		Skill skill=new Skill("Java", 8);
		employee.setAddress(address);
		address.setEmployee(employee);
		employee.setAccount(account);
		employee.setSkillList(skill);
		
		EntityManager em=JPAUtil.createEntityManager("PU");
		
		em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
		
	}
	
  public static void main(String[] args) {
	  insertTesting();
    
  }
}
