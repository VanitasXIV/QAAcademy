package org.example;

public class EquipoAsignadoCard {
    int i;
    String cardContainerXpath;
    String cardTeamNameXpath;
    String cardCaptainNameXpath;
    String cardMembersPanelXpath;

    public EquipoAsignadoCard(int i){
        this.i = i;
        this.cardContainerXpath = String.format("/html/body/div[%s]/div/div", i+1);
        this.cardTeamNameXpath = cardContainerXpath + "/div[1]";
        this.cardCaptainNameXpath = cardContainerXpath + "/div[2]";
        this.cardMembersPanelXpath = cardContainerXpath + "/div[3]";
    }

    public void setCardContainerXpath(String cardContainerXpath) {
        this.cardContainerXpath = cardContainerXpath;
    }

    public String getCardContainerXpath() {
        return cardContainerXpath;
    }

    public void setCardTeamNameXpath(String cardTeamNameXpath) {
        this.cardTeamNameXpath = cardTeamNameXpath;
    }

    public String getCardTeamNameXpath() {
        return cardTeamNameXpath;
    }

    public void setCardCaptainNameXpath(String cardCaptainNameXpath) {
        this.cardCaptainNameXpath = cardCaptainNameXpath;
    }

    public String getCardCaptainNameXpath() {
        return cardCaptainNameXpath;
    }

    public void setCardMembersPanelXpath(String cardMembersPanelXpath) {
        this.cardMembersPanelXpath = cardMembersPanelXpath;
    }

    public String getCardMembersPanelXpath() {
        return cardMembersPanelXpath;
    }


}
