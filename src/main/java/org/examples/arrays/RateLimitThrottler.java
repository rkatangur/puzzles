package org.examples.arrays;

/*
Imagine we are building an application that is used by many different customers. We want to avoid one customer being able to overload the system by sending too many requests, so we enforce a per-customer rate limit. The rate limit is defined as:

“Each customer can make X requests per Y seconds”

	Some of our customers have bursty traffic, and are complaining about being rate limited. We want to better accomodate those customers, so we want to adopt a ‘credit’ based system. It will work as follows:

	    For each bucket of time, any capacity available below the limit is converted into credits for that customer

	    There is some maximum number of credits that a customer can accumulate

	    When a customer exceeds their normal request limit for a window, the credit count starts to decrease. When there are 0 credits, the customer is rate limited.
*/
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RateLimitThrottler {

	int numOfReqsAllowed;
	int windowSizeInSecs;

	private Map<Integer, LinkedList<Long>> customerReqsMap = new HashMap<>();
	private Map<Integer, Integer> customerCreditsMap = new HashMap<>();

	public RateLimitThrottler(int numOfReqsAllowed, int windowSizeInSecs) {
		this.numOfReqsAllowed = numOfReqsAllowed;
		this.windowSizeInSecs = windowSizeInSecs;

	}

	// Perform rate limiting logic for provided customer ID. Return true if the
	// request is allowed, and false if it is not.
	boolean rateLimit(int customerId) {
		if (numOfReqsAllowed <= 0) {
			return false;
		}

		long reqTime = System.currentTimeMillis();
		LinkedList<Long> custReqs = customerReqsMap.get(customerId);
		if (custReqs == null) {
			custReqs = new LinkedList<>();
			customerReqsMap.put(customerId, custReqs);
		}

		long firstReqTime = -1;
		int creditsAvailable = 0;
		if (!custReqs.isEmpty()) {
			creditsAvailable = numOfReqsAllowed - custReqs.size();
		}
		
		boolean isNewWindow = false;
		while (!custReqs.isEmpty()) {
			firstReqTime = custReqs.peek();
			if (reqTime - firstReqTime > windowSizeInSecs * 1000) {
				// starting a new window;
				isNewWindow = true;
				custReqs.poll();
			} else {
				break;
			}
		}

		Integer availCredits = customerCreditsMap.getOrDefault(customerId, 0);

		// long firstReqTime = custReqs.peek();
		if (firstReqTime != -1 && custReqs.size() >= (numOfReqsAllowed + availCredits)) {
			return false;
		} else {
			if (isNewWindow) {
				customerCreditsMap.put(customerId, customerCreditsMap.getOrDefault(customerId, 0) + creditsAvailable);
			}
			custReqs.offer(reqTime);
			return true;
		}
	}

	public static void main(String[] args) {
		RateLimitThrottler solver = new RateLimitThrottler(3, 1);
		System.out.println(solver.rateLimit(123));
		try {
			Thread.sleep(1000);
		} catch (Exception exe) {
		}
		System.out.println(solver.rateLimit(123));
		System.out.println(solver.rateLimit(123));
		System.out.println(solver.rateLimit(123));
		System.out.println(solver.rateLimit(123));
		System.out.println(solver.rateLimit(123));
		System.out.println(solver.rateLimit(123));
		System.out.println(solver.rateLimit(123));
		System.out.println(solver.rateLimit(123));
	}

}
