package com.zcc.state;

public class Context {

	private IWeather weather;

	public IWeather getWeather() {
		return weather;
	}

	public void setWeather(IWeather weather) {
		this.weather = weather;
	}

	public String weatherMessage() {
		return weather.getWeather();
	}

}
