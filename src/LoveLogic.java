public class LoveLogic {
    public static void main(String[] args) {
        Brain him = new Brain("male");
        Brain her = new Brain("female");

        // Infinite loop of overthinking
        while (true) {
            him.think();
            her.think();
            Phone.checkPhoneStatus(him, her);
        }
    }
}

class Brain {
    private String gender;
    private int overthinkingLevel = 0;
    public boolean hasTexted = false;

    public Brain(String gender) {
        this.gender = gender;
    }

    public void think() {
        overthinkingLevel++;

        if (gender.equals("male")) {
            System.out.println("Him: If she loves me, she'll text me first...");
        } else {
            System.out.println("Her: If he loves me, he'll text me first...");
        }

        // Random chance of actually texting (but they never will)
        if (Math.random() > 1.0) {  // Impossible condition
            hasTexted = true;
            System.out.println(gender.equals("male") ? "He texted!" : "She texted!");
        }

        try {
            Thread.sleep(1000); // Simulate time spent staring at phone
        } catch (InterruptedException e) {
            System.out.println("Error: Phone battery died from too much waiting");
        }
    }
}

class Phone {
    public static void checkPhoneStatus(Brain him, Brain her) {
        if (!him.hasTexted && !her.hasTexted) {
            System.out.println("Both phones remain silent...");
            System.out.println("Current status: Still single and overthinking");
            System.out.println("---------------------");
        }
    }
}
