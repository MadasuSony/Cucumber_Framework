package stepDefinition;

import commonFunctions.FunctionLibrary;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerDefinition 
{
	@Given("user launch the browser")
	public void user_launch_the_browser() throws Throwable {
	    FunctionLibrary.startBrowser();
	}
	@When("user launch the Url")
	public void user_launch_the_url() {
	    FunctionLibrary.openUrl();
	}
	@When("user wait for Username with {string} and {string}")
	public void user_wait_for_username_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.waitForElement(LocatorType, LocatorValue, "10");
	}
	@When("user enter Username with {string} and {string} and {string}")
	public void user_enter_username_with_and_and(String LocatorType, String LocatorValue, String TestData) {
	    FunctionLibrary.typeAction(LocatorType, LocatorValue, TestData);
	}
	@When("user enter Password with {string} and {string} and {string}")
	public void user_enter_password_with_and_and(String LocatorType, String LocatorValue, String TestData) {
	    FunctionLibrary.typeAction(LocatorType, LocatorValue, TestData);
	}
	@When("user click on login button with {string} and {string}")
	public void user_click_on_login_button_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.clickAction(LocatorType, LocatorValue);
	}
	@When("wait for Customer link with {string} and {string}")
	public void wait_for_customer_link_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.waitForElement(LocatorType, LocatorValue, "10");
	}
	@When("click on customer link with {string} and {string}")
	public void click_on_customer_link_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.clickAction(LocatorType, LocatorValue);
	}
	@When("wait for add icon with {string} and {string}")
	public void wait_for_add_icon_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.waitForElement(LocatorType, LocatorValue, "10");
	}
	@When("click add icon with {string} and {string}")
	public void click_add_icon_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.clickAction(LocatorType, LocatorValue);
	}
	@When("wait for customer number with {string} and {string}")
	public void wait_for_customer_number_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.waitForElement(LocatorType, LocatorValue, "10");
	}
	@When("capture customer number with {string} and {string}")
	public void capture_customer_number_with_and(String LocatorType, String LocatorValue) throws Throwable {
	    FunctionLibrary.captureCus(LocatorType, LocatorValue);
	}
	@When("enter in {string} with {string} and {string}")
	public void enter_in_with_and(String TestData, String LocatorType, String LocatorValue) {
	    FunctionLibrary.typeAction(LocatorType, LocatorValue, TestData);
	}
	@When("click add button with {string} and {string}")
	public void click_add_button_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.clickAction(LocatorType, LocatorValue);
	}
	@When("wait for confirm ok button with {string} and {string}")
	public void wait_for_confirm_ok_button_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.waitForElement(LocatorType, LocatorValue, "10");
	}
	@When("click confirm ok button with {string} and {string}")
	public void click_confirm_ok_button_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.clickAction(LocatorType, LocatorValue);
	}
	@When("wait for Alert ok button with {string} and {string}")
	public void wait_for_alert_ok_button_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.waitForElement(LocatorType, LocatorValue, "10");
	}
	@When("click Alert ok button with {string} and {string}")
	public void click_alert_ok_button_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.clickAction(LocatorType, LocatorValue);
	}
	@When("vaidate customer table")
	public void vaidate_customer_table() throws Throwable {
	    FunctionLibrary.customerTable();
	}
	@When("click on logout with {string} and {string}")
	public void click_on_logout_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.clickAction(LocatorType, LocatorValue);
	}
	@Then("close Application Browser")
	public void close_application_browser() {
	    FunctionLibrary.closeBrowser();
	}
	@When("wait for Supplier link with {string} and {string}")
	public void wait_for_supplier_link_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.waitForElement(LocatorType, LocatorValue, "10");
	}
	@When("click on Supplier link with {string} and {string}")
	public void click_on_supplier_link_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.clickAction(LocatorType, LocatorValue);
	}
	@When("vaidate Supplier table")
	public void vaidate_supplier_table() throws Throwable {
	    FunctionLibrary.supplierTable();
	}
	@When("wait for supplier number with {string} and {string}")
	public void wait_for_supplier_number_with_and(String LocatorType, String LocatorValue) {
	    FunctionLibrary.waitForElement(LocatorType, LocatorValue, "10");
	}
	@When("capture supplier number with {string} and {string}")
	public void capture_supplier_number_with_and(String LocatorType, String LocatorValue) throws Throwable {
	    FunctionLibrary.captureSup(LocatorType, LocatorValue);
	}
}
