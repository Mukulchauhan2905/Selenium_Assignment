package com.nagarro.testclasses;

public class DataProvider {
	
	/*This method provides data input to the test case addProductsToShoppingCart() in TestClass.
	 * Data is provided in the below format as user wants to search for two different products and add to the shopping cart
	 * product1, product2
	 * This format can be changed  based on the requirements.
	 */
	
	@org.testng.annotations.DataProvider(name = "productData")
	public static Object[][] getProductData() {
		return new Object[][] {
			{"iphone 11", "canon camera"}
			};
	}

	@org.testng.annotations.DataProvider(name = "userData")
	public static Object[][] userData() {
		return new Object[][] {
			{"user@gmail.com", "passowrd"}
			};
	}
	
	@org.testng.annotations.DataProvider(name = "locationData")
	public static Object[][] locationData() {
		return new Object[][] {
			{"250110"}
			};
	}
	
	@org.testng.annotations.DataProvider(name = "deleteProductData")
	public static Object[][] getDeleteProductData() {
		return new Object[][] {
			{"iphone cover"}
			};
	}
	
}