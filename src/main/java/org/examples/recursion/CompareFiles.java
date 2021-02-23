package org.examples.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * If the JVM can hold the data from file1 and file2 in heap then this program
 * can process the data from two files and compare the lines. If line1 from
 * file-1 matches with line2 from file-1 it would move else it would record the
 * lines in unprocessedFile1Lines and unprocessedFile2Lines as applicable.
 * 
 * @author rkata
 *
 */
public class CompareFiles {

	/**
	 * If the file1 and file2 have unsorted data compare two data files and if there
	 * is any discrepancy it would be added to the discrepancy file.
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

			// Using a set to hold unprocessed lines from file-1
			HashSet<String> unprocessedFile1Lines = new HashSet<String>();

			// Using a set to hold unprocessed lines from file-2
			HashSet<String> unprocessedFile2Lines = new HashSet<String>();

			while (true) {
				if (line1 == null && line2 == null) {
					break;
				} else {
					// if the data is sorted then
					if (line1 != null && line2 != null) {

						if (!line1.equals(line2)) {
							// check if line1 is seen before in file-2 and if it is it will be in
							// unprocessedFile2Lines
							if (unprocessedFile2Lines.contains(line1)) {
								// line 1 is seen in file-2
								unprocessedFile2Lines.remove(line1);
							} else {
								// if line1 not seen in unprocessedFile2Lines, record it in
								// unprocessedFile1Lines
								unprocessedFile1Lines.add(line1);
							}

							// check if line2 is seen before in file-1 if it is it will be in
							// unprocessedFile1Lines
							if (unprocessedFile1Lines.contains(line2)) {
								// line 2 is seen in file-1
								unprocessedFile1Lines.remove(line2);
							} else {
								// if not seen in unprocessedFile1Lines, record it in unprocessedFile2Lines
								unprocessedFile2Lines.add(line2);
							}
						}
					} else {

						// Will write the unprocessedFileLines from file-1 and file-2 as discrepancies
						// to the discrepancy file when any one file ends.
						writeDiscrepencies(bw, unprocessedFile1Lines, unprocessedFile2Lines);

						if (line1 != null) {
							bw.write(line1);
						} else if (line2 != null) {
							bw.write(line2);
						}
					}
				}

				line1 = br1.readLine();
				line2 = br2.readLine();
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

	private void writeDiscrepencies(BufferedWriter bw, HashSet<String> unprocessedFile1Lines,
			HashSet<String> unprocessedFile2Lines) {
		if (!unprocessedFile1Lines.isEmpty()) {
			flushDiscrepencies(unprocessedFile1Lines, bw);
		}

		if (!unprocessedFile2Lines.isEmpty()) {
			flushDiscrepencies(unprocessedFile2Lines, bw);
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

	/**
	 * Remove the lines from unprocessedFileLines set and write it to discrepencies
	 * file
	 * 
	 * 
	 * @param unprocessedFileLines
	 * @param bWriter
	 */
	private void flushDiscrepencies(Set<String> unprocessedFileLines, BufferedWriter bWriter) {
		try {

			Iterator<String> ite = unprocessedFileLines.iterator();
			while (ite.hasNext()) {
				String line = ite.next();
				bWriter.write(line);
				ite.remove();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
