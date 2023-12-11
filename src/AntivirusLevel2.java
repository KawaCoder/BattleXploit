public class AntivirusLevel2 extends DefensiveSoftware {
    public AntivirusLevel2() {
        softwareName = "AI Protect Pro";
        installationTime = 5;
        size = 50;
        price = 100;
        description = "AI Protect Pro - Votre bouclier numérique intelligent.\nUne protection puissante dans un format moyen, idéale pour sécuriser votre univers numérique.";

        firewallScore = 6;
        antivirusScore = 60;
        cryptoScore = 7;
        obfuscScore = 5;
    }

    @Override
    public void install() {
        System.out.println("Installing Antivirus Level 1...");
        fakeProgressBar(installationTime*10);
        System.out.println("\n");

    }
}