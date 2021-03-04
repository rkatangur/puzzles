package org.examples.arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SlidingWindowOfReqs {

	/*
	 * 
	 * GET /api/city?lat=..&long=... HTTP/1.1
	 * 
	 * { "name": "San Francisco" // ... }
	 * 
	 */

	/*
	 * 10 per second.
	 * 
	 * Change GoogleMapsClient to rate limit HTTP requests made to Google Maps to 10
	 * per second.
	 * 
	 * Specifically, if a request should be rate limited, return
	 * "RATE LIMIT EXCEEDED" Otherwise, continue to, return "San Francisco"
	 */

	public static class HttpClient {
		public Map<String, Object> getJSON(String url) {
			// Pretend this makes an HTTP requests.
			Map<String, Object> response = new HashMap<>();
			response.put("name", "San Francisco");
			return response;
		}
	}

	/*
	 * 
	 * 0 1 2 |1 9|x | 19 requests in 200 milliseconds
	 * 
	 */

	/*
	 * 
	 * public GoogleMapsClient(int rps) public GoogleMapsClient(int reqLimit,
	 * Duration window) bool canMakeHttpCall() String getCurrentCity()
	 * 
	 */

	public static class GoogleMapsClient {
		private HttpClient httpClient = new HttpClient();
		private LinkedList<Long> reqTimesList = new LinkedList<>();

		public boolean canMakeHttpCall() {
			long curTime = System.currentTimeMillis();
			while (!reqTimesList.isEmpty()) {
				long firstReqTime = reqTimesList.peek();
				if (curTime - firstReqTime < 1000) {
					if (reqTimesList.size() >= 10) {
						return false;
					} else {
						break;
					}
				} else {
					reqTimesList.poll();
				}
			}
			reqTimesList.add(curTime);
			return true;
		}

		public String getCurrentCity() {
			if (canMakeHttpCall()) {
				Map<String, Object> res = httpClient.getJSON("https://maps.google.com/api/city?lat=..&long=..");
				return (String) res.get("name");
			} else {
				return "RATE LIMIT EXCEEDED";
			}
		}
	}

	// System.currentTimeMillis() == current time in milliseconds
	public static void main(String[] args) throws Exception {
		// Call getCurrentCity 30 times.
		//
		// 1 - 120982740147 - San Francisco
		// 2 - 120982740147 - San Francisco
		// ...
		// 30 - 120982740147 - San Francisco

		GoogleMapsClient client = new GoogleMapsClient();
		for (int i = 0; i < 30; i++) {
			if (i == 15 || i == 20) {
				Thread.sleep(500);
			}
			System.out.println(
					String.format("%s - %s - %s", i + 1, System.currentTimeMillis() / 1000, client.getCurrentCity()));
		}
	}
}
