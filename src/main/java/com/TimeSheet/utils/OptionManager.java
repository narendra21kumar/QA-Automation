package com.TimeSheet.utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OptionManager {
	public ChromeOptions getChromeOptions() {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);

		return options;

	}

	public EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();

		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(EdgeOptions.CAPABILITY, options);
		options.merge(cp);

		return options;

	}
}
