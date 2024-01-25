public class PowerBall {
	

	public static int[] generateTicket() {
		int[] ticket = new int[6];
		
		// create red ball number
		ticket[5] = (int) (Math.random()*26) +1;
		
		// create a bucket of 69 white balls
		int[] bucket = new int[69];

		// fill it with balls
		for (int i = 1; i < 70; i++) {
			bucket[i-1] = i;
		}

		// pick balls from the bucket, discard repeats
		int counter = 0;
		while (counter < 5) {
			int idx = (int) (Math.random()*69);
			System.out.println("counter = " +counter);
			System.out.println("bucket[idx] = " +bucket[idx]);
			System.out.println("ticket[counter] = " +ticket[counter]);
			if (bucket[idx] != 0) {
				ticket[counter] = bucket[idx]; // set ticket #
				bucket[idx] = 0; // remove ball from bucket
				counter++;
			}	
			System.out.println("ticket[counter-1] = " +ticket[counter-1]);
		}
		return ticket;
	}

	public static String showMeTheMoney(int[] ticket, int[] winningNumbers) {
		boolean powerBall = ticket[5] == winningNumbers[5];
		int whiteBallMatches = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (ticket[i] == winningNumbers[j]) {
					whiteBallMatches++;
				}
			}
		}
		if (whiteBallMatches == 5) {
			if (powerBall) {
				// JACKPOT!!
				return "Jackpot!! $40 Million bucks";
			}
			else {return "Matching 5 is good... here is $1 million bucks";}
		}
		else if ((whiteBallMatches == 4) && (powerBall)) {
			return "Almost, but not quite... here is $500k";
		}
		else {return "Thanks for playing, better luck next time.";}
	}



	public static void main(String[] args) {
		int[] ticket = generateTicket();
		//int[] ticket = {4,2,19,6,8,22};
		for (int i = 0; i < ticket.length; i++) {
			System.out.print(ticket[i]+" ");
		}
		System.out.println("");
		int[] winningNumbers = generateTicket();
		//int[] winningNumbers = {2,4,6,8,19,20};
		for (int i = 0; i < winningNumbers.length; i++) {
			System.out.print(winningNumbers[i]+" ");
		}
		System.out.println("");
		System.out.println(showMeTheMoney(ticket, winningNumbers));

	}
}