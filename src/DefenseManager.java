import java.util.*;

public class DefenseManager {

    public static int firewall_score = 0;
    public static int antivirus_score = 50;
    public static int crypto_score = 0;
    public static  int obfusc_score = 0;
    public static int budget = 10;
    public static int boost = 2;

    public static int attackEncourted = 0;
    public static final int ATTACK_LIMIT = 10;
    private static List<String> installedSoftware = new ArrayList<>();

    /**
     * Gère les défenses installées par le joueur et met à jour le budget de défense de manière périodique.
     * Le constructeur initialise la liste des logiciels installés et lance une tâche planifiée pour augmenter le budget.
     */
    public DefenseManager() {
        installedSoftware = new ArrayList<>();

    }

    public static boolean CheckWin(){
        return (attackEncourted >= ATTACK_LIMIT);
    }

    /**
     * Détermine si une attaque est bloquée.
     * @param type Le type d'attaque subie.
     * @return True si l'attaque est bloquée, False sinon.
     */
    public static boolean BlockAttack(String type){
        int attackValue = (int) (Math.random() * 200) + 1;
        int compared_value = 0;
        switch (type){

            case "ransom":
                compared_value = DefenseManager.crypto_score+DefenseManager.antivirus_score;
                break;

            case "ddos":
                compared_value = DefenseManager.firewall_score+DefenseManager.antivirus_score;
                break;

            case "obfusc":
                compared_value = DefenseManager.firewall_score+DefenseManager.obfusc_score;
                break;

        }
        if (attackValue < compared_value) {
            return true;
        }
        else {
            attackEncourted++;
            return false;
        }
    }

    /**
     * Affiche les détails d'un logiciel défensif et demande une confirmation d'achat.
     *
     * @param dfs Le logiciel défensif que le joueur envisage d'acheter.
     * @return True si le joueur confirme l'achat, False sinon.
     */
    private static boolean confirm_buy(DefensiveSoftware dfs) {
        int prix = dfs.getPrice();

        System.out.println("Budget restant : " + budget);
        System.out.println("Prix : " + prix);
        System.out.println(dfs.getDescription());
        System.out.println("\n\u001B[33mEtes-vous sûr(e) de vouloir acheter \u001B[36m" + dfs.getName() + " \u001B[33m?\u001B[0m");

        String reponse = new Scanner(System.in).nextLine();
        return reponse.equals("oui");
    }

    /**
     * Installe un logiciel défensif sur le système.
     *
     * @param software Le logiciel défensif à installer.
     */
    public static void installSoftware(DefensiveSoftware software) {
        if (!isInstalled(software)) {
            if (confirm_buy(software)) {
                // Installe le logiciel et met à jour les scores
                software.install();
                firewall_score += software.firewallScore;
                antivirus_score += software.antivirusScore;
                crypto_score += software.cryptoScore;
                obfusc_score += software.obfuscScore;

                // Ajoute le nom du logiciel à la liste des logiciels installés et déduit le coût du budget
                installedSoftware.add(software.getName());
                budget -= software.price;
            }
        } else {
            // Affiche un message si le logiciel est déjà installé
            System.out.println("\u001B[31m[!]\u001B[0m Vous avez déjà installé ce logiciel.");
        }
    }


    public static List<String> getInstalledSoftware() {
        return installedSoftware;
    }

    /**
     * Génère une représentation visuelle des informations sur les logiciels défensifs installés,
     * y compris les scores associés et le budget disponible.
     *
     * @return Une chaîne de caractères représentant les informations sur les logiciels défensifs et le budget.
     */
    public static String print_info() {
        return (String.format("\n             ,----------------,              ,---------,\n" +
                        "        ,-----------------------,          ,\"        ,\"|\n" +
                        "      ,\"                      ,\"|        ,\"        ,\"  |\n" +
                        "     +-----------------------+  |      ,\"        ,\"    |\n" +
                        "     |  .-----------------.  |  |     +---------+      |\n" +
                        "     |  | \u001B[32mAntivirus : %s\u001B[0m |  |  |     | -==----'|      |\n" +
                        "     |  | \u001B[32mFirewall  : %s\u001B[0m |  |  |     |         |      |\n" +
                        "     |  | \u001B[32mChiffremt : %s\u001B[0m |  |  |/----|`---=    |      |\n" +
                        "     |  | \u001B[32mObfusc    : %s\u001B[0m |  |  |   ,/|==== ooo |      ;\n" +
                        "     |  | \u001B[32mC:\\>_\u001B[0m           |  |  |  // |(((( [33]|    ,\"\n" +
                        "     |  `-----------------'  |,\" .;'| |((((     |  ,\"\n" +
                        "     +-----------------------+  ;;  | |         |,\"\n" +
                        "        /_)______________(_/  //'   | +---------+\n\nBUDGET: %d $\n",
                String.format("%03d", antivirus_score),
                String.format("%03d", firewall_score),
                String.format("%03d", crypto_score),
                String.format("%03d", obfusc_score),
                budget));
    }


    public static boolean isInstalled(DefensiveSoftware software) {
        return installedSoftware.contains(software.getName());
    }
    public static String printIsInstalled(DefensiveSoftware software) {
        if(installedSoftware.contains(software.getName())){
            return("\u001B[32mInstallé\u001B[0m");
        }
        else{
            return "";
        }
    }


    /**
     * Affiche les scores associés aux différentes catégories de logiciels défensifs.
     * Les scores incluent le score du pare-feu, du logiciel antivirus, du chiffrement et de l'obfuscation.
     *
     * @return Les scores des défenses respectives.
     */
    public static String getScores() {
        return  "Capacité de défense de l'entreprise:" +
                "-Antivirus = " + antivirus_score +
                "-Firewall = " + firewall_score +
                "-Cryptographique = " + crypto_score +
                "-Obfusc = " + obfusc_score;
    }

}
