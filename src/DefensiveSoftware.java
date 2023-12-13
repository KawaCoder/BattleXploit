public abstract class DefensiveSoftware {
    protected int installationTime;
    protected static String softwareName;
    protected int size;
    protected int price;
    protected  static String description;

    protected int firewallScore;
    protected int antivirusScore;
    protected int cryptoScore;
    protected int obfuscScore;



    /**
     * Met en pause le thread courant pendant le nombre de millisecondes spécifié.
     *
     * @param milliseconds La durée en millisecondes pendant laquelle le thread doit être en pause.
     */
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Affiche une barre de progression simulée pendant une opération.
     *
     * @param totalSteps Le nombre total d'étapes dans l'opération.
     */
    public static void fakeProgressBar(int totalSteps) {
        int barLength = 30;
        char[] rollingChars = {'-', '-', '\\', '\\', '|', '|', '/', '/'};

        for (int i = 0; i <= totalSteps; i++) {
            double percentage = (double) i / totalSteps;
            int progress = (int) (percentage * 100);
            int filledLength = (int) (barLength * percentage);

            System.out.print("\r[");
            for (int j = 0; j < filledLength; j++) {
                System.out.print('-');
            }
            System.out.print('>');

            for (int j = filledLength + 2; j < barLength; j++) {
                System.out.print(' ');
            }

            System.out.print("]");
            System.out.print(" - " + progress + "% ");

            int rollingIndex = progress % rollingChars.length;
            System.out.print(rollingChars[rollingIndex]);

            sleep(100);
        }
    }


    public String getName(){
        return(softwareName);

    }
    public int getPrice(){
        return(price);

    }

    public String getDescription(){
        return(description);
    }

    /**
     * Installe le logiciel défensif.
     * Affiche un message d'installation, simule une barre de progression et indique la fin de l'installation.
     */
    public void install() {
        System.out.println("Installing " + getName() + "...");
        fakeProgressBar(installationTime * 10);
        System.out.println("\nInstallation complete.\n");
    }


}