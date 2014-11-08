package com.eintern.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.cdyne.ws.WeatherWS.ForecastReturn;
import com.cdyne.ws.WeatherWS.WeatherLocator;
import com.cdyne.ws.WeatherWS.WeatherReturn;
import com.cdyne.ws.WeatherWS.WeatherSoap;

public class WeatherClient {

	public static void main(String[] args) {
		//check website for the WSDL: http://http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL
		//check website for functionality: http://http://wsf.cdyne.com/WeatherWS/Weather.asmx
		
		WeatherLocator weatherLoc = new WeatherLocator();
		WeatherSoap weatherSoap = null;
		WeatherReturn weatherReturn = null;
		ForecastReturn forecastReturn = null;
		try {
			
			weatherSoap = weatherLoc.getWeatherSoap();
			weatherReturn = weatherSoap.getCityWeatherByZIP("90210");
			forecastReturn = weatherSoap.getCityForecastByZIP("90210");
		}catch(ServiceException e){
			System.out.println("couldn't get WeatherSoap");
		}
		catch(RemoteException e){
			System.out.println("couldn't get WeatherReturn or ForecastReturn");
		}
		
		System.out.println(weatherReturn.getCity());
		System.out.println(weatherReturn.getState());
		System.out.println(weatherReturn.getDescription());
		System.out.println(weatherReturn.getRemarks());
		System.out.println(weatherReturn.getTemperature());
		System.out.println();
		System.out.println(forecastReturn.getForecastResult()[3].getProbabilityOfPrecipiation().getNighttime());

	}

}
