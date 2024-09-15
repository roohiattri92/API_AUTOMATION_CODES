package Payloads;

public class Payload2_dp 
{
	public static String dataprovider_input(String isbn,String aisle)
	{
		String inputdata="{\r\n"
				+ "\"name\":\"Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"Johnn foe\"\r\n"
				+ "}";
		return inputdata;
	}

}
