package com.group11.Models;

public class PaymentMethod {

    int CardLogo;
    String CardName;
    String CardId;

    public PaymentMethod(int cardLogo, String cardName, String cardId) {
        CardLogo = cardLogo;
        CardName = cardName;
        CardId = cardId;
    }

    public int getCardLogo() {
        return CardLogo;
    }

    public void setCardLogo(int cardLogo) {
        this.CardLogo = cardLogo;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        this.CardName = cardName;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        this.CardId = cardId;
    }
}
