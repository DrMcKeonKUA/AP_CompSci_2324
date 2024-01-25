public class PowerBall{
	public static void RunPowerBall(){
		int[] win = {1,2,3,4,5,6};
		
		
		int ticketPrice = 2; 
		int[] ticket = new int[6];
		int jackpots = 3;

		for(int i = 1; i<= jackpots; i++){
			
			int got4 = 0;
			int got7 = 0;
			int got100 = 0;
			int got50k = 0;
			int gotmil = 0;
			boolean jack = false;
			int trials = 0;
			int grand = 0;
			while (!jack){
				
				ticket = generateTicket();
				int money = showMeTheMoney(ticket, win);
				grand += ticketPrice;
				trials++;
				jack = money == -2;
			}
			System.out.println("you got " + grand + " dollars in " + trials + " times!!!");
			System.out.println(trials/got4);
			System.out.println(trials/got7);
			System.out.println(trials/got100);
			System.out.println(trials/got50k);
			System.out.println(trials/gotmil);

		}
	}

	public static int[] generateTicket(){
		boolean[] bucket = new boolean[100];
		int[] result = new int[10];
		boolean repeat = true;
		int num = 0;
		while(repeat){
			repeat = false;
			for (int i = 0; i<5; i++){
				bucket[num] = false;
				num = (int) (Math.random() * 69) + 1;
				if (bucket[num]){
					repeat = true;
				}
				
				result[i] = num;
				bucket[num] = true;
			}

			// System.out.println("gen");
		}
		result[5] = (int) (Math.random() * 26) + 1;
		return result;
	}

	public static int showMeTheMoney(int[] ticket, int[] winningNumbers){
		boolean[] bucket = new boolean[100];
		int whiteMatch = 0;
		boolean red = ticket[5] == winningNumbers[5];

		for(int i = 0; i < 5; i++){
			bucket[ticket[i]] = true;
		}
		// for (int i = 1; i<= 69; i++){
		// 	System.out.print(i +" "+ bucket[i]+" ");
		// }

		for(int i = 0; i<5; i++){
			if (bucket[winningNumbers[i]]){
				whiteMatch++;
			}
		}
		if (whiteMatch == 5){
			if (red){
				return -2;
			}
			else{
				return 1000000;
			}
		}
		if (whiteMatch == 4){
			if (red){
				return 50000;
			}
			return 100;
		}
		if (whiteMatch == 3){
			if (red){
				return 100;
			}
			return 7;
		}
		if (whiteMatch == 2 && red){
			return 7;
		}
		if (red){
			return 4;
		}
		
		return 0;

	}
	public static void main(String[] args){
		PowerBall.RunPowerBall();


	}

}

