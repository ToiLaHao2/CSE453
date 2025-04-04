package com.classpractice7;

import java.util.Random;

public class TorpedoStore {

	// rate of failing to fire torpedos [0.0, 1.0]
	private double FAILURE_RATE = 0.0; // NOSONAR

	private int torpedoCount = 0;
	private static final Random generator = new Random();

	public TorpedoStore(int numberOfTorpedos) {
		this.torpedoCount = numberOfTorpedos;

		// update failure rate if it was specified in an environment variable
		String failureEnv = System.getenv("IVT_RATE");
		if (failureEnv != null) {
			try {
				FAILURE_RATE = Double.parseDouble(failureEnv);
			} catch (NumberFormatException nfe) {
				FAILURE_RATE = 0.0;
			}
		}
	}

	public boolean fire(int numberOfTorpedos) {
		if (numberOfTorpedos < 1 || numberOfTorpedos > this.torpedoCount) {
			throw new IllegalArgumentException("numberOfTorpedos");
		}

		boolean success = false;

		double r = generator.nextDouble();

		if (r >= FAILURE_RATE) {
			// successful firing
			this.torpedoCount = -numberOfTorpedos;
			success = true;
		} else {
			// simulated failure
			success = false;
		}

		return success;
	}

	public boolean isEmpty() {
		return this.torpedoCount <= 0;
	}

	public int getTorpedoCount() {
		return this.torpedoCount;
	}
}