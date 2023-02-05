# sol4k demo [![Build](https://github.com/sol4k/sol4k-demo/actions/workflows/build.yml/badge.svg)](https://github.com/sol4k/sol4k-demo/actions/workflows/build.yml)

Sending transactions using sol4k in Java. Create a connection,
request the latest blockhash, and submit a SOL transfer
transaction from one account to another.

Imports:
```java
import org.sol4k.Base58;
import org.sol4k.Connection;
import org.sol4k.Keypair;
import org.sol4k.PublicKey;
import org.sol4k.Transaction;
import org.sol4k.TransferInstruction;
```

Sending 1000 Lamport from one account to another:

```java
var connection = new Connection("https://api.devnet.solana.com");
var latestBlockhash = connection.getLatestBlockhash();
var sender = Keypair.fromSecretKey(Base58.decode("2WGcYY..."));
var receiver = new PublicKey("DxPv2QMA5cWR5Xfg7tXr5YtJ1EEStg5Kiag9HhkY1mSx");
var instruction = new TransferInstruction(sender.getPublicKey(), receiver, 1000);
var transaction = new Transaction(
        latestBlockhash.getBlockhash(),
        instruction,
        sender.getPublicKey()
);
transaction.sign(sender);
var signature = connection.sendTransaction(transaction);
System.out.println("Transaxction Signature: " + signature);
```