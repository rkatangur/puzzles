package org.examples.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class FileUtil {

	public static void main(String[] args) {
		File image = new File("C:\\Users\\rkatangu\\Pictures\\Untitled.png");
		DataInputStream dis = null;
		// try {
		// dis = new DataInputStream(new FileInputStream(image));
		// byte[] imageBytes = new byte[(int) image.length()];
		// dis.readFully(imageBytes);
		//
		// Document doc = new Document(imageBytes, "MyPhoto", new Date(),
		// "Raja");
		//
		// Gson gson = new GsonBuilder().create();
		// String jsonString = gson.toJson(doc);
		//
		// Document unMarshalled = gson.fromJson(jsonString, Document.class);
		//
		// System.out.println(jsonString.length() + "," + jsonString);
		// } catch (Exception e) {
		// e.printStackTrace();
		// } finally {
		//
		// }
	}

	public static URL getFileFromClassPath(String filePath) {
		return ClassLoader.getSystemResource(filePath);
	}

	public static String buildS3FilePath(String fileName, String... dirPathVars) {
		StringBuffer fPath = new StringBuffer();
		if (dirPathVars != null) {
			for (String dirPath : dirPathVars) {
				fPath.append(dirPath).append("/");
			}
		}
		fPath.append(fileName);
		return fPath.toString();
	}

	public static InputStream findFile(String path) {
		InputStream fileInputStream = getContextOrClassLoader().getResourceAsStream(path);
		if (fileInputStream == null) {
			fileInputStream = FileUtil.class.getResourceAsStream(path);
		}

		if (fileInputStream == null) {
			fileInputStream = FileUtil.class.getClassLoader().getResourceAsStream(path);
		}

		if (fileInputStream == null) {
			fileInputStream = ClassLoader.getSystemResourceAsStream(path);
		}
		return fileInputStream;
	}

	public static ClassLoader getClassLoader() {
		return FileUtil.class.getClassLoader();
	}

	public static ClassLoader getContextOrClassLoader() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		if (cl == null)
			return getClassLoader();
		else
			return cl;
	}

}
