package Payloads;

public class Payload_1 
{
	public static String addData(String name, String job)
	{
		String details="{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
		return details;

	}

}