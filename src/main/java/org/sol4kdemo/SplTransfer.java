package org.sol4kdemo;

import org.sol4k.Base58;
import org.sol4k.Connection;
import org.sol4k.Keypair;
import org.sol4k.PublicKey;
import org.sol4k.TransactionMessage;
import org.sol4k.VersionedTransaction;
import org.sol4k.instruction.SplTransferInstruction;

public class SplTransfer {
    public static void main(String[] args) {
        var connection = new Connection("https://api.devnet.solana.com");
        var blockhash = connection.getLatestBlockhash();
        // fund this account in case it is empty
        var holder = Keypair.fromSecretKey(Base58.decode("2WGcYYau2gLu2DUq68SxxXQmCgi77n8hFqqLNbNyg6Xfh2m3tvg8LF5Lgh69CFDux41LUKV1ak1ERHUqiBZnyshz"));
        var usdc = new PublicKey("Gh9ZwEmdLJ8DscKNTkTqPbNwLNNBjuSzaG9Vp2KGtKJr");
        // check CreateAssociatedTokenAccount example to find out how you can create one like this 👇
        var receiverAssociatedAccount = new PublicKey("8r2iVNBQgJi59YCdj2YXipguirWZhdysWpL4cEGorN1v");
        var holderAssociatedAccount = PublicKey.findProgramDerivedAddress(holder.getPublicKey(), usdc);
        var splTransferInstruction = new SplTransferInstruction(
                holderAssociatedAccount.getPublicKey(),
                receiverAssociatedAccount,
                usdc,
                holder.getPublicKey(),
                100,
                6
        );
        var message = TransactionMessage.newMessage(
                holder.getPublicKey(),
                blockhash,
                splTransferInstruction
        );
        var transaction = new VersionedTransaction(message);
        transaction.sign(holder);

        var signature = connection.sendTransaction(transaction);

        System.out.println("Transaction Signature: " + signature);
    }
}
