public class PowerBall {
    //Run 100000 possible tickets and winning numbers
    public static void main(String args[]) {
        int[] ticket = new int[6];
        int[] winningNumbers = new int[6];
        int[] reward = new int[100000];
        int[][] order = new int[6][100000];
        winningNumbers = generateTicket();
        System.out.println("Here are the winning Numbers");
        for(int i=0; i<5; i++){
            System.out.print(winningNumbers[i] + " ");
        }
        System.out.print("[" + winningNumbers[5] + "]");
        System.out.println("\n>>>>>>>>>>>>><<<<<<<<<<<<");
        for(int i=1; i<=100000; i++){
            ticket = generateTicket();
            System.out.print(i + ") ");
            for(int j =0; j<5; j++){
                System.out.print(ticket[j] + " ");
            }
            System.out.print("[" + ticket[5] + "]");
            reward[i-1] = showMeTheMoney(ticket, winningNumbers);
            System.out.print("\t Reward = $" + reward[i-1] + "\n");
        }
        System.out.print(">>>>>>>>>>>>><<<<<<<<<<<<<<<");
        int[] counter = new int[6];
        for(int i=0; i<100000; i++){
            if(reward[i] == 40000000){
                order[0][counter[0]] = i;
                counter[0]++;
            }
            else if(reward[i]==1000000){
                order[1][counter[1]] = i;
                counter[1]++;
            }
            else if(reward[i]==500000){
                order[2][counter[2]] = i;
                counter[2]++;
            }
            else if(reward[i]==100){
                order[3][counter[3]] = i;
                counter[3]++;
            }
            else if(reward[i]==7){
                order[4][counter[4]] = i;
                counter[4]++;
            }
            else if(reward[i]==4){
                order[5][counter[5]] = i;
                counter[5]++;
            }
        }
        System.out.println("\nThe number of reward for $40,000,000 is shown below");
        System.out.println(counter[0] + "time(s)");
        System.out.println("The order are listed below");
        for(int i=0; i<counter[0]; i++){
            System.out.println(order[0][i] + 1 + ")");
        }
        System.out.println("\nThe number of reward for $1,000,000 is shown below");
        System.out.println(counter[1] + "time(s)");
        System.out.println("The order are listed below");
        for(int i=0; i<counter[1]; i++){
            System.out.println(order[1][i] + 1 + ")");
        }
        System.out.println("\nThe number of reward for $50,000 is shown below");
        System.out.println(counter[2] + "time(s)");
        System.out.println("The order are listed below");
        for(int i=0; i<counter[2]; i++){
            System.out.println(order[2][i] + 1 + ")");
        }
        System.out.println("\nThe number of reward for $100 is shown below");
        System.out.println(counter[3] + "time(s)");
        System.out.println("The order are listed below");
        for(int i=0; i<counter[3]; i++){
            System.out.println(order[3][i] + 1 + ")");
        }
        System.out.println("\nThe number of reward for $7 is shown below");
        System.out.println(counter[4] + "time(s)");
        System.out.println("The order are listed below");
        for(int i=0; i<counter[4]; i++){
            System.out.println(order[4][i] + 1 + ")");
        }
        System.out.println("\nThe number of reward for $4 is shown below");
        System.out.println(counter[5] + "time(s)");
        System.out.println("The order are listed below");
        for(int i=0; i<counter[5]; i++){
            System.out.println(order[5][i] + 1 + ")");
        }
    }
    //generate ticket 5 normal balls and 1 power ball
    public static int[] generateTicket(){
        int[] ticket = new int[6];
        ticket[5] = (int)(Math.random()*26 + 1);
        ticket[0] = (int)(Math.random()*69 + 1);
        int temp;
        while(true){
            temp = (int)(Math.random()*69 + 1);
            if(temp!=ticket[0]){
                ticket[1] = temp;
                break;
            }
        }
        while(true){
            temp = (int)(Math.random()*69 + 1);
            if(temp!=ticket[0] && temp!=ticket[1]){
                ticket[2] = temp;
                break;
            }
        }
        while(true){
            temp = (int)(Math.random()*69 + 1);
            if(temp!=ticket[0] && temp!=ticket[1] && temp!=ticket[2]){
                ticket[3] = temp;
                break;
            }
        }
        while(true){
            temp = (int)(Math.random()*69 + 1);
            if(temp!=ticket[0] && temp!=ticket[1] && temp!=ticket[2] && temp!=ticket[3]){
                ticket[4] = temp;
                break;
            }
        }
        return ticket;
    }
    //tell the result by comparing the ticket and winningNumbers
    public static int showMeTheMoney (int[] ticket, int[] winningNumbers){
        int reward = 0;
        for(int i = 0; i<=4; i++){
            for(int j = 0; j<= 4; j++){
                if(ticket[i] == winningNumbers[j]){
                    ticket[i] = 0;
                }
            }
        }
        int counter = 0;
        for(int k =0; k<=4; k++){
            if(ticket[k]==0){
                counter++;
            }
        }
        if(counter == 5 && ticket[5] == winningNumbers[5]){
            reward = 40000000;
        }
        else if(counter == 5 && ticket[5] != winningNumbers[5]){
            reward = 1000000;
        }
        else if(counter == 4 && ticket[5] == winningNumbers[5]){
            reward = 50000;
        }
        else if(counter == 4 && ticket[5] != winningNumbers[5]){
            reward = 100;
        }
        else if(counter == 3 && ticket[5] == winningNumbers[5]){
            reward = 100;
        }
        else if(counter == 3 && ticket[5] != winningNumbers[5]){
            reward = 7;
        }
        else if(counter == 2 && ticket[5] == winningNumbers[5]){
            reward = 7;
        }
        else if(counter == 1 && ticket[5] == winningNumbers[5]){
            reward = 4;
        }
        else if(counter == 0 && ticket[5] == winningNumbers[5]){
            reward = 4;
        }
        return reward;
    }
}