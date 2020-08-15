package messages;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String BUNDLE_NAME = "messages.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!'; //$NON-NLS-1$
		}
	}
	
	public static String getString(String key, String param) {
		try {
			return MessageFormat.format(getString(key), param);
		} catch (MissingResourceException e) {
			return '!' + key + '!'; //$NON-NLS-1$
		}
	}
	
	public static String buildURL(String secondPart) {
		try {
			return getString("General.webRoot") + secondPart; //$NON-NLS-1$
		} catch (MissingResourceException e) {
			return '!' + "General.webRoot" + '!'; //$NON-NLS-1$
		}
	}
	
	public static String urlFromKey(String key) {
		try {
			return buildURL(getString(key));
		} catch (MissingResourceException e) {
			return '!' + key + '!'; //$NON-NLS-1$
		}
	}
}
