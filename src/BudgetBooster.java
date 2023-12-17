public class BudgetBooster extends DefensiveSoftware{

    public BudgetBooster() {
        softwareName = "Actions financières";
        installationTime = 1;
        size = 5;
        price = 10;
        description = "Boostez votre budget";
        BoostBudget();
    }
    @Override
    public void install() {
        System.out.println("Négociations en cours ...");
        fakeProgressBar(installationTime * 10);
        System.out.println("\nActions achetées\n");
    }

    public void BoostBudget(){
        DefenseManager.budget += 3;

    }

}
