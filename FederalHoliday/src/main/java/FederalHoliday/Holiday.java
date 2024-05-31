package FederalHoliday;

import java.util.List;

class Holiday {
    String date;    
	String localName;
    String name;
    String countryCode;
    boolean fixed;
    boolean global;
    List<String> types;
    List<String> counties;
    Integer launchYear;
    
    public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public boolean isFixed() {
		return fixed;
	}
	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}
	public boolean isGlobal() {
		return global;
	}
	public void setGlobal(boolean global) {
		this.global = global;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public List<String> getCounties() {
		return counties;
	}
	public void setCounties(List<String> counties) {
		this.counties = counties;
	}
	public Integer getLaunchYear() {
		return launchYear;
	}
	public void setLaunchYear(Integer launchYear) {
		this.launchYear = launchYear;
	}
}