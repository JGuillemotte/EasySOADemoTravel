package net.webservicex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Random;

public class GlobalWeatherImpl implements IGlobalWeather {

	// ////////////////////////////////////////////////////
	// Fields
	// ////////////////////////////////////////////////////

	private static IGlobalWeather instance = new GlobalWeatherImpl();
	private Random rnd;
	private String cities_fr;
	private String cities_other;
	private String weather_format;
	private String[] skyConditions = { "mostly cloudy", "mostly clear", "overcast", "partly cloudy", "clear" };

	// ////////////////////////////////////////////////////
	// Constructor
	// ////////////////////////////////////////////////////

	private GlobalWeatherImpl() {
		rnd = new Random();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("/cities-fr.txt");
		cities_fr = convertStreamToString(in);
		cities_other = "<string></string>";

		in = this.getClass().getClassLoader().getResourceAsStream("/weather-format.txt");
		weather_format = convertStreamToString(in);
	}

	public static IGlobalWeather getInstance() {
		return instance;
	}

	// ////////////////////////////////////////////////////
	// GlobalWeather methods
	// ////////////////////////////////////////////////////

	public String getCitiesByCountry(String countryName) {
		if (countryName.equalsIgnoreCase("France")) {
			return cities_fr;
		} else {
			return cities_other;
		}
	}

	public String getWeather(String cityName, String countryName) {
		Date now = new Date();
		return String.format(weather_format, cityName, countryName, now.toString(), getRandomSkyConditions(), getRandomTemperature());
	}

	// ////////////////////////////////////////////////////
	// Helper methods
	// ////////////////////////////////////////////////////

	public String getRandomTemperature() {
		int tempC = rnd.nextInt(40);
		// celsius to fahrenheit
		int tempF = (int) ((9f / 5f) * (float) tempC + 32f);

		return tempF + " F (" + tempC + " C)";
	}

	public String getRandomSkyConditions() {
		int i = rnd.nextInt(skyConditions.length - 1);
		return skyConditions[i];
	}

	public String convertStreamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the
		 * BufferedReader.readLine() method. We iterate until the BufferedReader
		 * return null which means there's no more data to read. Each line will
		 * appended to a StringBuilder and returned as String.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}
}
