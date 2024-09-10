package org.sol4kdemo;

import org.sol4k.Base58;
import org.sol4k.Connection;
import org.sol4k.Keypair;
import org.sol4k.PublicKey;
import org.sol4k.TransactionMessage;
import org.sol4k.VersionedTransaction;
import org.sol4k.instruction.TransferInstruction;

import java.util.List;

public class TransactionWithMultipleInstructions {
    public static void main(String[] args) {
        var connection = new Connection("https://api.devnet.solana.com");
        var blockhash = connection.getLatestBlockhash();
        // fund this account in case it is empty
        var sender = Keypair.fromSecretKey(Base58.decode("2WGcYYau2gLu2DUq68SxxXQmCgi77n8hFqqLNbNyg6Xfh2m3tvg8LF5Lgh69CFDux41LUKV1ak1ERHUqiBZnyshz"));
        var firstReceiver = new PublicKey("DxPv2QMA5cWR5Xfg7tXr5YtJ1EEStg5Kiag9HhkY1mSx");
        var secondReceiver = new PublicKey("6UjfcYotsa9HhaCuZJFnFstcZNo5qL7sWyjnScFgYox4");
        var firstInstruction = new TransferInstruction(sender.getPublicKey(), firstReceiver, 1000);
        var secondInstruction = new TransferInstruction(sender.getPublicKey(), secondReceiver, 2000);
        var message = TransactionMessage.newMessage(
                sender.getPublicKey(),
                blockhash,
                List.of(firstInstruction, secondInstruction)
        );
        var transaction = new VersionedTransaction(message);
        transaction.sign(sender);
        var signature = connection.sendTransaction(transaction);
        System.out.println("Transaction Signature: " + signature);
    }
}
