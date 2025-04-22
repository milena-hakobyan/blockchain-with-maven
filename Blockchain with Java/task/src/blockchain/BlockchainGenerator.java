package blockchain;

public class BlockchainGenerator {
    private Blockchain blockchain;

    public BlockchainGenerator(){
        blockchain = new Blockchain();
    }

    public void generateBlockchain(){
        System.out.println("Enter");
        for(int i = 0; i < 5; i++)
            blockchain.generateBlock();
        for(Block block: blockchain.getList())
            block.printBlock();
    }

}
