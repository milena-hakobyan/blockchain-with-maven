package blockchain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        Blockchain blockchain = Blockchain.getInstance();
            try {
                for (int i = 0; i < 5; i++) {
                    List<Callable<Block>> callables = new ArrayList<>();
                    String prevHash = i==0?"0":blockchain.getLastBlock().getHash();
                    for(int m = 0; m < 10; m++){
                        int minderId = m + 1; //miner-IDs start from 1
                        callables.add(()->{
                            return new Block(prevHash, blockchain.getN(),minderId);
                        });
                    }
                    long startTime = System.currentTimeMillis();
                    Block block = executor.invokeAny(callables);
                    long endTime = System.currentTimeMillis();
                    if(blockchain.validateBlock(block))
                        blockchain.addBlock(block, endTime - startTime);
                    }
                    blockchain.printBlockChain();
                    executor.shutdown();
                    executor.awaitTermination(10, TimeUnit.SECONDS);
                } catch (ExecutionException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
    }
}
