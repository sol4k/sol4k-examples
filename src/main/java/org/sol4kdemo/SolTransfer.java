package org.sol4kdemo;

import org.sol4k.Base58;
import org.sol4k.Connection;
import org.sol4k.Keypair;
import org.sol4k.PublicKey;
import org.sol4k.Transaction;
import org.sol4k.instruction.TransferInstruction;

public class SolTransfer {
    public static void main(String[] args) {
        var connection = new Connection("https://api.devnet.solana.com");
        var latestBlockhash = connection.getLatestBlockhash();
        // fund this account in case it is empty
        var sender = Keypair.fromSecretKey(Base58.decode("2WGcYYau2gLu2DUq68SxxXQmCgi77n8hFqqLNbNyg6Xfh2m3tvg8LF5Lgh69CFDux41LUKV1ak1ERHUqiBZnyshz"));
        var receiver = new PublicKey("DxPv2QMA5cWR5Xfg7tXr5YtJ1EEStg5Kiag9HhkY1mSx");
        var instruction = new TransferInstruction(sender.getPublicKey(), receiver, 1000);
        var transaction = new Transaction(
                latestBlockhash.getBlockhash(),
                instruction,
                sender.getPublicKey()
        );
        transaction.sign(sender);
        var signature = connection.sendTransaction(transaction);
        System.out.println("Transaction Signature: " + signature);
    }
}