package ca.bcit.comp4613.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.displaytag.decorator.TableDecorator;

public class DateDecorator extends TableDecorator {

	DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	
	public String getDob () {
		Employee employee = (Employee) this.getCurrentRowObject();
		if(employee.getDob() != null) {
			return format.format(employee.getDob());
		}
		return "No DOB";
	}
}
