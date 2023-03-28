package org.sol4kdemo;

import org.sol4k.Base58;
import org.sol4k.Connection;
import org.sol4k.Keypair;
import org.sol4k.PublicKey;
import org.sol4k.RpcUrl;
import org.sol4k.Transaction;
import org.sol4k.instruction.CreateAssociatedTokenAccountInstruction;

public class CreateAssociatedTokenAccount {
    public static void main(String[] args) {
        var connection = new Connection(RpcUrl.DEVNET);
        var blockhash = connection.getLatestBlockhash();
        // fund this account in case it is empty
        var payerWallet = Keypair.fromSecretKey(Base58.decode("2WGcYYau2gLu2DUq68SxxXQmCgi77n8hFqqLNbNyg6Xfh2m3tvg8LF5Lgh69CFDux41LUKV1ak1ERHUqiBZnyshz"));
        var usdcMintAddress = new PublicKey("Gh9ZwEmdLJ8DscKNTkTqPbNwLNNBjuSzaG9Vp2KGtKJr");
        var destinationWallet = Keypair.generate().getPublicKey();
        var associatedAccount = PublicKey.findProgramDerivedAddress(destinationWallet, usdcMintAddress);
        var instruction = new CreateAssociatedTokenAccountInstruction(
                payerWallet.getPublicKey(),
                associatedAccount.getPublicKey(),
                destinationWallet,
                usdcMintAddress
        );
        var transaction = new Transaction(
                blockhash,
                instruction,
                payerWallet.getPublicKey()
        );
        transaction.sign(payerWallet);
        var signature = connection.sendTransaction(transaction);
        System.out.println("Associated Token Account " + associatedAccount.getPublicKey());
        System.out.println("Transaction Signature: " + signature);
    }
}
