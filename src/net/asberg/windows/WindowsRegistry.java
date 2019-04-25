package net.asberg.windows;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

// Borrowed from: https://transoceanic.blogspot.com/2011/12/java-read-key-from-windows-registry.html

class WindowsRegistry {
	static String ReadKey(String path, String key) {
		try {
			Process p = Runtime.getRuntime().exec("reg query \"" + path + "\" /v " + key);

			StreamReader sr = new StreamReader(p.getInputStream());
			sr.start();
			p.waitFor();
			sr.join();

			String[] result = sr.toString().split("\\s+");
			if (result.length > 1) {
				return result[result.length - 1];
			}
		}
		catch (Exception ignored) { }

		return null;
	}

	private WindowsRegistry() { }

	private static class StreamReader extends Thread {
		private final InputStream is;
		private final StringWriter sw;

		StreamReader(InputStream is) {
			this.is = is;
			this.sw = new StringWriter();
		}

		public void run() {
			try {
				int s;
				while ((s = is.read()) != -1) {
					sw.write(s);
				}
			}
			catch (IOException ignored) { }

			sw.flush();
		}

		@Override
		public String toString() {
			return sw.toString();
		}
	}
}
