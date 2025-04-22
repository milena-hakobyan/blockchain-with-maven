package blockchain;

import java.util.Scanner;

public class BlockchainGenerator {
    private Blockchain blockchain;
    private Scanner sc;

    public BlockchainGenerator(){
        blockchain = new Blockchain();
        sc = new Scanner(System.in);
    }

    public void generateBlockchain(){
        System.out.print("Enter how many zeros the hash must start with: ");
        int numOfZeros = sc.nextInt();
        System.out.println();
        for(int i = 0; i < 5; i++) {
            blockchain.generateBlock(numOfZeros);
        }
        for(Block block: blockchain.getList())
            block.printBlock();
    }

}
