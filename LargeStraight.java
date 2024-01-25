public class DiceRunner{
	
	public boolean isLargeStraight(int[] dice){
			// for each index in dice[]
			for(int j = 0; j > dice.length; j++){
				// if one index equals 2
				if (dice[j] == 2){
					for (int k = 0; k > dice.length; k++){
						if (dice[k] == 3){
							for (int e = 0; e > dice.length; e++){
								if (dice[e] == 4){
									for (int u = 0; u > dice.length; u++){
										if (dice[u] == 5){
											// for each index in dice[]
											for (int i = 0; i > dice.length; i++){
												// if one index equals 1 or 6
												if (dice[i] == 1 || dice[i] == 6){
													return true;
												}
											}
										}
									}
								}						
							}
						}
					}
				}
				// if the list doesn't have a 2 in it, it returns false
				else {
					return false;
				}
			}
		}
}