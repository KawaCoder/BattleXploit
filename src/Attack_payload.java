public class Attack_payload {
    private String payloadName;
    private int firewallScore;
    private int antivirusScore;
    private int cryptoScore;
    private int obfuscScore;

    Attack_payload(String payloadName, int firewallScore, int antivirusScore, int cryptoScore, int obfuscScore){
        this.antivirusScore =  antivirusScore;
        this.firewallScore = firewallScore;
        this.payloadName = payloadName;
        this.cryptoScore = cryptoScore;
        this.obfuscScore = obfuscScore;

    }

    public String getPayloadData(String payloadName, int firewallScore, int antivirusScore, int cryptoScore, int obfuscScore) {
        return String.format("{\n" +
                "    \"payload_name\": \"%s\",\n" +
                "    \"firewall_score\": %d,\n" +
                "    \"antivirus_score\": %d,\n" +
                "    \"crypto_score\": %d,\n" +
                "    \"obfusc_score\": %d\n" +
                "}\n", payloadName, firewallScore, antivirusScore, cryptoScore, obfuscScore);
    }
}
