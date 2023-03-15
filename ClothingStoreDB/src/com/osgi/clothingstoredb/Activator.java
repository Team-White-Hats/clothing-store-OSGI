package com.osgi.clothingstoredb;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration serviceRegistration;
	
	DbContext connection = new DbContextImpl();


	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println(" Database Publisher Service Start....");
		DbContext connection = new DbContextImpl();
		serviceRegistration = bundleContext.registerService(DbContext.class.getName(),connection, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println(" Database Publisher Service Stop...");
		serviceRegistration.unregister();
		
	}

}
