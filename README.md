# Basic Blockchain using JAVA
Basic blockchain using java.

## Installation
[Gson](https://github.com/google/gson) is necessary.  
This project uses a library to handle Json called Gson. A example introduction of Gson using Maven, it would be okay to write as follows.

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.2</version>
</dependency>
```

No other special installation is required. It is okay if there is an environment where Java can be compiled and executed. (I am using IntelliJ)

## Features
- [x] Block
- [x] Basic Blockchain
- [x] Transaction
- [ ] Wallet
- [ ] P2P Mining

## Classes
### Block
  Block class is the most fundamental class in blockchain.  
  It has the following variables.
  - Index (`int`)  
    The index of that block.
  - Timestamp (`long`)  
    Unix timestamp of the time block was created.
  - Transactions (`ArrayList<Transaction >`)  
    The transactions until the end of Proof of Work is entered as ArrayList.
  - Proof (`int`)  
    The result of Proof of Work.
  - Previous Hash (`String`)  
    Hash value of the previous block. Also, the previous block also contains the previous hash value. For this reason, this hash value was generated based on all past blocks, which is exactly the continuity and invariance of blockchain.

### Transaction
  Transaction is the transaction that blocks have.  
  It has the following variables.
  - Sender (`String`)  
    The address of the sender of the coin.
  - Recipient (`String`)  
    The address of the recipient to send the coin.
  - Amount (`long`)  
    The amount of coins to send.

### Blockchain
  The blockchain class is the blockchain itself. This connect the block where Transaction is written like a chain.  
  It has the following variables.
  - Difficulty (`int`)  
    The difficulty of Proof of Work.
  - Transactions (`ArrayList<Transaction>`)  
    The transaction written when the next block is generated.
  - Chain (`ArrayList<Block>`)  
    A blockchain. It is the core.

## Hash
  The hash value of the block is calculated from `SHA-256`.
  ```java
  public class Block {

    ...

    public String hash() {
        return Utils.applySHA256(this.toString());
    }
  }
  ```
  The argument `input` gives the block class converted to Json style String type using Gson.

## Author
**Shion Fukushima** - [Twitter(@shion1118)](https://twitter.com/shion1118)

In virtual currency, blockchain we can not understand its true value, truth. Should we rediscover it or is it naturally appearing?  
It seems like art.
