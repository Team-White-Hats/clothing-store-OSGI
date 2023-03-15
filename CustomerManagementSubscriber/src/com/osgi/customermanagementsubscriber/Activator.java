package com.osgi.customermanagementsubscriber;

import com.osgi.customermanagementpublisher.CustomerService;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;



	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Start Customer Subscriber Service");
		
		serviceReference = bundleContext.getServiceReference(CustomerService.class.getName());
		
		
		CustomerService customerService = (CustomerService)bundleContext.getService(serviceReference);
		CustomerDashboard(customerService);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Good Bye");
		bundleContext.ungetService(serviceReference);
		
	}
	
	public void  CustomerDashboard(CustomerService customerService) {
		
		Scanner sc = new Scanner(System.in);
		
		int customerDashboardChoice;
		String choice = "y";
		
		System.out.println("\n\n");
		System.out.println("==============User Dashboard===============");
		System.out.println("1 => Customer Registration");
		/*System.out.println("2 => Request Book");
		System.out.println("3 => Get All Book Details");
		System.out.println("4 => Order Book");
		System.out.println("5 => Delete Customer");
		System.out.println("6 => Get Request Book Details");
		System.out.println("7 => Generate Request Book Details");
		System.out.println("8 => Generate Order Book Details");
		System.out.println("Please Select Your Option");
		*/
		customerDashboardChoice = Integer.parseInt(sc.nextLine().trim());
		
		switch (customerDashboardChoice) {
		case 1:
			
			customerService.addNewCustomer();
			CustomerDashboard(customerService);
			
			break;
		default:
			System.out.println("User Option has been incorrect please try again ");
			CustomerDashboard(customerService);
		}
		
	}
	
}
