package es.uco.pw.util;

public class HTMLConverter {
	public static String parseToHTML(String original) {
		StringBuilder builder = new StringBuilder();
		boolean previousWasASpace = false;
		for (char c : original.toCharArray()) {
			if (c == ' ') {
				if (previousWasASpace) {
					builder.append("&nbsp;"); //$NON-NLS-1$
					previousWasASpace = false;
					continue;
				}
				previousWasASpace = true;
			} else {
				previousWasASpace = false;
			}
			switch (c) {
			case '<':
				builder.append("&lt;"); //$NON-NLS-1$
				break;
			case '>':
				builder.append("&gt;"); //$NON-NLS-1$
				break;
			case '&':
				builder.append("&amp;"); //$NON-NLS-1$
				break;
			case '"':
				builder.append("&quot;"); //$NON-NLS-1$
				break;
			case '\n':
				builder.append("<br>"); //$NON-NLS-1$
				break;
			// We need Tab support here, because we print StackTraces as HTML
			case '\t':
				builder.append("&nbsp; &nbsp; &nbsp;"); //$NON-NLS-1$
				break;
			default:
				if (c < 128) {
					builder.append(c);
				} else {
					builder.append("&#").append((int) c).append(";"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
		return builder.toString();
	}
}
