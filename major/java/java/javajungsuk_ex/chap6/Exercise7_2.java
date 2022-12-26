class StudaDeck{
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    StudaDeck(){
        for(int i=0;i < cards.length;i++) { int num = i%10+1;
            boolean isKwang = (i < 10)&&(num==1||num==3||num==8);
            cards[i] = new SutdaCard(num,isKwang);
        }

    }

    void Shuffle(){

    }

    StudaDeck pick(int index){


        return null;
    }

    StudaDeck pick(){

        return null;
    }
}

class SutdaCard{
    int num;
    boolean isKwang;

    SutdaCard(){
        this(1,true);
    }

    SutdaCard(int num, boolean isKwang){
        this.num = num;
        this.isKwang = isKwang;
    }

    public String toString(){
        return num + ( isKwang ? "K": "");
    }
}

public class Exercise7_2 {
    public static void main(String[] args) {
        StudaDeck deck = new StudaDeck();

        for(int i=0;i<deck.cards.length;i++){
            System.out.print(deck.cards[i]+",");
        }
    }
}
