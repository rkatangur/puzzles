package org.examples.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class CompareSortedFiles {

	/**
	 * If the file1 and file2 have the data in sorted manner, it would generate the
	 * discrepencies in a new discrepanyFile.csv
	 * 
	 * @param file1
	 * @param file2
	 */
	public void compare(File file1, File file2) {

		BufferedWriter bw = null;
		BufferedReader br1 = null;
		BufferedReader br2 = null;

		try {
			bw = new BufferedWriter(new FileWriter(new File("discrepancyFile.csv")));
			br1 = new BufferedReader(new FileReader(file1));
			br2 = new BufferedReader(new FileReader(file2));

			String line1 = br1.readLine();
			String line2 = br2.readLine();

			LinkedList<String> unprocessedFile1Lines = new LinkedList<String>();
			LinkedList<String> unprocessedFile2Lines = new LinkedList<String>();

			while (true) {
				if (line1 == null && line2 == null) {
					break;
				} else {
					// if the data is sorted then
					if (line1 != null && line2 != null) {
						int compareToVal = line1.compareTo(line2);
						// line1 is less than line2
						if (compareToVal < 0) {
							// if there are any unprocessedFile2Lines write it as discrepencies file and
							// remove them from the list
							flushDiscrepencies(unprocessedFile2Lines, bw);

							unprocessedFile1Lines.add(line1);
							// move file1Reader
							line1 = br1.readLine();
						} else if (compareToVal > 0) {
							// if there are any unprocessedFile1Lines write it as discrepencies file and
							// remove them from the list
							flushDiscrepencies(unprocessedFile1Lines, bw);

							unprocessedFile2Lines.add(line2);
							// move file2Reader
							line2 = br2.readLine();
						} else {
							// both are equal
							// if there are any lines in unprocessedFile1Lines flush it to discrepancy file.
							// It may be empty too
							flushDiscrepencies(unprocessedFile1Lines, bw);
							// if there are any lines in unprocessedFile2Lines flush it to discrepancy file.
							// It may be empty too
							flushDiscrepencies(unprocessedFile2Lines, bw);

							line1 = br1.readLine();
							line2 = br2.readLine();
						}
					} else {

						// Will write the unprocessedFileLines from file-1 and file-2 as discrepancies
						// to the discrepany file when any one file ends.
						writeDiscrepencies(bw, unprocessedFile1Lines, unprocessedFile2Lines);

						if (line1 != null) {
							bw.write(line1);
							line1 = br1.readLine();
						} else if (line2 != null) {
							bw.write(line2);
							line2 = br2.readLine();
						}
					}
				}
			}

			writeDiscrepencies(bw, unprocessedFile1Lines, unprocessedFile2Lines);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeReader(br1);
			closeReader(br2);
			closeWriter(bw);
		}

	}

	private void closeReader(BufferedReader br2) {
		try {
			if (br2 != null) {
				br2.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeWriter(BufferedWriter bw) {
		try {
			if (bw != null) {
				bw.flush();
				bw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeDiscrepencies(BufferedWriter bw, LinkedList<String> unprocessedFile1Lines,
			LinkedList<String> unprocessedFile2Lines) {
		if (!unprocessedFile1Lines.isEmpty()) {
			flushDiscrepencies(unprocessedFile1Lines, bw);
		}

		if (!unprocessedFile2Lines.isEmpty()) {
			flushDiscrepencies(unprocessedFile2Lines, bw);
		}
	}

	/**
	 * Poll and Remove the lines from the linkedList and write it as discrepencies.
	 * 
	 * @param unprocessedFileLines
	 * @param bWriter
	 */
	private void flushDiscrepencies(LinkedList<String> unprocessedFileLines, BufferedWriter bWriter) {
		try {
			String line = unprocessedFileLines.poll();
			while (line != null) {
				bWriter.write(line);
				line = unprocessedFileLines.poll();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
