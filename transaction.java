public class transaction {
    private String transactionType;
    private double transactionAmount;
    public transaction (String transactionType, double transactionAmount ){
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }
    @Override
    public String toString(){
        return "Transaction type: "+transactionType+" Amount: "+transactionAmount;
    }
}