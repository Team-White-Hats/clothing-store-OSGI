package com.osgi.customermanagementpublisher;

import com.osgi.clothingstoredb.DbContext;
import com.osgi.clothingstoredb.DbContextImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerImpl implements CustomerService {

	private Connection connection = null; 
	private Statement statement;
	private ResultSet  resultSet;
	private DbContext  dbContext;
	private static PreparedStatement preparedStatement = null;



	public CustomerImpl() {
		super();
		this.dbContext = new DbContextImpl();
		this.connection = dbContext.getDatabaseConnection();
	}

	@Override
	public void addNewCustomer() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		CustomerModel customerModel = new CustomerModel();

		System.out.println("****************************************************************************");
		System.out.println("****************************************************************************");
		System.out.println("*********************<<<<<<<<<< Customer Signup >>>>>>>>>>>*****************");
		System.out.println("****************************************************************************");
		System.out.println("****************************************************************************\n\n");

		System.out.println("Enter Your First Name ::");
		customerModel.setFirstName(sc.nextLine().trim());

		System.out.println("Enter Your Last Name ::");
		customerModel.setFirstName(sc.nextLine().trim());

		System.out.println("Enter Your Email ::");
		customerModel.setEmai(sc.nextLine().trim());

		System.out.println("Enter Your Phone Number ::");
		customerModel.setPhone(sc.nextLine().trim());

		System.out.println("Enter Your Password ::");
		customerModel.setPassword(sc.nextLine().trim());

		try {

			String query = "insert into user(firstName,lastName,email,phone,password) values(?,?,?,?,?) ";

			preparedStatement = connection.prepareStatement(query); 

			preparedStatement.setString(1,customerModel.getFirstName());
			preparedStatement.setString(2,customerModel.getLastName());
			preparedStatement.setString(3,customerModel.getEmail());
			preparedStatement.setString(4,customerModel.getPhone());
			preparedStatement.setString(5,customerModel.getPassword());

			int isSuccess = preparedStatement.executeUpdate();

			if(isSuccess > 0) {

				System.out.println("Registration Has Been Successfully");

			}else {

				System.out.println("Error has been orccured please try again");

			}


		}catch(Exception ex) {

			System.out.println("customerSaveError : " + ex.getMessage());
		}


	}










}
