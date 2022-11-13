package bitcoin;

import bitcoin.dto.Crypto;
import bitcoin.dto.Transaction;
import bitcoin.dto.UTXO;
import bitcoin.dto.UTXOPool;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ziyou.cxf
 * @version : TxHandler.java, v 0.1 2022年07月12日 9:45 ziyou.cxf Exp $
 */
public class TxHandler {

    private UTXOPool utxoPool;

    /**
     * Creates a public ledger whose current UTXOPool
     * (collection of unspent transaction outputs) is utxoPool.
     * This should  make a defensive copy of utxoPool by using
     * the UTXOPool (UTXOPool uPool) constructor.
     */
    public TxHandler(UTXOPool utxoPool) {
        this.utxoPool = utxoPool;
    }

    /**
     * Returns true if
     * (1) all outputs claimed by tx are in the current UTXO pool
     * (2) the signatures on each input of tx are valid
     * (3) no UTXO is claimed multiple times by tx
     * (4) all of tx’s output values are non-negative
     * (5) the sum of tx’s input values is greater than or equal
     * to the sum of its output values; and false otherwise.
     */
    public boolean isValidTx(Transaction tx) {
        UTXOPool uniqueUtxos = new UTXOPool();
        BigDecimal previousTxOutSum = BigDecimal.ZERO;
        BigDecimal currentTxOutSum = BigDecimal.ZERO;
        for (int i = 0; i < tx.numInputs(); i++) {
            Transaction.Input input = tx.getInput(i);
            UTXO utxo = new UTXO(input.prevTxHash, input.outputIndex);
            if (!utxoPool.contains(utxo)) {
                return false;
            }
            Transaction.Output txOutput = utxoPool.getTxOutput(utxo);
            if (!Crypto.verifySignature(txOutput.address, tx.getRawDataToSign(i), input.signature)) {
                return false;
            }
            if (uniqueUtxos.contains(utxo)) {
                return false;
            }
            uniqueUtxos.addUTXO(utxo, txOutput);
            previousTxOutSum = previousTxOutSum.add(txOutput.value);
        }

        for (Transaction.Output out : tx.getOutputs()) {
            if (out.value.compareTo(BigDecimal.ZERO) < 0) {
                return false;
            }
            currentTxOutSum = currentTxOutSum.add(out.value);
        }
        return previousTxOutSum.compareTo(currentTxOutSum) >= 0;
    }

    /**
     * Handles each epoch by receiving an unordered array of
     * proposed transactions, checking each transaction for
     * correctness, returning a mutually valid array of accepted
     * transactions, and updating the current UTXO pool as
     * appropriate.
     */
    public Transaction[] handleRxs(Transaction[] possibleTxs) {
        Set<Transaction> validTxs = new HashSet<>();
        for (Transaction tx : possibleTxs) {
            if (isValidTx(tx)) {
                validTxs.add(tx);
                for (Transaction.Input in : tx.getInputs()) {
                    UTXO utxo = new UTXO(in.prevTxHash, in.outputIndex);
                    utxoPool.removeUTXO(utxo);
                }
                for (int i = 0; i < tx.numOutputs(); i++) {
                    Transaction.Output output = tx.getOutput(i);
                    UTXO utxo = new UTXO(tx.getHash(), i);
                    utxoPool.addUTXO(utxo, output);
                }
            }
        }

        Transaction[] transactions = new Transaction[validTxs.size()];
        return validTxs.toArray(transactions);
    }
}
